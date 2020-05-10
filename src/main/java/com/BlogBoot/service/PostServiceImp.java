package com.BlogBoot.service;

import com.BlogBoot.model.Post;
import com.BlogBoot.repository.PostRepository;
import com.BlogBoot.responses.PostResponseBody;
import com.BlogBoot.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public PostResponseBody getAllPost(Integer offset, Integer limit, String mode) {

        Integer count = 0;
        List<Post>  allPosts = new ArrayList<>();
        Iterable<Post> postsIterable = postRepository.findAll();

        for (Post post : postsIterable){
            count++;

            if (isPostAccepted(post))
                allPosts.add(post);

        }
        allPosts = sortPosts(allPosts, mode);

        return new PostResponseBody(count, getListPostBody(allPosts, offset, limit));


    }
}
