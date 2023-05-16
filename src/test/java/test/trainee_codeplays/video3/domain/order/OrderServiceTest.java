package test.trainee_codeplays.video3.domain.order;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import test.trainee_codeplays.video2.domain.payment.PaymentService;
import test.trainee_codeplays.video2.domain.user.UserService;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderServiceTest {

	@Mock
	private PaymentService paymentService;
	@Mock
	private UserService userService;
	@InjectMocks
	private OrderService orderService;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		orderService = new OrderService(userService, paymentService, true);
	}
	
	@Test
	@DisplayName("Deve lanças uma exceção quando o usuário for menor de idade")
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
	@DisplayName("Deve liberar para o pagamento qunado o usuário for menor de idade")
	public void shouldPayWhenUserMajor() {
		orderService = new OrderService(userService, paymentService, false);
		Order order = new Order(2L);
		
		when( userService.isUserMinor(eq(2L)) ).thenReturn(false);
		doNothing().when(paymentService).pay();
		
		orderService.create(order);
		
		verify( userService, times(1)).isUserMinor(eq(2L));
		verify( paymentService, times(1)).pay();
	}

}
