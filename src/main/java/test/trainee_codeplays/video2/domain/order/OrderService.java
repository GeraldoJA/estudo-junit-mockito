package test.trainee_codeplays.video2.domain.order;

import test.trainee_codeplays.video2.domain.payment.PaymentService;
import test.trainee_codeplays.video2.domain.user.UserService;

public class OrderService {

	private UserService userService;
	private PaymentService paymentService;
	
	public OrderService(UserService userService, PaymentService paymentService) {
		this.userService = userService;
		this.paymentService = paymentService;
	}
	
	public void create( Order order ) {
		boolean isUserMinor = userService.isUserMinor( order.getUserId() );
		if( isUserMinor ) {
			throw new IllegalArgumentException("O usuário não pode ser menor de idade");
		}
		
		paymentService.pay();
	}
}
