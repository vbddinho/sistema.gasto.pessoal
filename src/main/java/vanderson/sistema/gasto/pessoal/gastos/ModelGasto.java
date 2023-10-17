package vanderson.sistema.gasto.pessoal.gastos;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "gastos")
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class ModelGasto {

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

    public ModelGasto(Long id, String nome, Long valor, String provdesc, int mes, int ano, int parcelas, String tag) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.provdesc = provdesc;
        this.mes = mes;
        this.ano = ano;
        this.parcelas = parcelas;
        this.tag = tag;

    }

    public ModelGasto() {

    }

}
