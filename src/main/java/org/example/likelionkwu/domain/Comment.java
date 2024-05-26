package org.example.likelionkwu.domain;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentId;
    @Column
    String commentAuthor;
    @Column
    String commentContent;
    Long boardId;

}
