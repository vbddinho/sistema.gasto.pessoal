package vanderson.sistema.gasto.pessoal.usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository  extends JpaRepository<UsuarioModel,Long>{
    

Optional<UsuarioModel> findById(Long id);

}
