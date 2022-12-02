package com.example.Task_Management.services;

import com.example.Task_Management.entities.Card;

import java.util.List;

public interface CardService {
    Card createCard(Card card);
    Card cardByCardId(String id);
    void deleteCard(Card card);
    Card updateCard(Card card);
}

