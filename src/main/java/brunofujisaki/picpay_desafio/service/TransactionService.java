package brunofujisaki.picpay_desafio.service;

import brunofujisaki.picpay_desafio.client.AuthorizationClient;
import brunofujisaki.picpay_desafio.client.NotificationClient;
import brunofujisaki.picpay_desafio.dto.TransactionDto;
import brunofujisaki.picpay_desafio.dto.TransactionInfoDto;
import brunofujisaki.picpay_desafio.infra.exception.BalanceException;
import brunofujisaki.picpay_desafio.infra.exception.MerchantException;
import brunofujisaki.picpay_desafio.infra.exception.UserNotFoundException;
import brunofujisaki.picpay_desafio.model.transaction.Transaction;
import brunofujisaki.picpay_desafio.model.user.User;
import brunofujisaki.picpay_desafio.model.user.UserType;
import brunofujisaki.picpay_desafio.repository.TransactionRepository;
import brunofujisaki.picpay_desafio.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;
    private final AuthorizationService authorizationService;
    private final NotificationService notificationService;

    public TransactionService(UserRepository userRepository, TransactionRepository transactionRepository, AuthorizationClient authorizationClient, NotificationClient notificationClient, AuthorizationService authorizationService, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
    }

    @Transactional
    public TransactionInfoDto createTransaction(TransactionDto dto) {
        var payer = userRepository.findById(dto.payer()).orElseThrow(() -> new UserNotFoundException("Payer not found."));
        var payee = userRepository.findById(dto.payee()).orElseThrow(() -> new UserNotFoundException("Payee not found."));

        if (payer.getType().equals(UserType.MERCHANT)) {
            throw new MerchantException("Merchants cannot send tranfers");
        }

        if (payer.getBalance().compareTo(dto.value()) < 0) {
            throw new BalanceException("Insufficient balance to complete the transfer.");
        }

        authorizationService.verifyAuthorization();


        payer.updateBalance(dto.value(), false);
        payee.updateBalance(dto.value(), true);

        notificationService.sendNotification();

        var transaction = new Transaction(dto.value(), payer, payee);
        transactionRepository.save(transaction);
        return new TransactionInfoDto(payer, payee, dto);
    }
}
