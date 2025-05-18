package com.example.Proyecto_final_biblioteca.Service;

import com.example.Proyecto_final_biblioteca.Model.Prestamo;
import com.example.Proyecto_final_biblioteca.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> findById(Long id) {
        return prestamoRepository.findById(id);
    }

    public Prestamo save(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    public void delete(Long id) {
        prestamoRepository.deleteById(id);
    }
}
