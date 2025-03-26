package brunofujisaki.picpay_desafio.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDto(
        @NotNull(message = "Value cannot be null")
        BigDecimal value,
        @NotNull(message = "Payer id cannot be null")
        Long payer,
        @NotNull(message = "Payee id cannot be null")
        Long payee
) {

}
