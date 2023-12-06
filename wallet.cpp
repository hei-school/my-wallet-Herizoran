//
// Created by Herizo on 06-Dec-23.
//

#include "wallet.h"
#include <iostream>
#include <iomanip>

using namespace std;

class Wallet {
private:
    double balance;

public:
    Wallet() : balance(0.0) {}

    string displayBalance() {
        return "Your balance is: MGA " + to_string(balance);
    }

    string deposit(double amount) {
        balance += amount;
        return "Deposited MGA " + to_string(amount) + " successfully.";
    }

    string withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return "Withdrew MGA " + to_string(amount) + " successfully.";
        } else {
            return "Insufficient funds.";
        }
    }

    string transfer(double amount, Wallet &recipientWallet) {
        if (amount <= balance) {
            balance -= amount;
            recipientWallet.balance += amount;
            return "Transferred MGA " + to_string(amount) + " to the recipient successfully.";
        } else {
            return "Insufficient funds for the transfer.";
        }
    }

    string loan(double loanAmount) {
        if (balance > 0) {
            return "You cannot take a loan. Your balance is positive.";
        } else {
            double tempBalance = balance - loanAmount;
            if (tempBalance > -200000) {
                balance -= loanAmount;
                return "Loan of MGA " + to_string(loanAmount) + " taken successfully.";
            }else {
                return "You can no longer take a loan less than -200000.";
            }
        }
    }

    static string exitApp() {
        return "Exiting wallet app. Have a great day!";
    }
};

int main() {
    Wallet userWallet;

    while (true) {
        cout << "\nWallet App Menu:" << endl;
        cout << "1. Display Balance" << endl;
        cout << "2. Deposit Money" << endl;
        cout << "3. Withdraw Money" << endl;
        cout << "4. Transfer Money" << endl;
        cout << "5. Take a Loan" << endl;
        cout << "6. Exit" << endl;

        cout << "Enter your choice (1-6): ";
        int choice;
        cin >> choice;

        switch (choice) {
            case 1: {
                cout << userWallet.displayBalance() << endl;
                break;
            }
            case 2: {
                double depositAmount;
                cout << "Enter the amount to deposit: ";
                cin >> depositAmount;
                cout << userWallet.deposit(depositAmount) << endl;
                break;
            }
            case 3: {
                double withdrawAmount;
                cout << "Enter the amount to withdraw: ";
                cin >> withdrawAmount;
                cout << userWallet.withdraw(withdrawAmount) << endl;
                break;
            }
            case 4: {
                double transferAmount;
                cout << "Enter the amount to transfer: ";
                cin >> transferAmount;
                Wallet recipientWallet;
                cout << userWallet.transfer(transferAmount, recipientWallet) << endl;
                break;
            }
            case 5: {
                double loanAmount;
                cout << "Enter the loan amount: ";
                cin >> loanAmount;
                cout << userWallet.loan(loanAmount) << endl;
                break;
            }
            case 6: {
                cout << userWallet.exitApp() << endl;
                return 0;
            }
            default: {
                cout << "Invalid choice. Please enter a number between 1 and 6." << endl;
                break;
            }
        }
    }
}
