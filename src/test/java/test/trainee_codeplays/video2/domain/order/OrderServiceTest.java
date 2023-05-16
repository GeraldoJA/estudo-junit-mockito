package test.trainee_codeplays.video2.domain.order;


import org.junit.jupiter.api.Test;

import test.trainee_codeplays.video2.domain.payment.PaymentService;
import test.trainee_codeplays.video2.domain.user.UserService;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceTest {

	private PaymentService paymentService = mock(PaymentService.class);
	private UserService userService = mock(UserService.class);
	private OrderService orderService = new OrderService(userService, paymentService);

	@Test
	public void shouldThrowAnExceptionWhenUserIsMinor() {
		
		when( userService.isUserMinor(eq(1L)) ).thenReturn(true);
		doNothing().when(paymentService).pay();
		
		Order order = new Order(1L);
		
		IllegalArgumentException exception = assertThrows( IllegalArgumentException.class, () -> orderService.create(order) );
		
		assertEquals("O usuário não pode ser menor de idade", exception.getMessage());
		verify( userService, times(1)).isUserMinor(eq(1L));
		verify( paymentService, times(0)).pay();
	}
	
	@Test
	public void shouldPayWhenUserMajor() {
		Order order = new Order(2L);
		
		when( userService.isUserMinor(eq(2L)) ).thenReturn(false);
		doNothing().when(paymentService).pay();
		
		orderService.create(order);
		
		verify( userService, times(1)).isUserMinor(eq(2L));
		verify( paymentService, times(1)).pay();
	}

}
