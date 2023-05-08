package testesGroup.teste.video3;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import testesGroup.video3.Product;
import testesGroup.video3.ProductRepository;
import testesGroup.video3.ProductService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class ProductServiceTest {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void deveraSalvarOProdutoPago() {
		
		Product product = new Product(1, "computador", "PAGO", new BigDecimal(2000) );
		
		this.productService.save(product);
		int size = this.productRepository.findAll().size();
		String name = this.productRepository.findById(1).get().getName();
		
		Assertions.assertEquals(1, size);
		Assertions.assertEquals("computador", name, "o nome está diferente");
	}
	
	@Test
	public void deveLancarUmaExceptionQuandoRemoverUmProdutoInexistente() {
		
		Assertions.assertThrows( SQLException.class, () -> 
			this.productService.remove(2) );
	}
	
	

}
