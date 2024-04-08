package br.com.cpsoftware.finance.repository;

import br.com.cpsoftware.finance.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
