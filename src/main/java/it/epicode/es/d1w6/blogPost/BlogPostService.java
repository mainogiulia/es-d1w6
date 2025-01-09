package it.epicode.es.d1w6.blogPost;

import it.epicode.es.d1w6.author.Author;
import it.epicode.es.d1w6.author.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {
    private final BlogPostRepo blogPostRepo;
    private final AuthorService authorService;

    public List<BlogPost> findAll() {
        return blogPostRepo.findAll();
    }

    public BlogPost findById(Long id) {
        if (!blogPostRepo.existsById(id)) {
            throw new EntityNotFoundException("BlogPost non trovato");
        } else {
            return blogPostRepo.findById(id).get();
        }
    }

    public BlogPost createBlogPost(BlogPostDTO request){
        BlogPost post = new BlogPost();
        Author author = authorService.findById(request.getAuthorId());
        BeanUtils.copyProperties(request, post);
        post.setAuthor(author);
        return blogPostRepo.save(post);
    }

    public BlogPost updateBlogPost(Long id, BlogPost blogPostModificato) {
        BlogPost postModificato = findById(id);
        BeanUtils.copyProperties(blogPostModificato, postModificato);
        return blogPostRepo.save(postModificato);
    }

    public void deleteBlogPost(Long id) {
        blogPostRepo.deleteById(id);
    }
}
