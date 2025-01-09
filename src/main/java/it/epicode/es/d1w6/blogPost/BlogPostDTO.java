package it.epicode.es.d1w6.blogPost;

import lombok.Data;

@Data
public class BlogPostDTO {
    private String titolo;
    private String contenuto;
    private int tempoLettura;
    private Long authorId;
}
