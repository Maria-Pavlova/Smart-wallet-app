package app.transaction.service;

import app.transaction.model.Transaction;
import app.transaction.model.TransactionStatus;
import app.transaction.model.TransactionType;
import app.transaction.repository.TransactionRepository;
import app.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Slf4j
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createNewTransaction(User owner, String sender, String receiver, BigDecimal amount, BigDecimal balance, Currency currency,
                                            TransactionType type, TransactionStatus status, String description, String failureReason) {

        Transaction transaction = Transaction.builder()
                .owner(owner)
                .sender(sender)
                .receiver(receiver)
                .amount(amount)
                .balanceLeft(balance)
                .currency(currency)
                .type(type)
                .status(status)
                .description(description)
                .failureReason(failureReason)
                .createdOn(LocalDateTime.now())
                .build();

        return transactionRepository.save(transaction);
    }



}