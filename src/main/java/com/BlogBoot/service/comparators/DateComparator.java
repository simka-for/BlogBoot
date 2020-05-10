package com.BlogBoot.service.comparators;

import com.BlogBoot.model.Post;

import java.util.Comparator;

public class DateComparator implements Comparator<Post> {

    @Override
    public int compare(Post post1, Post post2) {

        return post2.getTime().compareTo(post1.getTime());
    }

}
