package spingboot.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spingboot.example.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
