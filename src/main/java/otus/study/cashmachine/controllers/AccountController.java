package otus.study.cashmachine.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import otus.study.cashmachine.bank.data.Account;
import otus.study.cashmachine.bank.service.AccountService;
import otus.study.cashmachine.bank.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/account",
    consumes = "application/json; charset=UTF-8",
    produces = "application/json; charset=UTF-8")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Long createAccount(@RequestBody Amount amount) {
        return accountService.createAccount(amount.getAmount()).getId();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Account> getAccount(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public BigDecimal putMoney(@PathVariable(value = "id") Long id,
                                   @RequestParam(name = "amount") int amount) {
        return accountService.getMoney(id, BigDecimal.valueOf(amount));
    }

    @GetMapping(value = "/{id}/check")
    public BigDecimal checkBalance(@PathVariable(value = "id") Long id) {
        return accountService.checkBalance(id);
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
