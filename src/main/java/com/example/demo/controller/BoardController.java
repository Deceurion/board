package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.BoardService;
import com.example.demo.dto.BoardForm;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.dto.BoardForm;
import com.example.demo.dto.ApiResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;


@RestController
public class BoardController {
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@PostMapping("/boards")
	public ResponseEntity<ApiResponseDto> createBoard(@RequestBody BoardForm boardForm) {
		
		ApiResponseDto responseDto = boardService.createBoard(boardForm);
		return ResponseEntity.ok().body(responseDto);
	}
	
 	@GetMapping("/boards/{id}")
	public ResponseEntity<BoardResponseDto> getBoard(@PathVariable("id") Long id) {
		
		BoardResponseDto responseDto = boardService.getBoard(id);
		return ResponseEntity.ok().body(responseDto);
	}
 	
 	@DeleteMapping("/boards/{id}")
 	public ResponseEntity<ApiResponseDto> deleteBoard(@PathVariable("id") Long id) {
 		
 		ApiResponseDto responseDto = boardService.deleteBoard(id);
		return ResponseEntity.ok().body(responseDto);
 	}
 	
 	@PutMapping("/boards/{id}")
 	public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable("id") Long id, @RequestBody BoardForm boardForm) {
 		BoardResponseDto responseDto = boardService.updateBoard(id, boardForm);
 		return ResponseEntity.ok().body(responseDto);
 	}

}
