package com.jscoder.app.msvc.usuarios.services;

import com.jscoder.app.msvc.usuarios.models.entity.Usuario;
import com.jscoder.app.msvc.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override

    public Optional<Usuario> porId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
