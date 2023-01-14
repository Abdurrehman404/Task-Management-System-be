package com.example.Task_Management.services;
import com.example.Task_Management.entities.BoardList;
import org.springframework.http.ResponseEntity;

public interface BoardListService {
    BoardList getBoardList(String listId);
    BoardList createBoardList(BoardList boardList);
    BoardList update(BoardList list);
    void delete(BoardList list);
}
