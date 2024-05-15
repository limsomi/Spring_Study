package org.example.likelionkwu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.BoardResponse;

import java.util.ArrayList;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Board")
public class Board{

    @Id
    Long boardId;
    String boardTitle;
    String boardAuthor;
    String boardContent;
    ArrayList<String> comments;

    public BoardRequest toBoardRequest() {
        return BoardRequest.builder()
                .boardId(boardId)
                .boardTitle(boardTitle)
                .boardAuthor(boardAuthor)
                .boardContent(boardContent)
                .comments(comments)
                .build();

    }

    public BoardResponse toBoardResponse() {
        return BoardResponse.builder()
                .boardId(boardId)
                .boardTitle(boardTitle)
                .boardAuthor(boardAuthor)
                .boardContent(boardContent)
                .comments(comments)
                .build();

    }

}
