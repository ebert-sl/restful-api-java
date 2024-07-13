package java_bootcamp.restful_api.service;

import java_bootcamp.restful_api.model.Account;

public interface AccountService {
  Account findById(Long id);
  Account create(Account account);
}
