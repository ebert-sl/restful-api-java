package java_bootcamp.restful_api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java_bootcamp.restful_api.model.Account;
import java_bootcamp.restful_api.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account> findById(@PathVariable Long id) {
    var account = accountService.findById(id);
    return ResponseEntity.ok(account);
  }

  @PostMapping
  public ResponseEntity<Account> create(@RequestBody Account account) {
    var accountCreated = accountService.create(account);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(accountCreated.getId())
      .toUri();
    return ResponseEntity.created(location).body(accountCreated);
  }
}
