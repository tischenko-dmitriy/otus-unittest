package otus.study.cashmachine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import otus.study.cashmachine.bank.dao.AccountDao;
import otus.study.cashmachine.bank.dao.CardsDao;

@Configuration
public class BeanConfiguration {

    @Bean(name = "accountDao")
    public AccountDao configureAccountDao() {
        return new AccountDao();
    }

    @Bean(name = "cardsDao")
    public CardsDao configureCardsDao() {
        return new CardsDao();
    }


}
