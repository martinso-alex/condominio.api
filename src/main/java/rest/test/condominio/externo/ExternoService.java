package rest.test.condominio.externo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternoService {
	
	@Autowired
	private ExternoRepository ExternoRepository;
	
	public List<Externo> getAllExternos(){
		List<Externo> Externos = new ArrayList<>();
		ExternoRepository.findAll()
		.forEach(Externos::add);
		return Externos;
	}
	
	public Externo getExterno(Integer id){
		return ExternoRepository.findOne(id);
	}

	public void addExterno(Externo Externo) {
		ExternoRepository.save(Externo);		
	}

	public void updateExterno(Externo Externo) {
		ExternoRepository.save(Externo);
	}

	public void deleteExterno(Integer id) {
		ExternoRepository.delete(id);	
	}

}
