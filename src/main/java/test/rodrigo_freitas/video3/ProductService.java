package test.rodrigo_freitas.video3;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	 private ValidationService validationService;
	
	@Autowired
	 private ProductRepository productRepository;
	 
	
	public void save(Product product) {
		if( this.validationService.canSave(product) ) {
			this.productRepository.save(product);
		}
	}
	
	public void remove(int id) throws SQLException {
		
		Optional<Product> productOpcional = this.productRepository.findById(id);
		if( productOpcional.isPresent() ) {
			this.productRepository.deleteById(id);
		}else {
			throw new SQLException("o registro não existe");
		}
	}
}
