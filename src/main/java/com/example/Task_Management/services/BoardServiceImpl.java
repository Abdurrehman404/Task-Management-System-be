package com.example.Task_Management.services;

import com.example.Task_Management.entities.Board;
import com.example.Task_Management.entities.BoardList;
import com.example.Task_Management.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardRepository boardRepo;
    @Autowired
    BoardListServiceImpl boardListService;
    @Override
    public Board createBoard(String userName) {
        Board board = new Board();
        board.setAssignedTo(userName);
        board.getListIds().add(boardListService.createToDoList().getId());
        return boardRepo.insert(board);
    }
    @Override
    public Board updateBoard(Board board){
        Optional<Board> bObj = boardRepo.findById(board.getId());
        if(bObj.isPresent()){
            bObj.get().setId(board.getId());
            bObj.get().setBoardName(board.getBoardName());
            bObj.get().setUpdatedOn(LocalDateTime.now());
            bObj.get().setAssignedTo(board.getAssignedTo());
            bObj.get().setListIds(board.getListIds());
            return boardRepo.save(bObj.get());
        }
        return null;
    }
    @Override
    public Board getBoard(String userName) {
        return boardRepo.findBoardByAssignedTo(userName);
    }


}
