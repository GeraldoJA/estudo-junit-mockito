package testesGroup.video4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testesGroup.video3.Product;

@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	public void enviar( Product product, boolean frete) {
		
		System.out.println( "Produto: " + product.getName() + " enviado! - Frete: " + frete);
		Transportadora transportadora = new Transportadora();
		transportadora.setProductId(product.getId());
		transportadora.setFrete(frete);
		
		transportadoraRepository.save(transportadora);
	}

}
