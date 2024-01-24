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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.transaction.Transactional;
import vanderson.sistema.gasto.pessoal.usuario.UsuarioModel;
import vanderson.sistema.gasto.pessoal.usuario.UsuarioRepository;

@RestController
@RequestMapping("/gastos")
public class GastosController {

    @Autowired
    private GastosService service;

    @Autowired
    private GastosRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @PostMapping(produces = "application/json", consumes = "application/json")
    // @ResponseBody
    // @Transactional
    // public void CadastroGasto(@RequestBody ObjectNode json) {

    //     // return service.SalvarGasto(gasto);
    //      service.SalvarGasto(json);

    // }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseBody
    @Transactional
    public void CadastroGasto(@RequestBody String json) throws JsonMappingException, JsonProcessingException {
        
         service.SalvarGasto2(json);

    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<GastoModel>> ListaGastos (Pageable paginacao) {
        // PageRequest pageRequest = PageRequest.of(0,200); // começa na pagina zero e
        // tem o total de 200 obj por pagina

        Page<GastoModel> page = repository.findAll(paginacao);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping(path = "/delete")
    @ResponseBody
    public ResponseEntity<Object>  DeletaGasto(@RequestParam(name = "id") Long idGasto){

        service.DeletaGasto(idGasto);

        System.out.println("Gasto "+ idGasto + " foi deletado");

        return ResponseEntity.noContent().build();

    }
    
    @PutMapping(produces = "application/json", consumes = "application/json")
    @ResponseBody
    @Transactional
    public ResponseEntity<GastoModel> AtualizaGasto (@RequestBody GastoModel gasto){

        service.AtualizaGasto(gasto);

        return ResponseEntity.ok(gasto);
    }
}
