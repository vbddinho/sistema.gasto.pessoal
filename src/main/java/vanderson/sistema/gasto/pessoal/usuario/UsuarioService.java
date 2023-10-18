package vanderson.sistema.gasto.pessoal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioModel CriaUsuario (UsuarioModel usuario){


        return usuarioRepository.save(usuario);

    }
}
