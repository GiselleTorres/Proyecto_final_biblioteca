package com.example.Proyecto_final_biblioteca.Controller;

import com.example.Proyecto_final_biblioteca.Model.Usuario;
import com.example.Proyecto_final_biblioteca.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable Long id,
            @RequestBody Usuario userDetails) {

        Usuario existing = usuarioService.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));

        // Actualiza los campos que quieras exponer
        existing.setNombre(userDetails.getNombre());
        existing.setEmail(userDetails.getEmail());
        existing.setTelefono(userDetails.getTelefono());

        Usuario updated = usuarioService.save(existing);
        return ResponseEntity.ok(updated);
    }
}
