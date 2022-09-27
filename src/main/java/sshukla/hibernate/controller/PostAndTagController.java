package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshukla.hibernate.manytomany.Post;
import sshukla.hibernate.manytomany.Tag;
import sshukla.hibernate.repo.PostRepository;
import sshukla.hibernate.repo.TagRepository;

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
        Set<Tag> newTagSet = post.getTagSet();
        for (Tag tag : tagSet) {
            String x = tag.getName();
            Tag findTag = tagRepository.findByName(x);
            Tag savedTag = findTag == null ? tagRepository.save(tag) : findTag;
            System.out.println("Saved Tag : " + savedTag.toString());
            newTagSet.add(savedTag);
        }

        System.out.println("After Processing Tags : " + newTagSet);
        post.getTagSet().clear();
        post.setTagSet(newTagSet);

        return postRepository.save(post);
    }
}
