package rest.test.condominio.acessoportaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessoPortariaController {
	
	@Autowired
	private AcessoPortariaService AcessoPortariaService;
	
	@RequestMapping("/AcessosPortaria")
	public List<AcessoPortaria> detAllAcessos(){
		
		return AcessoPortariaService.getAllAcessos();
		
	}
	
	@RequestMapping("/AcessosPortaria/{id}")
	public AcessoPortaria getAcesso(@PathVariable Integer id){
		
		return AcessoPortariaService.getAcesso(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/AcessosPortaria")
	public void addAcesso(@RequestBody AcessoPortaria Acesso){
		
		AcessoPortariaService.addAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/AcessosPortaria/{id}")
	public void updateAcesso(@RequestBody AcessoPortaria Acesso, @PathVariable String id){
		
		AcessoPortariaService.updateAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/AcessosPortaria/{id}")
	public void deleteAcesso(@PathVariable Integer id){
		
		AcessoPortariaService.deleteAcesso(id);
		
	}

}
