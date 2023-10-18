package vanderson.sistema.gasto.pessoal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;


    public UsuarioModel CriaUsuario (UsuarioModel usuario){


        return repository.save(usuario);

    }


    public UsuarioModel ListaUsuario(UsuarioModel usuario) {
        
        return repository.findById(usuario.getId()).get();

    }
}
