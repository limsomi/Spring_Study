package org.example.likelionkwu.controller;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.domain.Comment;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.dto.CommentResponse;
import org.example.likelionkwu.service.CommentService;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping(value = "/{boardId}/comment/create")
    public void CreateComment(@RequestBody CommentRequest req)
    {
        commentService.CreateComment(req);
    }

    @GetMapping(value="/{boardId}/comment")
    public Pair<List<CommentResponse>,String> showComments(@PathVariable Long boardId)
    {
        Pair<List<CommentResponse>,String> result=commentService.getComments(boardId);
        return result;
    }
}
