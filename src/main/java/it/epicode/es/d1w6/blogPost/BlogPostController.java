package it.epicode.es.d1w6.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogPost")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public ResponseEntity<List<BlogPost>> listAllBlogPost() {
        return ResponseEntity.ok(blogPostService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> findById(@PathVariable Long id) {
        return ResponseEntity.ok(blogPostService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPostDTO request) {
        return new ResponseEntity<>(blogPostService.createBlogPost(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPost request) {
        return ResponseEntity.ok(blogPostService.updateBlogPost(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }
}
