package com.example.Proyecto_final_biblioteca.Repository;

import com.example.Proyecto_final_biblioteca.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
