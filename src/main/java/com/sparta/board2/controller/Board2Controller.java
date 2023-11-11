package com.sparta.board2.controller;

import com.sparta.board2.dto.Board2RequestDto;
import com.sparta.board2.dto.Board2ResponseDto;
import com.sparta.board2.entity.Board2;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Board2Controller {
    private final Map<Long,Board2> map = new HashMap<>();

    @PostMapping("/post")
    public Board2ResponseDto createBoard (Board2RequestDto requestDto) {
        // Request -> Entity
        Board2 board2 = new Board2(requestDto);

        // Board2.ID 값 저장하기 // key값이 동일한게 있다면 +1해서 저장, 없다면(최초) 1로 저장
        Long maxId = map.size() > 0 ? Collections.max(map.keySet())+1 : 1;
        board2.setId(maxId);//board2 ID값으로 저장

        // Entity -> DB 저장
        map.put(board2.getId(),board2);//위에서 저장했던 ID값 + board2 객체 저장

        // Entity -> Response -> 출력
        Board2ResponseDto responseDto = new Board2ResponseDto(board2);
        return responseDto;
    }

    @GetMapping("/get")
    public List<Board2ResponseDto> getBoard () {
        // Map -> List
        List<Board2ResponseDto> list = map.values().stream()
                .map(Board2ResponseDto::new).toList();
        return list;
    }

    @PutMapping("/put")
    public Long updateBoard (@RequestBody Long id, Board2RequestDto requestDto) {

        if (map.containsKey(id)) { // id조회
            Board2 board2 = map.get(id); // 저장값 불러오기
            board2.update(requestDto); // 수정하기
            return board2.getId(); // id값 불러오기
        } else
    }
}
