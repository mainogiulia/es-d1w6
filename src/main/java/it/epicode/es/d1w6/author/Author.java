package it.epicode.es.d1w6.author;

import it.epicode.es.d1w6.blogPost.BlogPost;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    @Column (name = "data_nascita")
    private LocalDate dataNascita;
    private String avatar;
}
