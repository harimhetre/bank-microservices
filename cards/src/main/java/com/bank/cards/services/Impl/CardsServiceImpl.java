package com.bank.cards.services.Impl;

import com.bank.cards.constants.CardsConstants;
import com.bank.cards.dto.CardsDto;
import com.bank.cards.entity.Cards;
import com.bank.cards.exception.CardAlreadyExistException;
import com.bank.cards.exception.ResourceNotFoundException;
import com.bank.cards.mapper.CardsMapper;
import com.bank.cards.repository.CardsRepository;
import com.bank.cards.services.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
       Optional<Cards> cards =  cardsRepository.findByMobileNumber(mobileNumber);
       if(cards.isPresent()){
           throw new CardAlreadyExistException("Card", "Mobile Number", mobileNumber);
       }
       Cards card = new Cards();
       cardsRepository.save(crateNewCard(card, mobileNumber));
    }

    private Cards crateNewCard(Cards card, String mobileNumber) {
        card.setMobileNumber(mobileNumber);
        card.setCardType(CardsConstants.CREDIT_CARD);
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        card.setCardNumber(String.valueOf(randomCardNumber));
        card.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        card.setAmountUsed(0);
        card.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return card;
    }


    @Override
    public CardsDto fetchCardDetails(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobile number", mobileNumber)
        );
        CardsDto cardsDto = new CardsDto();
        return CardsMapper.mapToCardsDto(cards, cardsDto);
    }

    @Override
    public void updateCard(String mobileNumber, CardsDto cardsDto) {
        Cards existingCard = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobile number", mobileNumber)
        );

      Cards card = CardsMapper.mapToCards(cardsDto, existingCard);
      cardsRepository.save(card);
    }

    @Override
    public void deleteCard(String mobileNumber) {
        Cards existingCard = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Cards", "mobile number", mobileNumber)
        );
        cardsRepository.deleteByMobileNumber(mobileNumber);
    }
}
