package rest.test.condominio.morador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoradorService {
	
	@Autowired
	private MoradorRepository MoradorRepository;
	
	public List<Morador> getAllMoradors(){
		List<Morador> Moradors = new ArrayList<>();
		MoradorRepository.findAll()
		.forEach(Moradors::add);
		return Moradors;
	}
	
	public Morador getMorador(Integer id){
		return MoradorRepository.findOne(id);
	}

	public void addMorador(Morador Morador) {
		MoradorRepository.save(Morador);		
	}

	public void updateMorador(Morador Morador) {
		MoradorRepository.save(Morador);
	}

	public void deleteMorador(Integer id) {
		MoradorRepository.delete(id);	
	}

}
