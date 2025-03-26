package brunofujisaki.picpay_desafio.service;

import brunofujisaki.picpay_desafio.dto.UserDto;
import brunofujisaki.picpay_desafio.infra.exception.DocumentException;
import brunofujisaki.picpay_desafio.model.user.User;
import brunofujisaki.picpay_desafio.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createUser(UserDto dto) {
        if (repository.existsByDocumentOrEmail(dto.document(), dto.email())) throw new DocumentException("Documents or email already exists.");
        repository.save(new User(dto));
    }
}
