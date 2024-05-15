package org.example.likelionkwu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.domain.Comment;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {

    private Long boardId;
    private String boardTitle;
    private String boardAuthor;
    private String boardContent;
    private List<Comment> comments;

    public Board toEntity(){
        return Board.builder()
                .boardId(boardId)
                .boardTitle(boardTitle)
                .boardAuthor(boardAuthor)
                .boardContent(boardContent)
                .comments(comments)
                .build();
    }

}
