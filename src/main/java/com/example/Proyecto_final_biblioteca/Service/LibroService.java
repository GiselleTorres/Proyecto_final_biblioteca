package com.example.Proyecto_final_biblioteca.Service;

import com.example.Proyecto_final_biblioteca.Model.Libro;
import com.example.Proyecto_final_biblioteca.Repository.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    public void delete(Long id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Libro no existe: " + id));
        libroRepository.delete(libro);
    }
}
