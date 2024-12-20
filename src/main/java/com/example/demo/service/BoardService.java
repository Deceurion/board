package com.example.demo.service;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ApiResponseDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.repository.BoardRepository;
import com.example.demo.dto.BoardForm;
import com.example.demo.domain.Board;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;


@Transactional
@Service
public class BoardService {
	private final BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}

    public ApiResponseDto createBoard(BoardForm boardForm) {
        // 제목과 내용을 모두 포함하는 Board 객체 생성
        Board board = new Board(boardForm.getTitle(), boardForm.getContent());
        
        // Board 객체를 저장
        boardRepository.save(board);
        
        return new ApiResponseDto("생성 성공");
    }
    
    public BoardResponseDto getBoard(Long id) {
        
    	Optional<Board> optionalBoard = boardRepository.findById(id);
        
        Board board = optionalBoard.orElseThrow(() -> new IllegalArgumentException("게시판이 없습니다."));
 
        
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContent());
    }
    
    public ApiResponseDto deleteBoard(Long id) {
        try {
        	
        	boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시판이 없습니다."));
        	
        }catch(IllegalArgumentException e) {
        	
        	return new ApiResponseDto(e.getMessage());
        }
        
 
        boardRepository.deleteById(id);
        return new ApiResponseDto("게시글 삭제 완료");
    }
}
