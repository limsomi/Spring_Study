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
public class BoardResponse {

    private Long boardId;
    private String boardTitle;
    private String boardAuthor;
    private String boardContent;


    public static BoardResponse of(Board board)
    {
        return BoardResponse.builder()
                .boardId(board.getBoardId())
                .boardTitle(board.getBoardTitle())
                .boardAuthor(board.getBoardAuthor())
                .boardContent(board.getBoardContent())
                .build();
    }
}
