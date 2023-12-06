class Wallet {
    constructor() {
        this.balance = 0.0;
    }

    displayBalance() {
        return `Your balance is: MGA ${this.balance.toFixed(2)}`;
    }

    deposit(amount) {
        this.balance += amount;
        return `Deposited MGA ${amount.toFixed(2)} successfully.`;
    }

    withdraw(amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            return `Withdrew MGA ${amount.toFixed(2)} successfully.`;
        } else {
            return "Insufficient funds.";
        }
    }

    transfer(amount, recipientWallet) {
        if (amount <= this.balance) {
            this.balance -= amount;
            recipientWallet.balance += amount;
            return `Transferred MGA ${amount.toFixed(2)} to the recipient successfully.`;
        } else {
            return "Insufficient funds for the transfer.";
        }
    }

    takeLoan(loanAmount) {
        if (this.balance > 0) {
            return "You cannot take a loan. Your balance is positive.";
        } else {
            let tempBalance = this.balance - loanAmount;
            if (tempBalance > -200000) {
                this.balance -= loanAmount;
                return `Loan of MGA ${loanAmount} taken successfully.`;
            } else {
                return "You can no longer take a loan less than -200000.";
            }
        }
    }

    exitApp() {
        return "Exiting wallet app. Have a great day!";
    }
}

function main() {
    const userWallet = new Wallet();

    while (true) {
        console.log("\nWallet App Menu:");
        console.log("1. Display Balance");
        console.log("2. Deposit Money");
        console.log("3. Withdraw Money");
        console.log("4. Transfer Money");
        console.log("5. Take a loan");
        console.log("6. Exit");

        const choice = prompt("Enter your choice (1-6):");

        switch (choice) {
            case "1":
                console.log(userWallet.displayBalance());
                break;
            case "2":
                const depositAmount = parseFloat(prompt("Enter the amount to deposit: "));
                console.log(userWallet.deposit(depositAmount));
                break;
            case "3":
                const withdrawAmount = parseFloat(prompt("Enter the amount to withdraw: "));
                console.log(userWallet.withdraw(withdrawAmount));
                break;
            case "4":
                const transferAmount = parseFloat(prompt("Enter the amount to transfer: "));
                const recipientWallet = new Wallet();
                console.log(userWallet.transfer(transferAmount, recipientWallet));
                break;
            case "5":
                const loanAmount = parseFloat(prompt("Enter the loan amount: "));
                console.log(userWallet.takeLoan(loanAmount));
                break;
            case "6":
                console.log(userWallet.exitApp());
                return;
            default:
                console.log("Invalid choice. Please enter a number between 1 and 6.");
        }
    }
}

main()