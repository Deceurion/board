package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ApiResponseDto;
import com.example.demo.dto.BoardForm;
import com.example.demo.dto.CommentsDto;
import com.example.demo.repository.CommentsRepository;
import com.example.demo.repository.BoardRepository;
import com.example.demo.dto.CommentsForm;
import com.example.demo.domain .Comments;
import com.example.demo.domain .Board;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@Service
@Transactional
public class CommentsService {
    
    private final CommentsRepository commentsRepository;
    private final BoardRepository boardRepository;

    @Autowired
    public CommentsService(CommentsRepository commentsRepository, BoardRepository boardRepository) {
        this.commentsRepository = commentsRepository;
        this.boardRepository = boardRepository;
    }

    public ApiResponseDto createComment(CommentsDto commentsDto) {
        // 게시글 조회
        Board board = boardRepository.findById(commentsDto.getBoardId())
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        // 댓글 생성
        Comments comments = new Comments(commentsDto.getc_Content(), board);
        commentsRepository.save(comments);
        
        return new ApiResponseDto("댓글 생성 성공");
    }

}
