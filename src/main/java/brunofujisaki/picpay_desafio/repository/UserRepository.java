package brunofujisaki.picpay_desafio.repository;

import brunofujisaki.picpay_desafio.model.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByDocumentOrEmail(String document, String email);
}
