package com.acm.proyectofinalacm.controller;


import com.acm.proyectofinalacm.entities.Usuario;
import com.acm.proyectofinalacm.service.UsuarioService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("apiacm/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("create-usuario")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado=usuarioService.crearUsuario(usuario);
        return ResponseEntity.ok(usuarioGuardado);
    }
    @GetMapping("/findbyId/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable int id){
        Usuario usuarioEncontrado= usuarioService.findbyId(id);
        if (usuarioEncontrado!=null){
            return ResponseEntity.ok(usuarioEncontrado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/deletebyId/{id}")
    public ResponseEntity<Usuario> deleteById(@PathVariable int id){
        Usuario usuarioElimindado=usuarioService.deletebyId(id);
        if (usuarioElimindado!=null){
            return ResponseEntity.ok(usuarioElimindado);
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/update-usuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Integer id,@RequestBody Usuario usuario){
        try {
            Usuario usuarioActualizado = usuarioService.updateUsuario(id,usuario);
            return ResponseEntity.ok(usuarioActualizado);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
