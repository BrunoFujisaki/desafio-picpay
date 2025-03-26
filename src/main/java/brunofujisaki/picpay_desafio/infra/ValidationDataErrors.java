package brunofujisaki.picpay_desafio.infra;

import org.springframework.validation.FieldError;

public record ValidationDataErrors(
        String field,
        String message
) {
    public ValidationDataErrors(FieldError fe) {
        this(fe.getField(), fe.getDefaultMessage());
    }
}
