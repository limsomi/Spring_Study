# 과제(~5/16)
## 광운대학교 멋쟁이사자처럼 홈페이지

### QnA 게시판

- 멋쟁이사자처럼 홈페이지 기능 중 하나인 QnA 게시판 만들기
- 테스트 코드 X
- 개별 브랜치에서 작성

---

1. 도메인
    - `User`
        - username: 사용자명 → String
        
    - `Board`
        - boardId: 질문글 고유의 id → Long
        - boardTitle: 질문글 제목 → String
        - boardAuthor: 질문글 작성자(User의 username → 일대다 관계) → String
        - boardContent: 질문글 내용 → String
        - comments: 댓글들(Commet와 일대다 관계) → List<Comment>
    - `Comment`
        - commentId: 댓글 고유의 id → Long
        - commentAuthor: 댓글 작성자(User의 username → 일대다 관계) → String
        - commentContent: 댓글 내용 → String
        - board: 댓글에 매칭되는 질문글(Board와 다대일 관계)
2. API
    - `Board`
        - /api/board/create
            - 질문글 생성
            - 입력: username, boardTitle, boardContent
            - 입력한 username을 boardAuthor에 저장
            - boardId는 자동 생성
            - username을 `User`도메인에 저장(동일한 username이 있으면 저장하지 않음)
        - /api/board
            - 전체 질문글 조회
            - 반환값: boardId, boardTitle, boardAuthor, boardContent
        - /api/board/boardId/{boardId}
            - 개별 질문글 조회
            - 반환값: boardId, boardTitle, boardAuthor, boardContent
        - /api/board/boardAuthor/{boardAuthor}
            - 해당 사용자가 작성한 모든 질문글 조회
            - 반환값: boardId, boardTitle, boardAuthor, boardContent
        
    - `Comment`
        - /api/board/{boardId}/comment/create
            - 댓글 작성
            - 입력: username, commentContent
            - 입력한 username을 commentAuthor에 저장
            - commentId는 자동 생성
            - username을 `User`도메인에 저장(동일한 username이 있으면 저장하지 않음)
            - `boardId`에 해당하는 `Board`를 갖고와서 댓글을 작성
        - /api/board/{boardId}/comment
            - boardId에 해당하는 게시글의 댓글 조회
            - 반환값: commentId, commentAuthor, commentContent, boardId(board.boardId), boardTitle(board.boardTitle)
3. 프로젝트 구조
    - `domain`
        - User
        - Board
        - Comment
    - `controller`
        - BoardController
        - CommentController
    - `repository`
        - UserRepository
        - BoardRepository
        - CommentRepository
    - `service`
        - BoardService
        - CommentService
    - `dto`
        - BoardRequest
        - BoardResponse
        - CommentRequest
        - CommentResponse
