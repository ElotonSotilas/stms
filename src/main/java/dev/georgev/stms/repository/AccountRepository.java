package dev.georgev.stms.repository;

import dev.georgev.stms.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT COUNT(account_id) from Account")
    long getAccountsCount(@Param("account_id") Long id);
}
