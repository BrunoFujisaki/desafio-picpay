package brunofujisaki.picpay_desafio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://util.devi.tools/api/v2/authorize", name = "AuthorizationClient")
public interface AuthorizationClient {
    @GetMapping
    ResponseEntity getAuthorization();
}
