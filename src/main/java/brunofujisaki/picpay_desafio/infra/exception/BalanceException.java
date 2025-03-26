package brunofujisaki.picpay_desafio.infra.exception;

public class BalanceException extends RuntimeException{
    public BalanceException(String message) {
        super(message);
    }
}
