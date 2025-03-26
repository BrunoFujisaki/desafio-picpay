package brunofujisaki.picpay_desafio.model.transaction;

import brunofujisaki.picpay_desafio.dto.TransactionDto;
import brunofujisaki.picpay_desafio.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal value;
    @ManyToOne(fetch = FetchType.LAZY)
    private User payer;
    @ManyToOne(fetch = FetchType.LAZY)
    private User payee;


    public Transaction(BigDecimal value, User payer, User payee) {
        this.value = value;
        this.payer = payer;
        this.payee = payee;
    }
}
