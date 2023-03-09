/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {
    private int accountID;
    private String accountName;
    private String Password;
    private String email;
    private String address;
    private String phone;
    private int role;

    public Account() {
    }

    public Account(int accountID, String accountName, String Password, String email, String address, String phone, int role) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.Password = Password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", accountName=" + accountName + ", Password=" + Password + ", email=" + email + ", address=" + address + ", phone=" + phone + ", role=" + role + '}';
    }

    
}
