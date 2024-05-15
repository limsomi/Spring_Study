package org.example.likelionkwu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelionkwu.domain.Board;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {

    private Long boardId;
    private String boardTitle;
    private String boardAuthor;
    private String boardContent;
    private ArrayList<String> comments;

    public Board toEntity(){
        return Board.builder()
                .boardId(boardId)
                .boardTitle(boardTitle)
                .boardAuthor(boardAuthor)
                .boardContent(boardContent)
                .comments(comments)
                .build();
    }

    public static BoardResponse of(Board board)
    {
        return BoardResponse.builder()
                .boardId(board.getBoardId())
                .boardTitle(board.getBoardTitle())
                .boardAuthor(board.getBoardAuthor())
                .boardContent(board.getBoardContent())
                .comments(board.getComments())
                .build();
    }
}
