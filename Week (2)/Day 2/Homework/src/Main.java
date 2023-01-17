public class Main {
    public static void main(String[] args) {

        // Employee - Class
        Employee employee1 = new Employee();

        employee1.setId("2131");
        employee1.setName("Ahmed");
        employee1.setSalary(0);
        employee1.raisedSalary(80);

        System.out.println("======================== Employee ========================");
        System.out.println("Employee name: " + employee1.getName());
        System.out.println("Employee ID: " + employee1.getId());
        System.out.println("Employee salary: " + employee1.getSalary());
        System.out.println("Employee's salary after raised: " + employee1.raisedSalary(30));
        System.out.println("Employee annually salary: " + employee1.getAnnualSalary());

        System.out.println("======================== Account 1 ========================");

        // Account //
        Account account1 = new Account();
        account1.setName("Khaled");
        account1.setId("6124");
        account1.setBalance(7000);
        double credit =  account1.credit(100);
        double deposit = account1.debit(450);
        System.out.println("Account name: " + account1.getName());
        System.out.println("Account ID: " + account1.getId());
        System.out.println("Account balance: " + account1.getBalance());
        System.out.println("Account credit: " + credit);
        System.out.println("Account deposit: " + deposit);

        System.out.println("======================== Account 2 ========================");
        Account account2 = new Account();
        account2.setName("Ahmed");
        account2.setId("1043");
        account2.setBalance(12000);
        double credit2 =  account2.credit(50);
        double deposit2 = account2.debit(850);

        System.out.println("Account 2 name: " + account2.getName());
        System.out.println("Account 2 ID: " + account2.getId());
        System.out.println("Account 2 balance: " + account2.getBalance());
        System.out.println("Account 2 credit: " + credit2);
        System.out.println("Account 2 deposit: " + deposit2);

        double amount = 200;
        account2.transferTo(account1, amount);
        System.out.println("Remaining balance of account 2:  " + account2.getBalance());
        System.out.println("Remaining balance of account 1: " + account1.getBalance());
        System.out.println("============================================================");



    }
}