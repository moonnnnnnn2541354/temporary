package com.sparta.board2.entity;


import com.sparta.board2.dto.Board2RequestDto;
import com.sparta.board2.dto.Board2ResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Board2 {
    private Long id;
    private String name;
    private String content;

    public Board2(Board2RequestDto requestDto) {
     this.id = requestDto.getId();
     this.name = requestDto.getName();
     this.content = requestDto.getContent();
    }

    public void update (Board2RequestDto requestDto) {
        this.name = requestDto.getName();
        this.content = requestDto.getContent();

    }
}