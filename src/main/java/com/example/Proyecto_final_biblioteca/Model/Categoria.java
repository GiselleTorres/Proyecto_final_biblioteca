package com.example.Proyecto_final_biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Categoría de libros.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "libros"})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombre;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties("categoria") // evita bucle libro->categoria->libros
    private List<Libro> libros;
}


