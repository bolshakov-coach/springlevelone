package pro.bolshakov.geekbrains.lesson4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.bolshakov.geekbrains.lesson4.domain.AuthorSell;
import pro.bolshakov.geekbrains.lesson4.domain.AuthorDateKey;

public interface AuthorSellDAO extends JpaRepository<AuthorSell, AuthorDateKey> {
}
