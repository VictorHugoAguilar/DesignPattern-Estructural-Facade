package facade.impl;

/**
 * Clase de exception custom que será lanzada cuando se presenta algún error en
 * el servicio de pago.
 * 
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public class GeneralPaymentError extends Exception {

	private static final long serialVersionUID = 1L;

	public GeneralPaymentError(String message) {
		super(message);
	}
}
