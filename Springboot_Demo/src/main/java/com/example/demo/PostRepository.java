package com.example.demo;

import com.example.demo.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.query.Param;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends CrudRepository<Post, Long>{
    Post findOneByTitle(@Param("title") String title);
    Post findOneById(@Param("id") Long id);
    List<Post> findByBodyContaining(@Param("keyword") String keyword);
    List<Post> findAll();
}