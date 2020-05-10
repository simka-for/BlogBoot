package com.BlogBoot.controller;

import com.BlogBoot.repository.PostRepository;
import com.BlogBoot.responses.PostResponseBody;
import com.BlogBoot.service.interfaces.PostService;
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
    @ResponseBody
    public PostResponseBody getAllPosts(Integer offset, Integer limit, String mode){

        return postService.getAllPost(offset, limit, mode);

    }

}
