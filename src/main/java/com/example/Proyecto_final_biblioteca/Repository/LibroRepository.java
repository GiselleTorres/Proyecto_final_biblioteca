package com.example.Proyecto_final_biblioteca.Repository;

import com.example.Proyecto_final_biblioteca.Model.Libro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Libro l WHERE l.idLibro = :id")
    void deleteByIdDirect(@Param("id") Long id);
}
