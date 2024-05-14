package org.example.likelionkwu.domain;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.dto.CommentResponse;

@Getter
@Setter
@Builder
@Table(name="Comment")
public class Comment {

    @Id
    Long commentId;
    String commentAuthor;
    String commentContent;
    Board board;

    public CommentRequest toCommentRequest(){
        return CommentRequest.builder()
                .commentId(commentId)
                .commentAuthor(commentAuthor)
                .commentContent(commentContent)
                .board(board)
                .build();
    }

    public CommentResponse toCommentResponse(){
        return CommentResponse.builder()
                .commentId(commentId)
                .commentAuthor(commentAuthor)
                .commentContent(commentContent)
                .board(board)
                .build();
    }
}
