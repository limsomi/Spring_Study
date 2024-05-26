package org.example.likelionkwu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty
    private String boardTitle;
    @JsonProperty
    private String boardAuthor;
    @JsonProperty
    private String boardContent;

    public Board toEntity(){
        return Board.builder()
                .boardTitle(boardTitle)
                .boardAuthor(boardAuthor)
                .boardContent(boardContent)
                .build();
    }

}
