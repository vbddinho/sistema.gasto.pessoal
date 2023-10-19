package vanderson.sistema.gasto.pessoal.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuarioRepository  extends JpaRepository<UsuarioModel,Long>{
    

}
