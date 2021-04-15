package facade;

import facade.impl.IPaymentFacade;
import facade.impl.OnlineFacadeImpl;
import facade.impl.PaymentRequest;

public class FacadeMain {

	public static void main(String[] args) {
		PaymentRequest request = new PaymentRequest();

		request.setAmount(1000);
		request.setCardExtDate("10/2015");
		request.setCardName("Victor Aguilar");
		request.setCardNumber("1234567890123456");
		request.setCardSecureNum("345");
		request.setCustomerId(1L);

		try {
			IPaymentFacade paymentFacade = new OnlineFacadeImpl();
			paymentFacade.pay(request);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
