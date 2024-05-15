package org.example.likelionkwu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.dto.CommentResponse;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Comment")
public class Comment {

    @Id
    Long commentId;
    String commentAuthor;
    String commentContent;
    Long boardId;

    public CommentRequest toCommentRequest(){
        return CommentRequest.builder()
                .commentId(commentId)
                .commentAuthor(commentAuthor)
                .commentContent(commentContent)
                .boardId(boardId)
                .build();
    }

    public CommentResponse toCommentResponse(){
        return CommentResponse.builder()
                .commentId(commentId)
                .commentAuthor(commentAuthor)
                .commentContent(commentContent)
                .boardId(boardId)
                .build();
    }
}
