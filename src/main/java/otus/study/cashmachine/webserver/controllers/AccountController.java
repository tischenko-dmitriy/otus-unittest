package otus.study.cashmachine.webserver.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import otus.study.cashmachine.webserver.dto.AccountDto;
import otus.study.cashmachine.webserver.service.AccountDtoService;

import java.math.BigDecimal;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(value = "/account",
    consumes = "application/json; charset=UTF-8",
    produces = "application/json; charset=UTF-8")
public class AccountController {

    private final AccountDtoService accountDtoService;

    @PostMapping
    public AccountDto createAccount(@RequestBody Amount amount) {
        return accountDtoService.createAccount(amount.getAmount());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<AccountDto> getAccount(@PathVariable(value = "id") Long id) {
        AccountDto accountDto = accountDtoService.getAccount(id);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public BigDecimal putMoney(@PathVariable(value = "id") Long id,
                               @RequestParam(name = "amount") int amount) {
        return accountDtoService.getMoney(id, BigDecimal.valueOf(amount));
    }

    @GetMapping(value = "/{id}/check")
    public BigDecimal checkBalance(@PathVariable(value = "id") Long id) {
        return accountDtoService.checkBalance(id);
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
