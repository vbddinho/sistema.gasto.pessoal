package vanderson.sistema.gasto.pessoal.gastos;

import org.springframework.data.jpa.repository.JpaRepository;

import vanderson.sistema.gasto.pessoal.usuario.UsuarioModel;


public interface GastosRepository extends JpaRepository<GastoModel,Long> {

//	@Query(select sum(u.valor)   )
	void findByUsuario(UsuarioModel usuario);

}
