package test.rodrigo_freitas.video4;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import test.rodrigo_freitas.video3.Product;
import test.rodrigo_freitas.video3.ProductRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class ProductServiceTest {

	@Autowired
	private ProductService4 productService4;
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
		
	//TODO - atenção
	@MockBean
	private ProductRepository productRepository;

	@Test
	public void deveraEnviarParaTransportadoraOProdutoPago() {
		
		Product product = new Product(1, "camiseta", "PAGO",  BigDecimal.TEN);
		
		//TODO - o productRepository.findById vai ser chamado na classe ProductService4
		Mockito.when( this.productRepository.findById(Mockito.any()) ).thenReturn( Optional.of(product) );
		
		this.productService4.enviarParaTransportadora(1, true);
		
		Transportadora transportadora = this.transportadoraRepository.findById(1).get();
		
		Assertions.assertEquals( transportadora.getProductId(), 1);
		Assertions.assertTrue( transportadora.temFrete());
	}
	
	

}
