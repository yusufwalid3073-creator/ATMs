import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double currentBalance = 2500.75;
        boolean state = true;
        boolean loginState = false;
        String pin = "";
        int countTransaction = 0;
        do {

            while (!loginState) {
                System.out.println("Please,Enter 4-Digit PIN");
                pin = sc.next();
                break;
            }

            if (pin.equals("1234")) {
                loginState = true;
                System.out.println("========= ATM =========\n 1.Check Balance \n 2.Dposit \n 3.Withdraw \n 4.Show Account Status \n 5. Exit\n=======================");
                int input = sc.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Your Current Balance is : " + currentBalance + " EGP");
                        break;
                    case 2:
                        System.out.println("Please Enter The Deposit Amount it must be greater than 0");
                        double depositAmount = sc.nextDouble();
                        if (depositAmount > 0) {
                            currentBalance += depositAmount;
                            System.out.println("done!! \n we added " + depositAmount + " EGP to your balance is " + currentBalance);
                            countTransaction++;
                            System.out.println("you make " + countTransaction + " Successful Transactoins");
                        } else {
                            System.out.println("Invalid Amount");
                        }
                        break;
                    case 3:
                        System.out.println("Please Enter The Deposit Amount it must be greater than 0 and Doesn't Exceed the Current Balance");
                        double withdrawAmount = sc.nextDouble();
                        if (withdrawAmount > 0 && withdrawAmount <= currentBalance) {
                            currentBalance -= withdrawAmount;
                            System.out.println("done!! \nWe withdrew " + withdrawAmount + " EGP to your balance is " + currentBalance);
                            if (currentBalance == 0) {
                                System.out.println("Warning: Your account is Empty");

                            }
                            countTransaction++;
                            System.out.println("you make " + countTransaction + " Successful Transactoins");

                        } else if (withdrawAmount > currentBalance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            System.out.println("Transaction cancelled");
                        }
                        break;
                    case 4:
                        if (currentBalance >= 5000) {
                            System.out.println("Your Account Status Is VIP Customer.");
                        } else if (currentBalance >= 1000 && currentBalance <= 4999.99) {
                            System.out.println("Your Account Status Is Regular Customer.");
                        } else System.out.println("Your Account Status Is Low Customer.");
                        break;
                    case 5:
                        state = false;
                        System.out.println("Thank you for using our ATM");
                        break;
                    default:
                        System.out.println("Invalid Option");
                }


            } else System.out.println("Please, Enter The Correct 4-Digit PIN");


        } while (state);
    }
}