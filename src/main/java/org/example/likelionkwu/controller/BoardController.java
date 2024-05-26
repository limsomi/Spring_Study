package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.BoardResponse;
import org.example.likelionkwu.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> writeBoardPage(@RequestBody BoardRequest req){
        if(boardService.writeBoard(req)!=null)
        {
            return ResponseEntity.ok("생성완료");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<BoardResponse>> showBoardsPage()
    {
        List<BoardResponse>BoardList=boardService.getBoards();
        if(BoardList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(BoardList);
        }
    }

    @GetMapping(value = "/boardId/{boardId}")
    public ResponseEntity<BoardResponse> howBoardPage(@PathVariable Long boardId){
        BoardResponse res=boardService.getBoardById((boardId));
        if(res!=null){
            return ResponseEntity.ok(res);
        }else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping(value="/boardAuthor/{userName}")
    public ResponseEntity<List<BoardResponse>> showUserBoardPage(@PathVariable String userName)
    {
        List<BoardResponse>BoardList=boardService.getBoardByUser(userName);;
        if(BoardList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(BoardList);
        }
    }
}
