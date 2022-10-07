package com.jscoder.app.msvc.usuarios.controller;

import com.jscoder.app.msvc.usuarios.models.entity.Usuario;
import com.jscoder.app.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
@GetMapping("/listar")
    public List<Usuario> getUsuarios() {
        return usuarioService.listar();


    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.porId(id);

   if(usuario.isPresent() ){
       return ResponseEntity.ok().body(usuario.get());
   }
    return ResponseEntity.notFound().build();

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario){
    return usuarioService.guardar(usuario);

    }
    @PutMapping("/listar/{id}")
    public ResponseEntity<?> editar(@RequestBody Usuario usuario,@PathVariable Long id){
        Optional<Usuario> o = usuarioService.porId(id);
        if(o.isPresent()){
            Usuario userdb =o.get();
            userdb.setNombre(usuario.getNombre());
            userdb.setEmail(usuario.getEmail());
            userdb.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(userdb));
        }
return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/listar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Usuario> o = usuarioService.porId(id);
        if(o.isPresent()){
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
