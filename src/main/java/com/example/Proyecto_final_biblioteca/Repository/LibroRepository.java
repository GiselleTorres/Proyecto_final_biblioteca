package com.example.Proyecto_final_biblioteca.Repository;

import com.example.Proyecto_final_biblioteca.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
