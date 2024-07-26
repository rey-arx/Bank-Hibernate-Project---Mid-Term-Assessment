package org.bank.io;

import org.bank.dto.BankAccount;
import org.bank.service.BankService;
import org.bank.service.BankServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BankMain {
    private static BankService bankService = new BankServiceImpl();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose one of the options: ");
        System.out.println("1. Create Bank Account");
        System.out.println("2. Display All Bank Accounts");
        System.out.println("3. Update Bank Account");
        System.out.println("4. Delete Bank Account");
        System.out.println("5. Display Bank Account By Account Number");
        System.out.println("6. Display Bank Account By Name");
        System.out.println("7. Display Bank Account By Branch");
        System.out.println("8. Display Account Number, Account Name, City");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                BankAccount bankAccount1 = new BankAccount();
                System.out.println("--------------CREATING BANK ACCOUNT:-------------- ");
                System.out.println("Enter Bank Customer Name: ");
                String bankAccountName = scanner.next();
                bankAccount1.setCustomerName(bankAccountName);

                System.out.println("Enter Bank Account Number");
                bankAccount1.setActNumber(scanner.nextInt());

                System.out.println("Enter Bank Account City");
                bankAccount1.setCity(scanner.next());

                System.out.println("Enter Bank Balance");
                bankAccount1.setActBalance(scanner.nextDouble());

                System.out.println("Enter Branch Code");
                bankAccount1.setBranchCode(scanner.nextInt());


//                BankAccount bankAccount = new BankAccount(5,"Ajeeth",25000,"CBE",701);
                boolean status = bankService.createBankAccount(bankAccount1);
                if(status) System.out.println("Account Created");
                else System.out.println("Account creation failed");
                break;
            }
            case 2:{
                System.out.println("--------------DISPLAYING BANK ACCOUNTS:-------------- ");
                List<BankAccount> bankAccountList = bankService.getAllBankAccount();
                System.out.println(String.format("%-20s %-20s %-18s %-20s %-10s", "accountNumber", "customerName", "accountBalance", "city", "branchCode"));

                for (BankAccount bankAccount : bankAccountList) System.out.println(bankAccount.toString());
                break;
            }
            case 3:{
                System.out.println("--------------UPDATING BANK ACCOUNTS:-------------- ");
                System.out.println("Enter Customer ID: ");
                int id = scanner.nextInt();
                BankAccount bankAccount = bankService.getBankAccountByACNumber(id);
                System.out.println("Select The Fields You Want To Update:");
                System.out.println("1. Customer Name");
                System.out.println("2. Branch Code");
                System.out.println("3. City");
                int c = scanner.nextInt();
                switch (c){
                    case 1:{
                        System.out.println("Enter New Customer Name");
                        String name= scanner.next();
                        bankAccount.setCustomerName(name);
                        break;
                    }
                    case 2:{
                        System.out.println("Enter New Branch Code");
                        int code = scanner.nextInt();
                        bankAccount.setBranchCode(code);
                        break;
                    }
                    case 3:{
                        System.out.println("Enter New City:");
                        String city = scanner.next();
                        bankAccount.setCity(city);
                        break;
                    }
                }
                boolean status = bankService.updateBankAccount(bankAccount);
                if(status) System.out.println("Updated Succesfully");
                else System.out.println("Update failed");
                break;
            }
            case 4:{
                System.out.println("--------------DELETING BANK ACCOUNTS:-------------- ");
                System.out.println("Enter The Account Number: ");
                int actNo = scanner.nextInt();
                boolean status = bankService.deleteBankAccount(actNo);
                if (status) System.out.println("Account Successfully Deleted");
                else System.out.println("Account Deletion Failed");
break;
            }
            case 5:{
                System.out.println("--------------DISPLAYING BANK ACCOUNT:-------------- ");
                System.out.println("Enter The Account Number: ");
                int actNo = scanner.nextInt();
                BankAccount bankAccount = bankService.getBankAccountByACNumber(actNo);
                System.out.println();
                System.out.println();
                System.out.println(bankAccount.toString());
                break;
            }
            case 6:{
                System.out.println("--------------DISPLAYING BANK ACCOUNTS:-------------- ");
                System.out.println("Enter Customer Name:");
                String customerName = scanner.next();
                List<BankAccount> bankAccountList = bankService.getBankAccountByACName(customerName);
                System.out.println(String.format("%-20s %-20s %-18s %-20s %-10s", "accountNumber", "customerName", "accountBalance", "city", "branchCode"));
                for (BankAccount bankAccount : bankAccountList) System.out.println(bankAccount.toString());
                break;
            }
            case 7:{
                System.out.println("--------------DISPLAYING BANK ACCOUNTS:-------------- ");
                System.out.println("Enter Branch Code:");
                int branchCode = scanner.nextInt();
                List<BankAccount> bankAccountList = bankService.getBankAccountByACBranch(branchCode);
                System.out.println(String.format("%-20s %-20s %-18s %-20s %-10s", "accountNumber", "customerName", "accountBalance", "city", "branchCode"));
                for (BankAccount bankAccount : bankAccountList) System.out.println(bankAccount.toString());
                break;
            }
            case 8:{
                System.out.println("--------------DISPLAYING BANK ACCOUNTS:-------------- ");
                //branch and account number
                List<Object[]> list = bankService.getAcNumberNameCity();
                for (Object[] ob : list ){
                    System.out.print( ob[0]);
                    System.out.println(ob[1]);
//                    System.out.println(ob[2]);

                }

            }
        }
    }
}
