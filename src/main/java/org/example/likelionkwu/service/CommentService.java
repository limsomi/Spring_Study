package org.example.likelionkwu.service;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.domain.Comment;
import org.example.likelionkwu.domain.User;
import org.example.likelionkwu.dto.CommentRequest;
import org.example.likelionkwu.dto.CommentResponse;
import org.example.likelionkwu.repository.BoardRepository;
import org.example.likelionkwu.repository.CommentRepository;
import org.example.likelionkwu.repository.UserRepository;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    public void CreateComment(CommentRequest req)
    {
        String userName=req.getCommentAuthor();

        if(!userRepository.existByUserName(userName))
        {
            User userEntity=User.builder()
                    .UserName(userName)
                    .build();
            userRepository.save(userEntity);
        }

        Comment saveComment=commentRepository.save(req.toEntity());
        Long boardId=req.getBoardId();

        Board board=boardRepository.findById(boardId).get();

        board.getComments().add(saveComment);

    }

    public Pair<List<CommentResponse>,String> getComments(Long boardId)
    {
        Optional<Board> board=boardRepository.findById(boardId);
        String boardTitle=board.get().getBoardTitle();
        List<Comment> commentsEntity=board.get().getComments();
        List<CommentResponse> commentsDto=commentsEntity
                .stream()
                .map(m->CommentResponse.of(m))
                .collect(Collectors.toList());
        return Pair.of(commentsDto,boardTitle);
    }
}
