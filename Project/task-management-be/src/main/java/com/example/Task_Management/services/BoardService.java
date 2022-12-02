package com.example.Task_Management.services;

import com.example.Task_Management.entities.Board;
import com.example.Task_Management.entities.User;
import com.example.Task_Management.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface BoardService {
    Board createBoard(String userName);
    Board updateBoard(Board board);
    Board getBoard(String userName);
}
