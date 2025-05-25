package com.example.Proyecto_final_biblioteca.Controller;

import com.example.Proyecto_final_biblioteca.Model.Libro;
import com.example.Proyecto_final_biblioteca.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Libro> getLibroById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(

            @PathVariable Long id,
            @RequestBody Libro libroDetails) {
        // Busca el libro existente
        Libro libroExistente = libroService.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con id " + id));

        // Actualiza los campos que quieras
        libroExistente.setTitulo(libroDetails.getTitulo());
        libroExistente.setAutor(libroDetails.getAutor());
        libroExistente.setAnioPublicacion(libroDetails.getAnioPublicacion());
        libroExistente.setIsbn(libroDetails.getIsbn());
        libroExistente.setCategoria(libroDetails.getCategoria());

        // Guarda y devuelve
        Libro actualizado = libroService.save(libroExistente);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.delete(id);
    }


}
