package facade.subsystems.biller;

/**
 * Clase que representa el request del sistema de facturación el cual recibe el
 * ID del cliente y el monto a aplicar.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class BillingPayRequest {

	private Long customerId;
	private double amount;

	public BillingPayRequest(Long customerId, double amount) {
		super();
		this.customerId = customerId;
		this.amount = amount;
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

}
