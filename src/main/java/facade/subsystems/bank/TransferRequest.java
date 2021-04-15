package facade.subsystems.bank;

/**
 * Clase que representa el request para el sistema bancario es la que recibe los
 * datos de la tarjeta según y el monton del cargo.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class TransferRequest {

	private double amount;
	private String cardNumber;
	private String cardName;
	private String cardExpDate;
	private String cardSecureNum;

	public TransferRequest(double amount, String cardNumber, String cardName, String cardExpDate, String cardSecureNum) {
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cardExpDate = cardExpDate;
		this.cardSecureNum = cardSecureNum;
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

	public void setCardNumer(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardExpDate() {
		return cardExpDate;
	}

	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public String getCardSecureNum() {
		return cardSecureNum;
	}

	public void setCardSecureNum(String cardSecureNum) {
		this.cardSecureNum = cardSecureNum;
	}

	@Override
	public String toString() {
		return "TransferRequest [amount=" + amount + ", cardNumber=" + cardNumber + ", cardName=" + cardName
				+ ", cardExpDate=" + cardExpDate + ", cardSecureNum=" + cardSecureNum + "]";
	}
	
	

}
