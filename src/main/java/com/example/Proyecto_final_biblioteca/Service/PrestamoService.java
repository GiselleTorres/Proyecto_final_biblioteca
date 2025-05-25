package com.example.Proyecto_final_biblioteca.Service;

import com.example.Proyecto_final_biblioteca.Model.Libro;
import com.example.Proyecto_final_biblioteca.Model.Prestamo;
import com.example.Proyecto_final_biblioteca.Model.Usuario;
import com.example.Proyecto_final_biblioteca.Repository.LibroRepository;
import com.example.Proyecto_final_biblioteca.Repository.PrestamoRepository;
import com.example.Proyecto_final_biblioteca.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LibroRepository libroRepository;

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> findById(Long id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo save(Prestamo dto) {
        Usuario u = usuarioRepository.findById(dto.getUsuario().getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Usuario no encontrado con id " + dto.getUsuario().getIdUsuario()));
        Libro l = libroRepository.findById(dto.getLibro().getIdLibro())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Libro no encontrado con id " + dto.getLibro().getIdLibro()));

        Prestamo p = new Prestamo();
        p.setFechaInicio(dto.getFechaInicio());
        p.setFechaFin(dto.getFechaFin());
        p.setUsuario(u);
        p.setLibro(l);

        return prestamoRepository.save(p);
    }

    public void delete(Long id) {
        Prestamo p = prestamoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Préstamo no encontrado con id " + id));
        prestamoRepository.delete(p);
    }

    public Prestamo update(Long id, Prestamo dto) {
        Prestamo existing = prestamoRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Préstamo no encontrado con id " + id));
        existing.setFechaInicio(dto.getFechaInicio());
        existing.setFechaFin(  dto.getFechaFin());
        return prestamoRepository.save(existing);
    }
}


