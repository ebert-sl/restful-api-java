package java_bootcamp.restful_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java_bootcamp.restful_api.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
  boolean existsByNickname(String nickname);
  boolean existsByEmail(String email);
}
