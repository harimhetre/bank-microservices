package com.bank.cards.mapper;

import com.bank.cards.dto.CardsDto;
import com.bank.cards.entity.Cards;

import java.time.LocalDateTime;

public class CardsMapper {
    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards existingCard) {
        existingCard.setMobileNumber(cardsDto.getMobileNumber());
        existingCard.setCardNumber(cardsDto.getCardNumber());
        existingCard.setCardType(cardsDto.getCardType());
        existingCard.setTotalLimit(cardsDto.getTotalLimit());
        existingCard.setAmountUsed(cardsDto.getAmountUsed());
        existingCard.setAvailableAmount(cardsDto.getAvailableAmount());
        return existingCard;
    }
}
