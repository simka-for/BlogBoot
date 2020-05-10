package com.BlogBoot.responses;

import com.BlogBoot.service.RequestBody.PostBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseBody {

    private Integer count;
    private List<PostBody> posts;
}
