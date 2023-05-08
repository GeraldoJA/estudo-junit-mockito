package testesGroup.video3;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String status;
	
	private BigDecimal val;
	
	public Product() {
		super();
	}
	
	public Product(Integer id, String name, String status, BigDecimal val) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.val = val;
	}
		
	
}
