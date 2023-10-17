package vanderson.sistema.gasto.pessoal.gastos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/gastos")
public class ControllerGastos {

    @Autowired
    private ServiceGastos service;

    @Autowired
    private GastosRepository repository;

    @PostMapping
    @ResponseBody
    @Transactional
    public void CadastroGasto(@RequestBody ObjectNode json) {

        // return service.SalvarGasto(gasto);
         service.SalvarGasto(json);

    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<ModelGasto>> ListaGastos (Pageable paginacao) {
        // PageRequest pageRequest = PageRequest.of(0,200); // começa na pagina zero e
        // tem o total de 200 obj por pagina

        Page<ModelGasto> page = repository.findAll(paginacao);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping(path = "/delete")
    @ResponseBody
    public ResponseEntity<Object>  DeletaGasto(@RequestParam(name = "id") int idGasto){

        service.DeletaGasto(idGasto);

        System.out.println("Gasto "+ idGasto + " foi deletado");

        return ResponseEntity.noContent().build();

    }
    
    @PutMapping
    @ResponseBody
    @Transactional
    public ResponseEntity AtualizaGasto (@RequestBody ModelGasto gasto){

        service.AtualizaGasto(gasto);

        return ResponseEntity.ok(gasto);
    }
}
