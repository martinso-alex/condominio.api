package rest.test.condominio.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControleService {
	
	@Autowired
	private ControleRepository ControleRepository;
	
	public List<Controle> getAllControles(){
		List<Controle> Controles = new ArrayList<>();
		ControleRepository.findAll()
		.forEach(Controles::add);
		return Controles;
	}
	
	public Controle getControle(Integer id){
		return ControleRepository.findOne(id);
	}

	public void addControle(Controle Controle) {
		ControleRepository.save(Controle);		
	}

	public void updateControle(Controle Controle) {
		ControleRepository.save(Controle);
	}

	public void deleteControle(Integer id) {
		ControleRepository.delete(id);	
	}

}
