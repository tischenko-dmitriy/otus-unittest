package otus.study.cashmachine.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import otus.study.cashmachine.bank.data.Account;
import otus.study.cashmachine.bank.service.AccountService;
import otus.study.cashmachine.bank.service.impl.AccountServiceImpl;
import otus.study.cashmachine.webserver.dto.AccountDto;

import java.math.BigDecimal;

@Service
public class AccountDtoService {

    private final AccountService accountService;

    @Autowired
    public AccountDtoService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public AccountDto createAccount(BigDecimal amount) {
        return accountToAccountDto(accountService.createAccount(amount));
    }

    public AccountDto getAccount(long id) {
        return accountToAccountDto(accountService.getAccount(id));
    }

    public BigDecimal getMoney(Long id, BigDecimal amount) {
        return accountService.getMoney(id, amount);
    }

    public BigDecimal checkBalance(Long id) {
        return accountService.checkBalance(id);
    }

    private AccountDto accountToAccountDto(Account account) {
        return new AccountDto(account.getAmount(), account.getId());
    }

}
