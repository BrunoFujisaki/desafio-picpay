package brunofujisaki.picpay_desafio.service;

import brunofujisaki.picpay_desafio.client.AuthorizationClient;
import brunofujisaki.picpay_desafio.infra.exception.AuthorizationException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public void verifyAuthorization() {
        try {
            authorizationClient.getAuthorization();
        } catch (Exception e) {
            throw new AuthorizationException("Transfer not authorized.");
        }
    }
}
