package com.sparta.board2.dto;

import com.sparta.board2.entity.Board2;
import lombok.Getter;

@Getter
public class Board2ResponseDto {
    private String name;
    private String content;

    public Board2ResponseDto(Board2 board2) {
        this.name = board2.getName();
        this.content = board2.getContent();
    }
}
