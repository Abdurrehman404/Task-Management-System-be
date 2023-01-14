package com.example.Task_Management.contollers;
import com.example.Task_Management.entities.Card;
import com.example.Task_Management.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin( origins = {"https://serene-sunburst-fefdc0.netlify.app"})
@RestController
public class CardController {
    @Autowired
    CardService cardService;
    @RequestMapping(value = "/cards/create",method = RequestMethod.POST)
    public ResponseEntity<Card> create(@RequestBody Card card){ // Creates Card from JSON object.
        return new ResponseEntity<Card>(cardService.createCard(card), HttpStatus.OK );
    }
    @RequestMapping(value = "/cards/delete",method = RequestMethod.POST)
    public ResponseEntity<Card> delete(@RequestBody Card card){ // Deletes Card from JSON object.
        cardService.deleteCard(card);
        return new ResponseEntity<Card>(new Card(),HttpStatus.OK);
    }
    @RequestMapping(value = "/cards/update",method = RequestMethod.POST)
    public ResponseEntity<Card> update(@RequestBody Card card){ // Updates Card from JSON object.
        return new ResponseEntity<Card>(cardService.updateCard(card),HttpStatus.OK);
    }
    @RequestMapping(value = "/cards/{cardId}",method = RequestMethod.GET)
    public ResponseEntity<Card> getCardById(@PathVariable String cardId){ // Gets card by card id.
        return new ResponseEntity<Card>(cardService.cardByCardId(cardId), HttpStatus.OK );
    }
}
