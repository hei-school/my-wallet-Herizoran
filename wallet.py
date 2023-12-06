class Wallet:
    def __init__(self):
        self.balance = 0.0

    def display_balance(self):
        return f"Your balance is: MGA {self.balance:.2f}"

    def deposit(self, amount):
        self.balance += amount
        return f"Deposited MGA {amount:.2f} successfully."

    def withdraw(self, amount):
        if amount <= self.balance:
            self.balance -= amount
            return f"Withdrew MGA {amount:.2f} successfully."
        else:
            return "Insufficient funds."

    def transfer(self, amount, recipient_wallet):
        if amount <= self.balance:
            self.balance -= amount
            recipient_wallet.balance += amount
            return f"Transferred MGA {amount:.2f} to the recipient successfully."
        else:
            return "Insufficient funds for the transfer."

    def take_loan(self, loan_amount):
        if self.balance > 0:
            return "You cannot take a loan. Your balance is positive."
        else:
            temp_balance = self.balance - loan_amount
            if temp_balance > -200000:
                self.balance -= loan_amount
                return f"Loan of MGA {loan_amount} taken successfully."
            else:
                return "You can no longer take a loan less than -200000."

    def exit_app(self):
        return "Exiting wallet app. Have a great day!"


def main():
    user_wallet = Wallet()

    while True:
        print("\nWallet App Menu:")
        print("1. Display Balance")
        print("2. Deposit Money")
        print("3. Withdraw Money")
        print("4. Transfer Money")
        print("5. Take a loan")
        print("6. Exit")

        choice = input("Enter your choice (1-6): ")

        if choice == "1":
            print(user_wallet.display_balance())
        elif choice == "2":
            amount = float(input("Enter the amount to deposit: "))
            print(user_wallet.deposit(amount))
        elif choice == "3":
            amount = float(input("Enter the amount to withdraw: "))
            print(user_wallet.withdraw(amount))
        elif choice == "4":
            amount = float(input("Enter the amount to transfer: "))
            recipient_wallet = Wallet()
            print(user_wallet.transfer(amount, recipient_wallet))
        elif choice == "5":
            amount = float(input("Enter the loan amount: "))
            print(user_wallet.take_loan(amount))
        elif choice == "6":
            print(user_wallet.exit_app())
            break
        else:
            print("Invalid choice. Please enter a number between 1 and 6.")


if __name__ == "__main__":
    main()
