package facade.impl;

/**
 * Esta clase corresponde al request de la operacion pay de la fachada, la cual
 * tiene los datos mínimos apra aplicar un pago, los datos requeridos son el ID
 * del cliente y los datos de la tarjeta.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */

public class PaymentRequest {

	private Long customerId;
	private double amount;
	private String cardNumber;
	private String cardName;
	private String cardExtDate;
	private String cardSecureNum;

	public PaymentRequest() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardExtDate() {
		return cardExtDate;
	}

	public void setCardExtDate(String cardExtDate) {
		this.cardExtDate = cardExtDate;
	}

	public String getCardSecureNum() {
		return cardSecureNum;
	}

	public void setCardSecureNum(String cardSecureNum) {
		this.cardSecureNum = cardSecureNum;
	}

}
