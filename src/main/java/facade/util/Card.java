package facade.util;

/**
 * Clase utilizada para representar la configuración de una tarjeta. En la clase
 * se incluye el prefijjo, la compañia y el tipo de tarjeta (debito o credito)
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class Card {

	private String prefix;
	private String company;
	private String cardType;

	public Card(String prefix, String company, String cardType) {
		this.prefix = prefix;
		this.company = company;
		this.cardType = cardType;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

}
