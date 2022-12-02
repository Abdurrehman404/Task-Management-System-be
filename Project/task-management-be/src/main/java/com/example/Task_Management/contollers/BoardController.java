package com.example.Task_Management.contollers;

import com.example.Task_Management.entities.Board;
import com.example.Task_Management.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin( origins = {"http://localhost:3000"})// (origins = "http://localhost:3000", methods = {RequestMethod.GET} ,allowedHeaders = "*")
@RestController
public class BoardController {
    @Autowired
    BoardService boardService;
    @RequestMapping(value = "/board/create", method = RequestMethod.POST)
    private ResponseEntity<Board> createBoard(@RequestBody String userName) {
        return new ResponseEntity(boardService.createBoard(userName), HttpStatus.OK); // Creates board with the value
        // assignedTo to userName. Provide "userName" in POST request and board will be created.
    }
    @RequestMapping(value = "/board/update", method = RequestMethod.POST)
    public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
        return new ResponseEntity(boardService.updateBoard(board), HttpStatus.OK); // To update Board, MUST Provide Board id in JSON format.
        // Only BoardName and assignedTo can be updated through this API call.
    }
    @RequestMapping(value = "/board/{userName}", method = RequestMethod.GET)
    public ResponseEntity<Board> getBoard(@PathVariable String userName) {

        Board board = boardService.getBoard(userName);
        if(board == null){

            createBoard(userName);
            board = boardService.getBoard(userName);
            // Checks if the Board with specific userName exists or not
            return new ResponseEntity(board, HttpStatus.OK); // If not then it first created board with
            // provided userName and then it returns that newly created instance.
            // when new instance is created, To Do list is also created.
        }
        return new ResponseEntity(board, HttpStatus.OK); // If yes then returned
    }
}
