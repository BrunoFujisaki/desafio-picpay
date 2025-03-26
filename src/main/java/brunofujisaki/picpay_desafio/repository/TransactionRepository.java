package brunofujisaki.picpay_desafio.repository;

import brunofujisaki.picpay_desafio.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
