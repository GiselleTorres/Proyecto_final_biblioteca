package com.example.Proyecto_final_biblioteca.Controller;

import com.example.Proyecto_final_biblioteca.Model.Prestamo;
import com.example.Proyecto_final_biblioteca.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Prestamo> getPrestamoById(@PathVariable Long id) {
        return prestamoService.findById(id);
    }

    @PostMapping
    public Prestamo createPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.save(prestamo);
    }

    @DeleteMapping("/{id}")
    public void deletePrestamo(@PathVariable Long id) {
        prestamoService.delete(id);
    }
}
