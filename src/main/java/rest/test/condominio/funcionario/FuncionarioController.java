package rest.test.condominio.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService FuncionarioService;
	
	@RequestMapping("/Funcionarios")
	public List<Funcionario> detAllFuncionarios(){
		
		return FuncionarioService.getAllFuncionarios();
		
	}
	
	@RequestMapping("/Funcionarios/{id}")
	public Funcionario getFuncionario(@PathVariable Integer id){
		
		return FuncionarioService.getFuncionario(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Funcionarios")
	public void addFuncionario(@RequestBody Funcionario Funcionario){
		
		FuncionarioService.addFuncionario(Funcionario);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Funcionarios/{id}")
	public void updateFuncionario(@RequestBody Funcionario Funcionario, @PathVariable String id){
		
		FuncionarioService.updateFuncionario(Funcionario);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Funcionarios/{id}")
	public void deleteFuncionario(@PathVariable Integer id){
		
		FuncionarioService.deleteFuncionario(id);
		
	}

}