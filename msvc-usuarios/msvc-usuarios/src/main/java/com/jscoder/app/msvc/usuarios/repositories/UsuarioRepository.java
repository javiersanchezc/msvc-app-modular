package com.jscoder.app.msvc.usuarios.repositories;

import com.jscoder.app.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

}
