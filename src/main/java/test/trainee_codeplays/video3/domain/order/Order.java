package test.trainee_codeplays.video3.domain.order;

import lombok.Data;

@Data
public class Order {
	
	private Long userId;

	public Order(Long userId) {
		super();
		this.userId = userId;
	}


}
