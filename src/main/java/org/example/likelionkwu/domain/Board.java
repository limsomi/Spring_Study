package org.example.likelionkwu.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.BoardResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Board")
public class Board{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    @Column
    private String boardTitle;
    @Column
    private String boardAuthor;
    @Column
    private String boardContent;

    @OneToMany(mappedBy = "boardId",cascade = CascadeType.REMOVE)
    private List<Comment> comments;

}
