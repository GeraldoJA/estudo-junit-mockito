package test.trainee_codeplays.video3.domain.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import test.trainee_codeplays.video2.domain.payment.PaymentService;
import test.trainee_codeplays.video2.domain.user.UserService;

@Service
public class OrderService {

	private UserService userService;
	private PaymentService paymentService;
	private Boolean flag;
	
	public OrderService(UserService userService, PaymentService paymentService, @Value("${flag}") Boolean flag ) {
		this.flag = flag;
		this.userService = userService;
		this.paymentService = paymentService;
	}
	
	public void create( Order order ) {
		boolean isUserMinor = userService.isUserMinor( order.getUserId() );
		if( flag || isUserMinor ) {
			throw new IllegalArgumentException("O usuário não pode ser menor de idade");
		}
		
		paymentService.pay();
	}
}
