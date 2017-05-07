package rest.test.condominio.acessomorador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcessoMoradorService {
	
	@Autowired
	private AcessoMoradorRepository repository;
	
	public List<AcessoMorador> getAllAcessos(){
		List<AcessoMorador> Acessos = new ArrayList<>();
		repository.findAll()
		.forEach(Acessos::add);
		return Acessos;
	}
	
	public AcessoMorador getAcesso(Integer id){
		return repository.findOne(id);
	}

	public void addAcesso(AcessoMorador Acesso) {
		repository.save(Acesso);		
	}

	public void updateAcesso(AcessoMorador Acesso) {
		repository.save(Acesso);
	}

	public void deleteAcesso(Integer id) {
		repository.delete(id);	
	}

}
