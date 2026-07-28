package dev.sid.VeritasBackend.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sid.VeritasBackend.Entities.PayrollTransactions;

public interface PayrollTransactionsRepository extends JpaRepository<PayrollTransactions, UUID> {
}
