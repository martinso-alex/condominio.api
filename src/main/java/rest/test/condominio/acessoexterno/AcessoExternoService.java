package rest.test.condominio.acessoexterno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoExternoService {
	
	@Autowired
	private AcessoExternoRepository AcessoExternoRepository;
	
	public List<AcessoExterno> getAllAcessos(){
		List<AcessoExterno> Acessos = new ArrayList<>();
		AcessoExternoRepository.findAll()
		.forEach(Acessos::add);
		return Acessos;
	}
	
	public AcessoExterno getAcesso(Integer id){
		return AcessoExternoRepository.findOne(id);
	}

	public void addAcesso(AcessoExterno Acesso) {
		AcessoExternoRepository.save(Acesso);		
	}

	public void updateAcesso(AcessoExterno Acesso) {
		AcessoExternoRepository.save(Acesso);
	}

	public void deleteAcesso(Integer id) {
		AcessoExternoRepository.delete(id);	
	}

}
