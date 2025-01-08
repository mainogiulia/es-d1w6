package it.epicode.es.d1w6.blogPost;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {
    private final BlogPostRepo blogPostRepo;

    public List<BlogPost> findAll() {
        return blogPostRepo.findAll();
    }

    public BlogPost findById(Long id) {
        if (!blogPostRepo.existsById(id)) {
            throw new IllegalArgumentException("BlogPost non trovato");
        } else {
            return blogPostRepo.findById(id).get();
        }
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepo.save(blogPost);
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
