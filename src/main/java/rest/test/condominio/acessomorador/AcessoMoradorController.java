package rest.test.condominio.acessomorador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessoMoradorController {
	
	@Autowired
	private AcessoMoradorService service;
	
	@RequestMapping("/AcessosMorador")
	public List<AcessoMorador> getAllAcessos(){
		
		return service.getAllAcessos();
		
	}
	
	@RequestMapping("/AcessosMorador/{id}")
	public AcessoMorador getAcesso(@PathVariable Integer id){
		
		return service.getAcesso(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/AcessosMorador")
	public void addAcesso(@RequestBody AcessoMorador Acesso){
		
		service.addAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/AcessosMorador/{id}")
	public void updateAcesso(@RequestBody AcessoMorador Acesso, @PathVariable String id){
		
		service.updateAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/AcessosMorador/{id}")
	public void deleteAcesso(@PathVariable Integer id){
		
		service.deleteAcesso(id);
		
	}

}