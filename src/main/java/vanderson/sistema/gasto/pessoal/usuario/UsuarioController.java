package vanderson.sistema.gasto.pessoal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping(name = "Cria Usuario", produces = "application/json", consumes = "application/json")
    @ResponseBody
    @Transactional
    public ResponseEntity<UsuarioModel> CriarUsuario(@RequestBody @Valid UsuarioModel usuario, UriComponentsBuilder uriBuilder) {

        service.CriaUsuario(usuario);
        var uri = uriBuilder.path("/usuario/{idUsuario}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);

    }

    @GetMapping(path = "/{idUsuario}")
    public UsuarioModel ListaUsuario(@PathVariable(name = "idUsuario") Long idUsuario) {

        return service.ListaUsuario(idUsuario);

    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<UsuarioModel>> ListaUsuarioPaginada(Pageable paginacao) {
        // PageRequest pageRequest = PageRequest.of(0,200); // começa na pagina zero e
        // tem o total de 200 obj por pagina

        Page<UsuarioModel> page = service.findAll(paginacao);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @ResponseBody
    @Transactional
    public ResponseEntity<UsuarioModel> AtualizaUsuario(@RequestBody UsuarioModel usuario) {

        service.Atualizar(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(path = "/delete")
    @ResponseBody
    @Transactional
    public ResponseEntity<Object> DeleteUsuario(@RequestParam(name = "id") Long idUsuario) {

        service.DeleteUsuario(idUsuario);

        System.out.println("Usuario id = " + idUsuario + " deletado");

        return ResponseEntity.noContent().build();

    }


}
