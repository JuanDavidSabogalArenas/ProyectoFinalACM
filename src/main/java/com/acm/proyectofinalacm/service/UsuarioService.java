package com.acm.proyectofinalacm.service;


import com.acm.proyectofinalacm.entities.Usuario;
import com.acm.proyectofinalacm.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    //Metodo para crear usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    //Metodo para encontrar por id un usuario
    public Usuario findbyId(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }
    //Metodo para eliminar usuario por id
    public Usuario deletebyId(Integer id){
        return usuarioRepository.findById(id).map(usuario ->  {
            usuarioRepository.delete(usuario);
            return usuario;
        }).orElse(null);
    }
    //Metodo para actualizar un usuario
    public Usuario updateUsuario(Integer id,Usuario usuario){
        Usuario usuarioExistente=usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado con id "+id));
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setTelefono(usuario.getTelefono());
        usuarioExistente.setDireccion(usuario.getDireccion());
        usuarioExistente.setPassword(usuario.getPassword());
        return  usuarioRepository.save(usuarioExistente);
    }
}
