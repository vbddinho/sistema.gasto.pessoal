package vanderson.sistema.gasto.pessoal.fechamento;

import java.util.List;

import vanderson.sistema.gasto.pessoal.gastos.GastoModel;
import vanderson.sistema.gasto.pessoal.usuario.UsuarioModel;



public class FechamentoModel {

	
	private Long id;
	private Long ano;
	private List<GastoModel> gastos;
	private UsuarioModel usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public List<GastoModel> getGastos() {
		return gastos;
	}

	public void setGastos(List<GastoModel> gastos) {
		this.gastos = gastos;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}

	public FechamentoModel(Long id, Long ano, List<GastoModel> gastos, UsuarioModel usuario) {
		super();
		this.id = id;
		this.ano = ano;
		this.gastos = gastos;
		this.usuario = usuario;
	}

	public FechamentoModel() {
		
	}

}
