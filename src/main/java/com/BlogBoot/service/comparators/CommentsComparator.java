package com.BlogBoot.service.comparators;

import com.BlogBoot.model.Post;

import java.util.Comparator;

public class CommentsComparator implements Comparator<Post> {

    @Override
    public int compare(Post post1, Post post2) {
        return post2.getPostComments().size() - post1.getPostComments().size();
    }
}
