package com.example.Proyecto_final_biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "idLibro")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    private String titulo;
    private String autor;

    @Column(name = "anio_publicacion")
    private Integer anioPublicacion;

    private String isbn;

    @JsonIdentityReference (alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
            property  = "idCategoria")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;


    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property  = "idPrestamo")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIgnoreProperties("libro")
    @OneToMany(mappedBy = "libro",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prestamo> prestamos;
}

