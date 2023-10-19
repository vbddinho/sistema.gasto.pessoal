package vanderson.sistema.gasto.pessoal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired private UsuarioRepository repository;



	public UsuarioModel CriaUsuario(UsuarioModel usuario) {

		return repository.save(usuario);

	}

	public UsuarioModel ListaUsuario(Long idUsuario) {

		return repository.findById(idUsuario).get();

	}

	public Page<UsuarioModel> findAll(Pageable page) {

		return repository.findAll(page);

	}

	public UsuarioModel Atualizar(UsuarioModel usuario) {

		return repository.save(usuario);
	}

	public void DeleteUsuario(Long idUsuario) {

		UsuarioModel usuario =  repository.findById(idUsuario).get();

		repository.delete(usuario);
	}
}
