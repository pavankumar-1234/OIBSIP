package oasis_infobyte;
import java.util.Scanner;
class Account {
    protected String username,userpassword;
    Scanner sc = new Scanner(System.in);
    //createAccount method for account creation

    void createAccount() {
        System.out.println("Enter username:");
        username = sc.nextLine();
        System.out.println("Enter Password:");
        userpassword = sc.nextLine();
        System.out.println(" Congratulations ! "+username+" Account created sucessfully");
        System.out.println("");
    }
}

class LoginAccount extends Account {
    private String id;
    private String p;

    void login() {
        do {
            System.out.println("Enter username:");
            id = sc.nextLine();
            if (username.equals(id)) {
                do {
                    System.out.println("Enter Password:");
                    p = sc.nextLine();
                    if (p.equals(userpassword)) {
                        System.out.println("Login successful !");
                    } else {
                        System.out.println("Wrong Password ! Please Enter correct password");
                    }

                } while (p.equals(userpassword) == false);
            } else {
                System.out.println("Wrong Password ! Please Enter correct password");
            }
        } while (username.equals(id) == false);

    }
}

class Deposit {
    int amount;
    int balance = 500;
    int prevtransaction = 0;
    String Transactionhistory = "";
    Scanner sc = new Scanner(System.in);

    void Display() {
        System.out.println("Enter amount deposit:");
        amount = sc.nextInt();
        if (amount != 0) {
            prevtransaction++;
            balance = balance + amount;
            prevtransaction = amount;
            String str = amount + " rupees deposited\n";
            Transactionhistory = Transactionhistory.concat(str);
            System.out.println(amount+" rupees is Successfully Deposited !");
        }
    }
}

class Withdraw extends Deposit {

    void cash() {
        System.out.println("Enter amount to withdraw:");
        amount = sc.nextInt();
        if (balance > amount) {
            if (amount <= 10000) {
                prevtransaction++;
                balance = balance - amount;
                prevtransaction = prevtransaction - amount;
                System.out.println(amount+" rupess is withdraw successfully !");
                String str = amount + "rs withdrawed\n";
                Transactionhistory = Transactionhistory.concat(str);
            } else {
                System.out.println("Sorry !.........limit is 10000");
            }
        } else {
            System.out.println("Insufficient amount to withdraw !");
        }
    }
}

class Transfer extends Withdraw {
    void transfer() {
        int r_accbalance = 0;
        System.out.println("Enter amount to transfer: ");
        amount = sc.nextInt();
        if (balance < amount) {
            System.out.println(" Oops ! You have not sufficient balance to transfer amount");
        } else {
            System.out.println("Enter the account no of receiver:");
            int acc = sc.nextInt();

            this.balance = this.balance - amount;
            r_accbalance += amount;
            System.out.println("The ammount "+r_accbalance+" is successfully transfered to "+acc);
            System.out.println("Available balance is " + this.balance);
            String str = amount + " Rs transfered";
            Transactionhistory = Transactionhistory.concat(str);
        }

    }
}

class CheckBalance extends Transfer {
    void check() {
        System.out.println("Currently available balance is :" + balance + " Rs");
    }

}

class TransactionHistory extends CheckBalance {
    void history() {
        if (prevtransaction == 0) {
            System.out.println("\nEmpty");
        } else {
        	System.out.println("--------Your transaction history-------");

            System.out.println("\n" + Transactionhistory);
        }
    }
}

class Atm_Interface {
    public static void main(String[] args) {
        System.out.println("                             WELCOME TO CANARA BANK");
        System.out.println("");
        LoginAccount l = new LoginAccount();
        l.createAccount();
        System.out.println("                             WELCOME BACK TO CANARA BANK");
        System.out.println("                             __________________________");
        System.out.println("Please login");
        System.out.println("");
        l.login();

        int ch;
        Scanner sc = new Scanner(System.in);
        TransactionHistory t = new TransactionHistory();
        while (true) {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.println("");
            System.out.println("Enter your Choice:");
            System.out.println("");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    t.check();
                    break;

                case 2:

                    t.Display();
                    break;

                case 3:

                    t.cash();
                    break;

                case 4:

                    t.history();
                    break;

                case 5:

                    t.transfer();
                    break;

                case 6:
                    System.out.println("Thank you ! for using our service");
                    System.exit(ch);
                    break;

                default:
                    System.out.println("Enter valid choice!");
            }

        }

    }

}