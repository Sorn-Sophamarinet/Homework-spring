package kh.edu.istasd.fswdapi.init;

import jakarta.annotation.PostConstruct;
import kh.edu.istasd.fswdapi.domain.AccountType;
import kh.edu.istasd.fswdapi.repository.AccountTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountTypeInitialize {

    private final AccountTypeRepository accountTypeRepository;

    @PostConstruct
    public void init() {
        if (accountTypeRepository.count() == 0) {
            AccountType payroll = new AccountType();
            payroll.setName("PAYROLL");

            AccountType saving = new AccountType();
            saving.setName("SAVING");

            AccountType junior = new AccountType();
            junior.setName("JUNIOR");

            accountTypeRepository.saveAll(List.of(payroll, saving, junior));
        }
    }

}