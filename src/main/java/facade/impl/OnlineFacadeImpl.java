package facade.impl;

import java.util.HashMap;

import facade.subsystems.bank.BankSystem;
import facade.subsystems.bank.TransferRequest;
import facade.subsystems.biller.BillingPayRequest;
import facade.subsystems.biller.BillingSystem;
import facade.subsystems.crm.CRMSystem;
import facade.subsystems.crm.EmailSystem;
import facade.util.Customer;
import facade.util.OnMemoryDataBase;

public class OnlineFacadeImpl implements IPaymentFacade {

	private static final CRMSystem crmSystem = new CRMSystem();
	private static final BillingSystem billingSystem = new BillingSystem();
	private static final BankSystem bankSystem = new BankSystem();
	private static final EmailSystem emailSystem = new EmailSystem();

	@Override
	public PaymentResponse pay(PaymentRequest request) throws GeneralPaymentError {

		Customer customer = crmSystem.findCustomer(request.getCustomerId());
		if (customer == null) {
			throw new GeneralPaymentError("El cliente con id " + request.getCustomerId() + " no existe.");
		}

		if ("Baja".equalsIgnoreCase(customer.getStatus())) {
			throw new GeneralPaymentError("El cliente con id " + request.getCustomerId() + " está dado de baja");
		}

		if (request.getAmount() > billingSystem.queryCustomerBalance(customer.getId())) {
			throw new GeneralPaymentError("Se está intentando realizar un pago mayor al saldo del cliente");
		}

		// Pago bancario
		TransferRequest transfer = new TransferRequest(request.getAmount(), request.getCardNumber(),
				request.getCardName(), request.getCardExtDate(), request.getCardSecureNum());
		String payReference = bankSystem.transfer(transfer);

		// Afectactación del saldo en el sistema de facturación
		BillingPayRequest billingRequest = new BillingPayRequest(request.getCustomerId(), request.getAmount());
		double newBalance = billingSystem.pay(billingRequest);

		// El cliente se reactiva si el nuevo saldo es menor de 51
		String newStatus = customer.getStatus();
		if (newBalance <= 50) {
			OnMemoryDataBase.changeCustomerStatus(request.getCustomerId(), "Activo");
			newStatus = "Activo";
		}

		// Envio de la confirmación de pago por email.
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("$name", customer.getName());
		params.put("$amount", String.valueOf(request.getAmount()));
		params.put("$newBalance", String.valueOf(newBalance));
		String number = request.getCardNumber();
		String cardNumberSubfix = number.substring(number.length() - 4, number.length());
		params.put("$cardNumber", "**** **** **** " + cardNumberSubfix);
		params.put("$reference", payReference);
		params.put("$newStatus", newStatus);
		emailSystem.sendEmail(params);

		return new PaymentResponse(payReference, newBalance, newStatus);
	}

}
