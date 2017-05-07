package rest.test.condominio.acessogaragem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessoGaragemController {
	
	@Autowired
	private AcessoGaragemService AcessoGaragemService;
	
	@RequestMapping("/AcessosGaragem")
	public List<AcessoGaragem> detAllAcessos(){
		
		return AcessoGaragemService.getAllAcessos();
		
	}
	
	@RequestMapping("/AcessosGaragem/{id}")
	public AcessoGaragem getAcesso(@PathVariable Integer id){
		
		return AcessoGaragemService.getAcesso(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/AcessosGaragem")
	public void addAcesso(@RequestBody AcessoGaragem Acesso){
		
		AcessoGaragemService.addAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/AcessosGaragem/{id}")
	public void updateAcesso(@RequestBody AcessoGaragem Acesso, @PathVariable String id){
		
		AcessoGaragemService.updateAcesso(Acesso);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/AcessosGaragem/{id}")
	public void deleteAcesso(@PathVariable Integer id){
		
		AcessoGaragemService.deleteAcesso(id);
		
	}

}