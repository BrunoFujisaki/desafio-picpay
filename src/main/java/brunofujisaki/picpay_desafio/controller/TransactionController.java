package brunofujisaki.picpay_desafio.controller;

import brunofujisaki.picpay_desafio.dto.TransactionDto;
import brunofujisaki.picpay_desafio.dto.TransactionInfoDto;
import brunofujisaki.picpay_desafio.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transfer")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @Operation(
            summary = "Criar uma nova transação",
            description = "Cria uma transação no sistema."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Transação criada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Payer ou payee não encontrado."),
            @ApiResponse(responseCode = "403", description = "Comerciantes não podem realizar transferências"),
            @ApiResponse(responseCode = "422", description = "Não tem saldo suficiente para realizar a transferência")
    })
    @PostMapping
    public ResponseEntity<TransactionInfoDto> createTransaction(@RequestBody @Valid TransactionDto dto) {
        var transactionInfo = service.createTransaction(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionInfo);
    }
}
