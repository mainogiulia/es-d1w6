package it.epicode.es.d1w6.blogPost;

import it.epicode.es.d1w6.author.Author;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    @Column(name = "tempo_lettura")
    private int tempoLettura;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}