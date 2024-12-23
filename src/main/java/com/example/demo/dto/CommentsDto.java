package com.example.demo.dto;

public class CommentsDto {
    private Long boardId; // 댓글을 추가할 게시글 ID
    private String c_Content; // 댓글 내용

    // 기본 생성자 추가
    public CommentsDto() {
    }

    // 매개변수를 받는 생성자
    public CommentsDto(Long boardId, String c_Content) {
        this.boardId = boardId;
        this.c_Content = c_Content;
    }

    // Getter와 Setter
    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getc_Content() {
        return c_Content;
    }

    public void setc_Content(String c_Content) {
        this.c_Content = c_Content;
    }
}
