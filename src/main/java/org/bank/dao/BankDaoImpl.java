package org.bank.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.bank.dto.BankAccount;
import org.bank.util.BankUtil;

import java.util.List;

public class BankDaoImpl implements BankDao{

    private static EntityManager em =  BankUtil.createEntityManager();
    private static EntityTransaction et= em.getTransaction();
    public static Query q;
    @Override
    public boolean createBankAccount(BankAccount bankAccount) {

        et.begin();
        em.persist(bankAccount);
        et.commit();
        if(em.find(BankAccount.class, bankAccount.getActNumber())!=null) {
            em.close();
            return true;
        }
        else {
        em.close();
        return false;
        }

    }

    @Override
    public List<BankAccount> getAllBankAccount() {
        et.begin();
        q = em.createQuery("SELECT b FROM BankAccount AS b");
        List<BankAccount> bankAccountList = q.getResultList();
        return bankAccountList;
    }

    @Override
    public boolean updateBankAccount(BankAccount bankAccount) {
    BankAccount bankAccount1 =  em.find(BankAccount.class, bankAccount.getActNumber());
    em.merge(bankAccount);
    et.commit();
        return true;
    }

    @Override
    public boolean deleteBankAccount(int accountNumber) {
        et.begin();
        BankAccount bankAccount = em.find(BankAccount.class,accountNumber);
        em.remove(bankAccount);
        et.commit();
        if(em.find(BankAccount.class, bankAccount.getActNumber())!=null) {
            em.close();
            return false;
        }
        else {
            em.close();
            return true;
        }

    }

    @Override
    public BankAccount getBankAccountByACNumber(int accountNumber) {
    et.begin();
    BankAccount bankAccount = em.find(BankAccount.class,accountNumber);
    return bankAccount;
        //        return null;
    }

    @Override
    public List<BankAccount> getBankAccountByACName(String customerName) {
       et.begin();
       q = em.createQuery("SELECT e from BankAccount AS e WHERE e.customerName = :name");
       q.setParameter("name",customerName);
       List<BankAccount> bankAccountList = q.getResultList();
        return bankAccountList;
    }

    @Override
    public List<BankAccount> getBankAccountByACBranch(int branchCode) {
        et.begin();
        q = em.createQuery("SELECT e from BankAccount AS e WHERE e.branchCode = :branchcode");
//        q.setParameter("branchCode",branchCode);
        q.setParameter("branchcode",branchCode);
        List<BankAccount> bankAccountList = q.getResultList();
        return bankAccountList;
//        return List.of();
    }

    @Override
    public List<Object[]> getAcNumberNameCity() {
        et.begin();
//        q = em.createQuery("SELECT e.actNumber ,e.customerName, e.city from BankAccount AS e ");
        q = em.createQuery("SELECT e.customerName, e.city from BankAccount AS e group by e.customerName,e.city ");
        List<Object[]> list = q.getResultList();
        return list;
    }
}
