package org.bank.service;

import org.bank.dao.BankDao;
import org.bank.dao.BankDaoImpl;
import org.bank.dto.BankAccount;

import java.util.List;

public class BankServiceImpl implements BankService{
    private static BankDao bankDao = new BankDaoImpl();
    @Override
    public boolean createBankAccount(BankAccount bankAccount) {
       return bankDao.createBankAccount(bankAccount);
//        return false;
    }

    @Override
    public List<BankAccount> getAllBankAccount() {
        return bankDao.getAllBankAccount();
    }

    @Override
    public boolean updateBankAccount(BankAccount bankAccount) {

        return bankDao.updateBankAccount(bankAccount);
    }

    @Override
    public boolean deleteBankAccount(int accountNumber) {
        return bankDao.deleteBankAccount(accountNumber);
    }

    @Override
    public BankAccount getBankAccountByACNumber(int accountNumber) {
       return bankDao.getBankAccountByACNumber(accountNumber);
//        return null;
    }

    @Override
    public List<BankAccount> getBankAccountByACName(String customerName) {
        return bankDao.getBankAccountByACName(customerName);
    }

    @Override
    public List<BankAccount> getBankAccountByACBranch(int branchCode) {
        return bankDao.getBankAccountByACBranch(branchCode);
    }

    @Override
    public List<Object[]> getAcNumberNameCity() {
        return bankDao.getAcNumberNameCity();
    }
}
