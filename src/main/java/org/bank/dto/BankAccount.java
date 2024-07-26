package org.bank.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode

public class BankAccount {
    @Id
    private int actNumber;
    private String customerName;
    private double actBalance;
    private String city;
    private int branchCode;

    public BankAccount() {
    }

    public BankAccount(int actNumber, String customerName, double actBalance, String city, int branchCode) {
        this.actNumber = actNumber;
        this.customerName = customerName;
        this.actBalance = actBalance;
        this.city = city;
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return String.format("%-20d %-20s %-17.2f %-20s %-10d", actNumber, customerName, actBalance, city, branchCode);

//        return "BankAccount{" +
//                "actNumber=" + actNumber +
//                ", customerName='" + customerName + '\'' +
//                ", actBalance=" + actBalance +
//                ", city='" + city + '\'' +
//                ", branchCode=" + branchCode +
//                '}';
//        return "%-5s %-15s %-5s %-20s %-20s \n", actNumber, customerName, actBalance, city,  branchCode;
    }
}
