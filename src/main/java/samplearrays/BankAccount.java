package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    Double[] transactions = new Double[1000];


    // Counter to keep track of the current number of transactions (and next index)
    int transactionCount = 0;
    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance ;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid deposit , amount should be positive");
            return;
        }
        currentBalance += amount ;
        transactions[transactionCount] = amount;
        transactionCount++;
        System.out.println("Depositor Name : "+ name +" , deposit amount : "+ amount + ", current balance : " + currentBalance);
    }

    public void withdraw(double amount){
        if( amount <= 0 || amount > currentBalance){
            System.out.println("Withdraw unsuccessful");
            return;
        }
        currentBalance -= amount ;
        transactions[transactionCount] = -amount;
        transactionCount++;

    }

    public void displayTransactions(){
        System.out.println("Transaction History");
        for(int i = 0 ; i < transactionCount ; i++){
            System.out.println(transactions[i]);
        }
    }

    public void displayBalance(){
            System.out.println("Current balance : "+ currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
