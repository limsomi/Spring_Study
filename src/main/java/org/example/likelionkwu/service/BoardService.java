package org.example.likelionkwu.service;

import lombok.RequiredArgsConstructor;
import org.example.likelionkwu.domain.Board;
import org.example.likelionkwu.domain.User;
import org.example.likelionkwu.dto.BoardRequest;
import org.example.likelionkwu.dto.BoardResponse;
import org.example.likelionkwu.repository.BoardRepository;
import org.example.likelionkwu.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    public BoardResponse getBoardById(Long boardId)
    {
        Optional<Board> optBoard=boardRepository.findById(boardId);


        if(optBoard.isEmpty())
        {
            return null;
        }

        return BoardResponse.of(optBoard.get());
    }

    public List<BoardResponse> getBoards()
    {
        List<Board> boardListEntity =boardRepository.findAll();
        List<BoardResponse> boardListDto=boardListEntity
                .stream()
                .map(m-> BoardResponse.of(m))
                .collect(Collectors.toList());
        return boardListDto;
    }

    public List<BoardResponse> getBoardByUser(String boardAuthor)
    {
        List<Board> boardListEntity=boardRepository.findAllByBoardAuthor(boardAuthor);
        List<BoardResponse> boardListDto=boardListEntity
                .stream()
                .map(m-> BoardResponse.of(m))
                .collect(Collectors.toList());
        return boardListDto;
    }

    public Board writeBoard(BoardRequest req)
    {
        String userAuthor=req.getBoardAuthor();
        if(!userRepository.existsByUserName(userAuthor))
        {
            User userEntity=User.builder()
                    .userName(userAuthor)
                    .build();
            userRepository.save(userEntity);
        }
        Board saveBoard =boardRepository.save(req.toEntity());
        return saveBoard;
    }
}
