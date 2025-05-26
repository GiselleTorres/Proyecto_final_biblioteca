package com.example.Proyecto_final_biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Entidad Libro con la categoría como objeto completo.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    private String titulo;
    private String autor;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER) // asegurar carga de categoría
    @JoinColumn(name = "id_categoria", nullable = false)
    @JsonIgnoreProperties("libros")    // evita bucle categoria->libros->categoria
    private Categoria categoria;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("libro")      // evita bucle prestamo->libro->prestamos
    private List<Prestamo> prestamos;
}
