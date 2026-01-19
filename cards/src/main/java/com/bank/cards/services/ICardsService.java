package com.bank.cards.services;

import com.bank.cards.dto.CardsDto;

public interface ICardsService {
    void createCard(String mobileNumber);

    CardsDto fetchCardDetails(String mobileNumber);

    void updateCard(String mobileNumber, CardsDto cardsDto);

    void deleteCard(String mobileNumber);
}
