package facade.subsystems.biller;

import facade.util.Customer;
import facade.util.OnMemoryDataBase;

/**
 * Representa al sistema de facturación
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class BillingSystem {

	public double queryCustomerBalance(Long customerId) {
		Customer customer = OnMemoryDataBase.findCustomerStatus(customerId);
		return customer.getBalance();
	}

	public double pay(BillingPayRequest billingPay) {
		Customer customer = OnMemoryDataBase.findCustomerStatus(billingPay.getCustomerId());
		customer.setBalance(customer.getBalance() - billingPay.getAmount());
		System.out.println(
				"Pago aplicado al cliente " + customer.getName() + ", el nuevo saldo es " + customer.getBalance());
		return customer.getBalance();
	}

}
