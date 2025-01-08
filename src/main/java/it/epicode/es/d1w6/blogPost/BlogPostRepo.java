package it.epicode.es.d1w6.blogPost;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {
}
