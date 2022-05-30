package com.example.demo;

import com.example.demo.Post;
import com.example.demo.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostRestController {

  private final PostRepository postRepository;

  @RequestMapping("/docker")
  public String home() {
    return "Hello Docker World";
  }

  @Autowired
  public PostRestController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }
  @CrossOrigin
  @RequestMapping(value = "/post/findByTitle")
  public Post findOneByTitle(@RequestParam("title") String title) {
    return postRepository.findOneByTitle(title);
  }

  @CrossOrigin
  @RequestMapping(value = "/post/findById")
  public Post findOneById(@RequestParam("id") Long id) {
    return postRepository.findOneById(id);
  }

  @CrossOrigin
  @RequestMapping(value = "/post/search")
  public List<Post> findByBodyContaining(
    @RequestParam("keyword") String keyword
  ) {
    return postRepository.findByBodyContaining(keyword);
  }

  @CrossOrigin
  @RequestMapping(value = "/post/count")
  public long count() {
    return postRepository.count();
  }

  @CrossOrigin(origins = "http://localhost:19999")
  @GetMapping("/posting")
  List<Post> all() {
    return postRepository.findAll();
  }

  @CrossOrigin(origins = "http://localhost:19999")
  @PostMapping("/posting")
  Post newPost(@RequestBody Post newPost) {
    return postRepository.save(newPost);
  }

  @RequestMapping(path = "/{name}/{age}")
  Post newPost(
    @PathVariable("name") String name,
    @PathVariable("age") String age
  ) {
    Post post1 = new Post(name, age);
    return postRepository.save(post1);
  }
}
