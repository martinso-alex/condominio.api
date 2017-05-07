package rest.test.condominio.apto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptoService {
	
	@Autowired
	private AptoRepository AptoRepository;
	
	public List<Apto> getAllAptos(){
		List<Apto> Aptos = new ArrayList<>();
		AptoRepository.findAll()
		.forEach(Aptos::add);
		return Aptos;
	}
	
	public Apto getApto(Integer id){
		return AptoRepository.findOne(id);
	}

	public void addApto(Apto Apto) {
		AptoRepository.save(Apto);		
	}

	public void updateApto(Apto Apto) {
		AptoRepository.save(Apto);
	}

	public void deleteApto(Integer id) {
		AptoRepository.delete(id);	
	}

}
