package vanderson.sistema.gasto.pessoal.gastos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import vanderson.sistema.gasto.pessoal.usuario.UsuarioModel;
import vanderson.sistema.gasto.pessoal.usuario.UsuarioRepository;

@Service
public class GastosService {

	@Autowired
	private GastosRepository gastosRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private UsuarioRepository usuarioRepository;

	private GastoModel gasto;

	public void SalvarGasto(ObjectNode json) {

		List<String> p = getParcelas(json.get("parcelas").asInt(), json.get("mes").asInt(), json.get("ano").asInt());

		for (var i = 0; i < p.size(); i++) {

			String[] string = p.get(i).split("-");

			GastoModel gasto = new GastoModel();
			gasto.setNome(json.get("nome").asText());
			gasto.setValor(json.get("valor").asLong());
			gasto.setProvdesc(json.get("provdesc").asText());
			gasto.setMes(Integer.parseInt(string[2]));
			gasto.setAno(Integer.parseInt(string[1]));
			// gasto.setUsuario(usuario.get());
			gasto.setParcelas(i);
			gasto.setTag(json.get("tag").asText());

			UsuarioModel usuario = new UsuarioModel();

			usuario = usuarioRepository.findById(json.get("usuario_id").asLong()).get();

			gasto.setUsuario(usuario);

			entityManager.persist(gasto);

		}

	}

	// retorna meses e anos e suas parcelas
	public List<String> getParcelas(int parcelas, int mes, int ano) {

		List<String> list = new ArrayList<>();

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, ano);
		calendar.set(Calendar.MONTH, mes - 2);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		for (int i = 0; i < parcelas; i++) {
			calendar.add(Calendar.MONTH, 1);
			String mesAno = i + "-" + calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1);
			list.add(mesAno);

		}

		return list;
	}

	public void DeletaGasto(Long idGasto) {

		gasto = gastosRepository.findById(idGasto).get();

		gastosRepository.delete(gasto);

	}

	public GastoModel AtualizaGasto(GastoModel gasto) {

		return gastosRepository.save(gasto);
	}

	
	
}
