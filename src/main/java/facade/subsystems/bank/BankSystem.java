package facade.subsystems.bank;

import java.util.UUID;

import facade.impl.GeneralPaymentError;
import facade.util.OnMemoryDataBase;

public class BankSystem {

	public String transfer(TransferRequest request) throws GeneralPaymentError {

		String cardNumberPrefix = request.getCardNumber().substring(0, 3);

		if (!OnMemoryDataBase.validateCardBins(cardNumberPrefix)) {
			throw new GeneralPaymentError("Tarjeta inválida");
		}

		String cardCompany = OnMemoryDataBase.getCardCompany(cardNumberPrefix);
		final int tamanoDTarjeta = request.getCardNumber().length();
		if ("AMEX".equalsIgnoreCase(cardCompany) && tamanoDTarjeta != 15) {
			throw new GeneralPaymentError("El número de tarjeta es inválido");
		}

		if (("VISA".contentEquals(cardCompany) || "MASTERCARD".equalsIgnoreCase(cardCompany))
				&& request.getCardNumber().length() != 16) {
			throw new GeneralPaymentError("El número de tarjeta es inválido");
		}

		String number = request.getCardNumber();
		String cardNumberSubfix = number.substring(number.length() - 4, number.length());

		System.out.println("Se ha realizado un cargo al cliente " + request.getCardName() + "\n" + "por el monto de "
				+ request.getAmount() + "€ a la tarjeta ***" + cardNumberSubfix);

		return UUID.randomUUID().toString();

	}

}
