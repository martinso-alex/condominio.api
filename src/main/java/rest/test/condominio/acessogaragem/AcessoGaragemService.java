package rest.test.condominio.acessogaragem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoGaragemService {
	
	@Autowired
	private AcessoGaragemRepository AcessoGaragemRepository;
	
	public List<AcessoGaragem> getAllAcessos(){
		List<AcessoGaragem> Acessos = new ArrayList<>();
		AcessoGaragemRepository.findAll()
		.forEach(Acessos::add);
		return Acessos;
	}
	
	public AcessoGaragem getAcesso(Integer id){
		return AcessoGaragemRepository.findOne(id);
	}

	public void addAcesso(AcessoGaragem Acesso) {
		AcessoGaragemRepository.save(Acesso);		
	}

	public void updateAcesso(AcessoGaragem Acesso) {
		AcessoGaragemRepository.save(Acesso);
	}

	public void deleteAcesso(Integer id) {
		AcessoGaragemRepository.delete(id);	
	}

}
