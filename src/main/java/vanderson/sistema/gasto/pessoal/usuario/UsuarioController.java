package vanderson.sistema.gasto.pessoal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity CriarUsuario(@RequestBody @Valid UsuarioModel usuario, UriComponentsBuilder uriBuilder) {

        service.CriaUsuario(usuario);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuario);
        
    }

    public UsuarioModel ListaUsuario(UsuarioModel usuario){

        return service.ListaUsuario(usuario);

    }

    

}
