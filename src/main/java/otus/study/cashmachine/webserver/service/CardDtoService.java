package otus.study.cashmachine.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otus.study.cashmachine.bank.data.Card;
import otus.study.cashmachine.bank.service.CardService;
import otus.study.cashmachine.bank.service.impl.CardServiceImpl;
import otus.study.cashmachine.webserver.dto.CardDto;
import otus.study.cashmachine.webserver.dto.MoneyDto;
import otus.study.cashmachine.webserver.dto.PinDto;

import java.math.BigDecimal;

@Service
public class CardDtoService {

    private final CardService cardService;

    @Autowired
    public CardDtoService(CardServiceImpl cardService) {
        this.cardService = cardService;
    }

    public CardDto create(CardDto cardDto) {
        return cardToCardDto(cardService.createCard(
                cardDto.getNumber(), cardDto.getAccountId(), cardDto.getPinCode()));
    }

    public void changePin(PinDto pinDto) {
        cardService.cnangePin(pinDto.getNumber(), pinDto.getOldPin(), pinDto.getNewPin());
    }

    public BigDecimal getBalance(String number, String pin) {
        return cardService.getBalance(number, pin);
    }

    public BigDecimal getMoney(MoneyDto moneyDto) {
        return cardService.getMoney(moneyDto.getNumber(), moneyDto.getPin(), moneyDto.getSum());
    }

    public BigDecimal putMoney(MoneyDto moneyDto) {
        return cardService.putMoney(moneyDto.getNumber(), moneyDto.getPin(), moneyDto.getSum());
    }

    private CardDto cardToCardDto(Card card) {
        return new CardDto(card.getAccountId(), card.getNumber(), card.getPinCode());
    }

}
