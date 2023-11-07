package com.besp.likebesp1.post.service;

import com.besp.likebesp1.post.entity.PostDto;
import com.besp.likebesp1.post.repository.PostRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
    @Resource(name = "postRepository")
    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public long insert(PostDto dto, long boardId) {
        dto.setBoardId(boardId);  // 게시판 아이디 설정
        return postRepository.insert(dto);
    }

    @Override
    public List<PostDto> getList(PostDto dto) {
        return postRepository.getList(dto);
    }

    @Override
    public PostDto getPost(long postId, long boardId) {
        return postRepository.getPost(postId, boardId);
    }

    @Override
    public void updatePost(PostDto postDto) {
        postRepository.update(postDto);
    }

    @Override
    public void deletePost(long postId, long boardId) {
        postRepository.delete(postId, boardId);
    }

}