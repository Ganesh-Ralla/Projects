package Payment_application;

import java.util.Scanner;

public class Paytm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Paytm");
        while (true) {
            System.out.println("1.Scan QR\n2.Mobile number\n3.Contacts\n4.Check balance\n5.Exit");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Camera not found");
                    break;
                case 2:
                    Payment.mobilenumber();
                    break;
                case 3:
                    Payment.contact();
                    break;
                case 4:
                    Payment.show();
                    break;
                case 5:
                    Payment.exit();break;
                default:
                    System.out.println("No operation with the selected key");
            }

        }
    }


}
