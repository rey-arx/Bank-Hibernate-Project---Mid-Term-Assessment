package org.bank.service;

import org.bank.dto.BankAccount;

import java.util.List;

public interface BankService {
    public boolean createBankAccount(BankAccount bankAccount);
    public List<BankAccount> getAllBankAccount();
    public boolean updateBankAccount(BankAccount bankAccount);
    public boolean deleteBankAccount(int accountNumber);
    public BankAccount getBankAccountByACNumber(int accountNumber);
    public List<BankAccount> getBankAccountByACName(String customerName);
    public List<BankAccount> getBankAccountByACBranch(int branchCode);
    public List<Object[]> getAcNumberNameCity();
}
