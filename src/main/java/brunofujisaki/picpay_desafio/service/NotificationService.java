package brunofujisaki.picpay_desafio.service;

import brunofujisaki.picpay_desafio.client.NotificationClient;
import brunofujisaki.picpay_desafio.infra.exception.NotificationException;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification() {
        try {
            notificationClient.sendNotification();
        } catch (Exception e) {
            throw new NotificationException("Notification service unavailable.");
        }
    }
}
