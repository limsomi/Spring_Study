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
public class CommentResponse {

    private  Long commentId;
    private String commentAuthor;
    private  String commentContent;
    private Long boardId;


    public static CommentResponse of(Comment comment)
    {
        return CommentResponse.builder()
                .commentId(comment.getCommentId())
                .commentAuthor(comment.getCommentAuthor())
                .commentContent(comment.getCommentContent())
                .boardId(comment.getBoardId())
                .build();
    }
}
