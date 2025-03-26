package brunofujisaki.picpay_desafio.model.user;

import brunofujisaki.picpay_desafio.dto.UserDto;
import brunofujisaki.picpay_desafio.model.transaction.Transaction;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType type;

    public User(UserDto dto) {
        this.name = dto.name();
        this.document = dto.document();
        this.email = dto.email();
        this.balance = dto.balance();
        this.type = dto.type();
    }

    public void updateBalance(BigDecimal value, boolean add) {
        if (add)
            this.balance = this.balance.add(value);
        else
            this.balance = this.balance.subtract(value);
    }
}
