package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sshukla.hibernate.manytomany.Post;
import sshukla.hibernate.manytomany.Tag;
import sshukla.hibernate.repo.PostRepository;
import sshukla.hibernate.repo.TagRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@RestController
@RequestMapping("/v1/postandtag")
@Slf4j
public class PostAndTagController {

    private PostRepository postRepository;

    private TagRepository tagRepository;

    public PostAndTagController(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @PostMapping
    public Post createPostAndTag(@RequestBody Post post) {

        Set<Tag> tagSet = post.getTagSet();
        System.out.println("Before Processing Tags : " + tagSet);
        Set<Tag> newTagSet = new HashSet<>();
        for (Tag tag : tagSet) {
            String x = tag.getName();
            Tag findTag = tagRepository.findByName(x);
            Tag savedTag = findTag == null ? tagRepository.save(tag) : findTag;
            System.out.println("Saved Tag : " + savedTag.toString());
            newTagSet.add(savedTag);
        }

        System.out.println("After Processing Tags : " + newTagSet);
        post.getTagSet().clear();
        post.getTagSet().addAll(newTagSet);
        return postRepository.save(post);
    }

    @GetMapping
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @GetMapping
    public Post getPostById(@PathVariable Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id - " + postId));
    }

    @DeleteMapping("/post/{postId}")
    public void deletePostById(@PathVariable Long postId) {
        Post savedPost = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id - " + postId));
        savedPost.getTagSet().removeAll(savedPost.getTagSet());
        postRepository.deleteById(postId);
    }

    //update scenario
}
