package vanderson.sistema.gasto.pessoal.gastos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ServiceGastos {

    @Autowired
    private GastosRepository gastoRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public void SalvarGasto(ObjectNode json) {

        // Optional<Usuario> usuario =
        // usuarioRepository.findById(json.get("usuario_id").asInt());


        List<String> p = getParcelas(json.get("parcelas").asInt(),
         json.get("mes").asInt(),
         json.get("ano").asInt());

       

         System.out.println(p);
     

        var parcela = json.get("parcelas").asInt();

        // List<ModelGasto> gastos = new ArrayList<>();

        for (var i = 0; i < p.size(); i++) {

             String[] string = p.get(i).split("-");
             
            ModelGasto gasto = new ModelGasto();
            gasto.setNome(json.get("nome").asText());
            gasto.setValor(json.get("valor").asLong());
            gasto.setProvdesc(json.get("provdesc").asText());
            gasto.setMes(Integer.parseInt(string[2]));
            gasto.setAno(Integer.parseInt(string[1]));
            // gasto.setUsuario(usuario.get());
            gasto.setParcelas(i);
            gasto.setTag(json.get("tag").asText());
            entityManager.persist(gasto);

        }

        // Se aplicar insert do gasto conforme o numero de parcelas
        // List<String> parcelas = getParcelas(json.get("parcelas").asInt(),
        // json.get("mes").asInt(),
        // json.get("ano").asInt());

        // for (var i = 0 ; i< parcelas.size(); i ++){

        // System.out.println("Tamanho parcelas " + parcelas.size());

        // gasto.setNome(json.get("nome").asText());
        // gasto.setValor(json.get("valor").asLong());
        // gasto.setProvdesc(json.get("provdesc").asText());
        // gasto.setMes(json.get("mes").asInt());
        // gasto.setAno(json.get("ano").asInt());
        // // gasto.setUsuario(usuario.get());
        // gasto.setParcelas(i);
        // gasto.setTag(json.get("tag").asText());

        // // System.out.println("Usuario = " + json.get("usuario_id").asInt());

        // String[] string = parcelas.get(0).split("-");

        // System.out.println("PRimeira parcela no mes ->" + string[2]);

        // System.out.println("############################# " + parcelas);

        // gastoRepository.saveAndFlush(gasto);
        // }

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

}
