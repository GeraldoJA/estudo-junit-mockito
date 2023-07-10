package test.rodrigo_freitas.video4;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.rodrigo_freitas.video3.Product;
import test.rodrigo_freitas.video3.ProductRepository;


@Service
public class ProductService4 {
	
	@Autowired
	private TransportadoraService transportadoraService;
	
	@Autowired
	private ProductRepository productRepository;
	 
	
	public void enviarParaTransportadora(int id, boolean frete) throws IllegalArgumentException {
		
		//vai retornar o objeto Mockado da classe PRoductServiceTest
		Optional<Product> productOpcional = this.productRepository.findById(id);  
		
		if( productOpcional.isPresent() ) {
			Product product = productOpcional.get();
			if( "PAGO".equals(product.getStatus()) ) {
				this.transportadoraService.enviar(product, frete);
			}
		}else {
			throw new IllegalArgumentException("id: " + id);
		}
	}
	
}
