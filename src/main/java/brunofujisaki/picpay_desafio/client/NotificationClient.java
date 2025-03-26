package brunofujisaki.picpay_desafio.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "https://util.devi.tools/api/v1/notify", name = "NotificationClient")
public interface NotificationClient {
    @PostMapping
    ResponseEntity sendNotification();
}
