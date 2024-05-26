package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.domain.Comment;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.dto.CommentResponse;
import org.example.likelionkwu.service.CommentService;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value = "/{boardId}/comment/create")
    public ResponseEntity<String> CreateComment(@RequestBody CommentRequest req)
    {

        if(commentService.CreateComment(req)!=null){
            return ResponseEntity.ok("댓글 생성 완료");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value="/{boardId}/comment")
    public ResponseEntity<Pair<List<CommentResponse>,String>> showComments(@PathVariable Long boardId)
    {
        Pair<List<CommentResponse>,String> result=commentService.getComments(boardId);
        if(result.getFirst().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(result);
        }
    }
}
