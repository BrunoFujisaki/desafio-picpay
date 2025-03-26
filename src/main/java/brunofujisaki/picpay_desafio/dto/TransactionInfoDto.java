package brunofujisaki.picpay_desafio.dto;

import brunofujisaki.picpay_desafio.model.user.User;

public record TransactionInfoDto(
        User payer,
        User payee,
        TransactionDto transaction
) {
}
