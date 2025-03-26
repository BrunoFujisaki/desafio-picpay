package brunofujisaki.picpay_desafio.infra.exception;

public class NotificationException extends RuntimeException {
    public NotificationException(String message) {
        super(message);
    }
}
