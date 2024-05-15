package org.example.likelionkwu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.domain.Comment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {

    private  Long commentId;
    private String commentAuthor;
    private  String commentContent;
    private Long boardId;

    public Comment toEntity(){
        return Comment.builder()
                .commentId(commentId)
                .commentAuthor(commentAuthor)
                .commentContent(commentContent)
                .boardId(boardId)
                .build();
    }
}
