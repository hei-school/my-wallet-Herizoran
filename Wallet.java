import java.util.Scanner;

public class Wallet {
  private double balance;

  public Wallet() {
    this.balance = 0.0;
  }

  public String displayBalance() {
    return "Your balance is:  MGA " + String.format("%.2f", balance);
  }

  public String deposit(double amount) {
    balance += amount;
    return "Deposited MGA " + String.format("%.2f", amount) + " successfully.";
  }

  public String withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      return "Withdrew MGA " + String.format("%.2f", amount) + " successfully.";
    } else {
      return "Insufficient funds.";
    }
  }

  public String transfer(double amount, Wallet recipientWallet) {
    if (amount <= balance) {
      balance -= amount;
      recipientWallet.balance += amount;
      return "Transferred MGA " + String.format("%.2f", amount) + " to the recipient successfully.";
    } else {
      return "Insufficient funds for the transfer.";
    }
  }
  public String loan(double loanAmount) {
    if (balance > 0) {
      return "You cannot take a loan. Your balance is positive.";
    } else {
      double tempBalance = balance - loanAmount;
      if (tempBalance > -200000) {
        balance -= loanAmount;
        return "Loan of MGA " + (loanAmount) + " taken successfully.";
      }else {
        return "You can no longer take a loan less than -200000.";
      }
    }
  }

  public String exitApp() {
    return "Exiting wallet app. Have a great day!";
  }

  public static void main(String[] args) {
    Wallet userWallet = new Wallet();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nWallet App Menu:");
      System.out.println("1. Display Balance");
      System.out.println("2. Deposit Money");
      System.out.println("3. Withdraw Money");
      System.out.println("4. Transfer Money");
      System.out.println("5. Take a loan");
      System.out.println("6. Exit");

      System.out.print("Enter your choice (1-6): ");
      String choice = scanner.nextLine();

      switch (choice) {
        case "1":
          System.out.println(userWallet.displayBalance());
          break;
        case "2":
          System.out.print("Enter the amount to deposit: ");
          double depositAmount = Double.parseDouble(scanner.nextLine());
          System.out.println(userWallet.deposit(depositAmount));
          break;
        case "3":
          System.out.print("Enter the amount to withdraw: ");
          double withdrawAmount = Double.parseDouble(scanner.nextLine());
          System.out.println(userWallet.withdraw(withdrawAmount));
          break;
        case "4":
          System.out.print("Enter the amount to transfer: ");
          double transferAmount = Double.parseDouble(scanner.nextLine());
          Wallet recipientWallet = new Wallet();
          System.out.println(userWallet.transfer(transferAmount, recipientWallet));
          break;
        case "5":
          System.out.print("Enter the loan amount: ");
          double loanAmount = Double.parseDouble(scanner.nextLine());
          System.out.println(userWallet.loan(loanAmount));
          break;
        case "6":
          System.out.println(userWallet.exitApp());
          scanner.close();
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please enter a number between 1 and 6.");
      }
    }
  }
}
