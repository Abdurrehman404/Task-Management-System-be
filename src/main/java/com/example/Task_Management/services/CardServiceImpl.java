package com.example.Task_Management.services;

import com.example.Task_Management.entities.Card;
import com.example.Task_Management.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;
    @Override
    public Card createCard(Card card) {
        return cardRepository.insert(card);
    }

    @Override
    public Card cardByCardId(String id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.orElse(null);
    }
    @Override
    public void deleteCard(Card card) {
        Optional<Card> card1 = cardRepository.findById(card.getId());
        card1.ifPresent(value -> cardRepository.delete(value));
    }

    @Override
    public Card updateCard(Card card) {
        Optional<Card> card1 = cardRepository.findById(card.getId());
        if(card1.isPresent()){
            card1.get().setTitle(card.getTitle());
            card1.get().setTask(card.getTask());
            card1.get().setType(card.getType());
            return cardRepository.save(card1.get());
        }
        return null;
    }
}
