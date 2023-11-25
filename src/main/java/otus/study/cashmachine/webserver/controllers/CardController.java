package otus.study.cashmachine.webserver.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import otus.study.cashmachine.webserver.dto.CardDto;
import otus.study.cashmachine.webserver.dto.MoneyDto;
import otus.study.cashmachine.webserver.dto.PinDto;
import otus.study.cashmachine.webserver.service.CardDtoService;

import java.math.BigDecimal;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/card")
public class CardController {

    private final CardDtoService cardDtoService;

    @PostMapping(
            consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public CardDto create(@RequestBody CardDto cardDto) {
        return cardDtoService.create(cardDto);
    }

    @PostMapping(value = "/change-pin",
            consumes = "application/json; charset=UTF-8")
    public void changePin(@RequestBody PinDto pinDto) {
        cardDtoService.changePin(pinDto);
    }

    @GetMapping(value = "/{number}",
            produces = "application/json; charset=UTF-8")
    public Sum getBalance(@PathVariable(value = "number") String number,
                                 @RequestParam(name = "pin") String pin) {
        return new Sum(cardDtoService.getBalance(number, pin));
    }

    @GetMapping(value = "/money",
            consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public Sum getMoney(@RequestBody MoneyDto moneyDto) {
        return new Sum(cardDtoService.getMoney(moneyDto));
    }

    @PostMapping(value = "/money",
            consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public Sum putMoney(@RequestBody MoneyDto moneyDto) {
        return new Sum(cardDtoService.putMoney(moneyDto));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonAutoDetect
    private static class Sum {
        @JsonProperty(value = "money")
        private BigDecimal money;
    }

}
