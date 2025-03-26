package brunofujisaki.picpay_desafio.dto;

import brunofujisaki.picpay_desafio.model.user.UserType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public record UserDto(
        @NotBlank(message = "Name cannot be blank.")
        @Schema(example = "Bruno Fujisaki")
        String name,

        @NotBlank(message = "Document cannot be blank.")
        @Pattern(
                //         CPF REGEX                          CNPJ REGEX
                regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$|^\\d{2}\\.\\d{3}\\.\\d{3}\\/000\\d\\-\\d{2}$",
                message = "Invalid format for CPF or CNPJ."
        )
        String document,

        @NotBlank(message = "Email cannot be blank.")
        @Pattern(
                //        EMAIL REGEX
                regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
                message = "Invalid format for email."
        )
        String email,

        @NotNull(message = "Balance cannot be null.")
        BigDecimal balance,

        @NotNull(message = "Type cannot be null.")
        UserType type
) {
}
