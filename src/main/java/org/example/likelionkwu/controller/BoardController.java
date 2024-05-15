package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.BoardResponse;
import org.example.likelionkwu.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping(value = "/create")
    public void writeBoardPage(@RequestBody BoardRequest req){
        Long saveBoardId=boardService.writeBoard(req);
    }

    @GetMapping(value = "/")
    public List<BoardResponse> showBoardsPage()
    {
        return boardService.getBoards();
    }

    @GetMapping(value = "/boardId{boardId}")
    public BoardResponse howBoardPage(@PathVariable Long boardId){
        return boardService.getBoardById(boardId);
    }


    @GetMapping(value="/boardAuthor/{userName}")
    public List<BoardResponse> showUserBoardPage(@PathVariable String userName)
    {
        return boardService.getBoardByUser(userName);
    }
}
