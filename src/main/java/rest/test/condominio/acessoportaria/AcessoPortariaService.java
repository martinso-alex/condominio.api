package rest.test.condominio.acessoportaria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoPortariaService {
	
	@Autowired
	private AcessoPortariaRepository AcessoPortariaRepository;
	
	public List<AcessoPortaria> getAllAcessos(){
		List<AcessoPortaria> Acessos = new ArrayList<>();
		AcessoPortariaRepository.findAll()
		.forEach(Acessos::add);
		return Acessos;
	}
	
	public AcessoPortaria getAcesso(Integer id){
		return AcessoPortariaRepository.findOne(id);
	}

	public void addAcesso(AcessoPortaria Acesso) {
		AcessoPortariaRepository.save(Acesso);		
	}

	public void updateAcesso(AcessoPortaria Acesso) {
		AcessoPortariaRepository.save(Acesso);
	}

	public void deleteAcesso(Integer id) {
		AcessoPortariaRepository.delete(id);	
	}

}
