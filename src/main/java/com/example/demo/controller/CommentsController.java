package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.CommentsService;
import com.example.demo.service.CommentsService;
import com.example.demo.dto.ApiResponseDto;
import com.example.demo.dto.CommentsDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsController {
    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/{boardId}")
    public ResponseEntity<ApiResponseDto> createComments(@PathVariable("boardId") Long boardId, @RequestBody CommentsDto commentsDto) {
        commentsDto.setBoardId(boardId);
        ApiResponseDto responseDto = commentsService.createComment(commentsDto);
        return ResponseEntity.ok().body(responseDto);
    }

}