package vanderson.sistema.gasto.pessoal.fechamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vanderson.sistema.gasto.pessoal.gastos.GastosRepository;
import vanderson.sistema.gasto.pessoal.usuario.UsuarioModel;

@Service
public class FechamentoService {

	@Autowired GastosRepository gastoRepository;
	
	public void AgruparGastos(Long ano,UsuarioModel usuario) {
		
		//  gastoRepository.findByUsuario(usuario); 
		
		
		
		
	}
	
}
