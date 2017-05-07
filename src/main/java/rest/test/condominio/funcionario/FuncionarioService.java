package rest.test.condominio.funcionario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository FuncionarioRepository;
	
	public List<Funcionario> getAllFuncionarios(){
		List<Funcionario> Funcionarios = new ArrayList<>();
		FuncionarioRepository.findAll()
		.forEach(Funcionarios::add);
		return Funcionarios;
	}
	
	public Funcionario getFuncionario(Integer id){
		return FuncionarioRepository.findOne(id);
	}

	public void addFuncionario(Funcionario Funcionario) {
		FuncionarioRepository.save(Funcionario);		
	}

	public void updateFuncionario(Funcionario Funcionario) {
		FuncionarioRepository.save(Funcionario);
	}

	public void deleteFuncionario(Integer id) {
		FuncionarioRepository.delete(id);	
	}

}
