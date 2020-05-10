package com.BlogBoot.service.interfaces;

import com.BlogBoot.model.Post;
import com.BlogBoot.model.enums.ModeValue;
import com.BlogBoot.model.enums.ModeratorStatus;
import com.BlogBoot.responses.PostResponseBody;
import com.BlogBoot.service.RequestBody.PostBody;
import com.BlogBoot.service.RequestBody.UserBody;
import com.BlogBoot.service.comparators.CommentsComparator;
import com.BlogBoot.service.comparators.DateComparator;
import com.BlogBoot.service.comparators.LikeComparator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public interface PostService {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, EEEE, HH:mm");

    PostResponseBody getAllPost(Integer offset, Integer limit, String mode);




    default List<PostBody> getListPostBody(List<Post> posts, Integer offset, Integer limit){

        List<PostBody> postsBodies = new ArrayList<>();
        int finish = Math.min(posts.size(), offset + limit);

        for (int i = offset; i < finish; i++){

            Post post = posts.get(i);
            UserBody user = new UserBody(post.getUser().getId(), post.getUser().getName());

            postsBodies.add(PostBody.builder().id(post.getId())
                    .time(post.getTime().format(formatter))
                    .userBody(user)
                    .title(post.getTitle())
                    .announce(getAnnounce(post))
                    .likeCount(post.getVotesCount("likes"))
                    .dislikeCount(post.getVotesCount("dislikes"))
                    .commentCount(post.getCommentsCount())
                    .viewCount(post.getViewCount())
                    .build());
        }
        return postsBodies;
    }

    default boolean isPostAccepted(Post post) {

        return post.getIsActive() == 1 &&
                post.getModeratorStatus().equals(ModeratorStatus.ACCEPTED) &&
                post.getTime().isBefore(LocalDateTime.now());
    }

    default List<Post> sortPosts(List<Post> posts, String mode) {

        if (mode.equals(ModeValue.POPULAR.toString()))
            posts.sort(new CommentsComparator());
        else if (mode.equals(ModeValue.BEST.toString()))
            posts.sort(new LikeComparator());
        else if (mode.equals(ModeValue.RECENT.toString()))
            posts.sort(new DateComparator());
        else
            posts.sort(new DateComparator().reversed());

        return posts;
    }

    default String getAnnounce(Post post) {

        String announce = "";

        if (post.getText().length() > 500) {
            announce = post.getText().substring(0, 499) + "...";
        } else announce = post.getText();

        return announce;
    }

}
