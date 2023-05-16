package test.rodrigo_freitas.video3;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	public boolean canSave(Product product) {	
		return "PAGO".equals(product.getStatus());		
	}
}
