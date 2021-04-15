package facade.impl;

/**
 * La interface IPaymentFacade define la estructura que la fachada de pago en
 * linea deberá de tener.
 *
 * @author Victor Hugo Aguilar Aguilar
 *
 */
public interface IPaymentFacade {

	public PaymentResponse pay(PaymentRequest paymentRequest) throws GeneralPaymentError;

}
