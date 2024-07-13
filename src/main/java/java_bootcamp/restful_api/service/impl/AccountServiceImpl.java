package java_bootcamp.restful_api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import java_bootcamp.restful_api.model.Account;
import java_bootcamp.restful_api.repository.AccountRepository;
import java_bootcamp.restful_api.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  public AccountServiceImpl(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Account findById(Long id) {
    return accountRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  @Override
  public Account create(Account account) {
    if (accountRepository.existsByNickname(account.getNickname())) {
      throw new IllegalArgumentException("This nickname is already used");
    }
    if (accountRepository.existsByEmail(account.getEmail())) {
      throw new IllegalArgumentException("This e-mail is already used");
    }
    return accountRepository.save(account);
  }
}
