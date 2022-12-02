package com.example.Task_Management.services;

import com.example.Task_Management.entities.Board;
import com.example.Task_Management.entities.BoardList;
import com.example.Task_Management.entities.Card;
import com.example.Task_Management.repositories.BoardListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardListServiceImpl implements BoardListService {
    @Autowired
    BoardListRepository boardListRepository;
    @Autowired
    CardServiceImpl cardService;
    @Override
    public BoardList getBoardList(String listId) {
        Optional<BoardList> boardList = boardListRepository.findById(listId);
        return boardList.orElse(null);
    }
    @Override
    public BoardList createBoardList(BoardList boardList) {
        return boardListRepository.insert(boardList);
    }

    @Override
    public BoardList update(BoardList list) {
        Optional<BoardList> lis = boardListRepository.findById(list.getId());

        if(lis.isPresent()){// add as much entities
            lis.get().setTitle(list.getTitle());
            lis.get().setCardList(list.getCardList());
            return boardListRepository.save(lis.get());
        }
        else return null;
    }
    @Override
    public void delete(BoardList list) {
        Optional<BoardList> boardlist = boardListRepository.findById(list.getId());
        if(boardlist.isPresent()){
            for(int i = 0 ; i < boardlist.get().getCardList().size() ; i++){
                Card card = new Card();
                card.setId(boardlist.get().getCardList().get(i));
                cardService.deleteCard(card);
            }
        }
        boardListRepository.deleteById(list.getId());
    }
    public BoardList createToDoList(){
        BoardList bList = new BoardList();
        bList.setTitle("To Do");
        return boardListRepository.insert(bList);
    }
}
