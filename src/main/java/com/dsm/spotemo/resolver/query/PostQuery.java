package com.dsm.spotemo.resolver.query;

import com.dsm.spotemo.dto.response.PostResponseDto;
import com.dsm.spotemo.entity.Post;
import com.dsm.spotemo.repository.PostRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostQuery implements GraphQLResolver<Post> {
    private final PostRepository postRepository;

    public PostResponseDto getPost(int id) {
        Post post = postRepository.findById(id).orElseThrow();

        return PostResponseDto
                .builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .emotion(post.getEmotion())
                .date(post.getCreatedAt()).build();
    }

}