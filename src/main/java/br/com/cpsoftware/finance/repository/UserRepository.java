package br.com.cpsoftware.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cpsoftware.finance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}