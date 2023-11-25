package otus.study.cashmachine.webserver.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import otus.study.cashmachine.webserver.dto.AccountDto;
import otus.study.cashmachine.webserver.service.AccountDtoService;

import java.math.BigDecimal;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountDtoService accountDtoService;

    @PostMapping(
            consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public AccountDto createAccount(@RequestBody Amount amount) {
        return accountDtoService.createAccount(amount.getAmount());
    }

    @GetMapping(value = "/{id}",
            produces = "application/json; charset=UTF-8")
    public AccountDto getAccount(@PathVariable(value = "id") long id) {
        return accountDtoService.getAccount(id);
    }

    @PutMapping(value = "/{id}",
            consumes = "application/json; charset=UTF-8",
            produces = "application/json; charset=UTF-8")
    public BigDecimal putMoney(@PathVariable(value = "id") Long id,
                               @RequestParam(name = "amount") int amount) {
        return accountDtoService.getMoney(id, BigDecimal.valueOf(amount));
    }

    @GetMapping(value = "/{id}/check",
            produces = "application/json; charset=UTF-8")
    public Amount checkBalance(@PathVariable(value = "id") Long id) {
        return new Amount(accountDtoService.checkBalance(id));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonAutoDetect
    private static class Amount {
        @JsonProperty(value = "amount")
        private BigDecimal amount;
    }

}
