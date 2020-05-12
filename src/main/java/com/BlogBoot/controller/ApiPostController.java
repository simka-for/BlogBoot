package com.BlogBoot.controller;

import com.BlogBoot.repository.PostRepository;
import com.BlogBoot.responses.PostResponseBody;
import com.BlogBoot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PostResponseBody getAllPosts(
            @RequestParam Integer offset,
            @RequestParam Integer limit,
            @RequestParam String mode){

        return postService.getPosts(offset, limit, mode);

    }

}
