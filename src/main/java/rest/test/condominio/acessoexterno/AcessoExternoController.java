package rest.test.condominio.acessoexterno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessoExternoController {
	
	@Autowired
	private AcessoExternoService AcessoExternoService;
	
	@RequestMapping("/AcessosExterno")
	public List<AcessoExterno> detAllAcessos(){
		
		return AcessoExternoService.getAllAcessos();
		
	}
	
	@RequestMapping("/AcessosExterno/{id}")
	public AcessoExterno getAcesso(@PathVariable Integer id){
		
		return AcessoExternoService.getAcesso(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/AcessosExterno")
	public void addAcesso(@RequestBody AcessoExterno Acesso){
		
		AcessoExternoService.addAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/AcessosExterno/{id}")
	public void updateAcesso(@RequestBody AcessoExterno Acesso, @PathVariable String id){
		
		AcessoExternoService.updateAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/AcessosExterno/{id}")
	public void deleteAcesso(@PathVariable Integer id){
		
		AcessoExternoService.deleteAcesso(id);
		
	}

}
