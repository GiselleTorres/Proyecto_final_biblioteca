package com.example.Proyecto_final_biblioteca.Controller;

import com.example.Proyecto_final_biblioteca.Model.Categoria;
import com.example.Proyecto_final_biblioteca.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Categoria> getCategoriaById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(
            @PathVariable Long id,
            @RequestBody Categoria catDetails) {

        Categoria cat = categoriaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id " + id));

        cat.setNombre(catDetails.getNombre());

        Categoria actualizado = categoriaService.save(cat);
        return ResponseEntity.ok(actualizado);
    }
}
