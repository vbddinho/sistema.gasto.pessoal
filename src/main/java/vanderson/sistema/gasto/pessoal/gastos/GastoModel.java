package vanderson.sistema.gasto.pessoal.gastos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "gastos")
@Entity
@EqualsAndHashCode(of = "id")
public class GastoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long valor;
    private String provdesc;
    private int mes;
    private int ano;
    private int parcelas;
    private String tag;

    public GastoModel(Long id, String nome, Long valor, String provdesc, int mes, int ano, int parcelas, String tag) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.provdesc = provdesc;
        this.mes = mes;
        this.ano = ano;
        this.parcelas = parcelas;
        this.tag = tag;

    }

    public GastoModel() {

    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public String getProvdesc() {
		return provdesc;
	}

	public void setProvdesc(String provdesc) {
		this.provdesc = provdesc;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
    
    

}
