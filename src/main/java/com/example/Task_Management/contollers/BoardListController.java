package com.example.Task_Management.contollers;

import com.example.Task_Management.Utilities.JwtTokenUtil;
import com.example.Task_Management.dto.response.JwtResponse;
import com.example.Task_Management.dto.response.UnifiedRes;
import com.example.Task_Management.entities.Board;
import com.example.Task_Management.entities.BoardList;
import com.example.Task_Management.entities.User;
import com.example.Task_Management.services.BoardListService;
import com.example.Task_Management.services.BoardService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BoardListController {
    @Autowired
    BoardListService boardListService;
    @RequestMapping(value = "/boardLists/{listId}",method = RequestMethod.GET)
    public ResponseEntity<BoardList> getBoardListById(@PathVariable String listId){ // Gets Board by id, send List id in parameters.
        return new ResponseEntity<BoardList>(boardListService.getBoardList(listId),HttpStatus.OK );
    }
    @RequestMapping(value = "/boardLists/create",method = RequestMethod.POST)
    public ResponseEntity<BoardList> create(@RequestBody BoardList list){ // Gets Board by id, send List id in parameters.
        return new ResponseEntity<BoardList>(boardListService.createBoardList(list),HttpStatus.OK );
    }
    @RequestMapping(value = "/boardLists/update",method = RequestMethod.POST)
    public ResponseEntity<BoardList> updatePosition(@RequestBody BoardList list){ // List id and new position is mandatory.
        // it will only update provided list position if it exists,
        return new ResponseEntity<BoardList>(boardListService.update(list),HttpStatus.OK );
    }
    @RequestMapping(value = "/boardLists/delete",method = RequestMethod.POST)
    public ResponseEntity<UnifiedRes> delete(@RequestBody BoardList list){ // Deletes the list by id.
        boardListService.delete(list);
        return new ResponseEntity<UnifiedRes>(new UnifiedRes("Deleted Successfully",
                200,
                null),
                HttpStatus.OK );
    }
}
