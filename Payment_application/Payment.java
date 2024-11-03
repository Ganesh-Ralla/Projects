package Payment_application;

import java.util.Scanner;

class Payment {

    static Scanner sc= new Scanner(System.in);
    static int i;
    static int amnt;
    static int act_blc=2500;
    static int rblc;

    public static void mobilenumber() {

        System.out.print("Enter mobile number :");
        long nmbr=sc.nextLong();
        boolean b = false;

        String num = Long.toString(nmbr);
        char pnum[] = new char[num.length()];

        pnum = num.toCharArray();
        //verifying the number
        if(num.length() == 10) {
            if(num.charAt(0)=='6'||num.charAt(0)=='7'||num.charAt(0)=='8'||num.charAt(0)=='9') {
                //System.out.println("Valid number");
                System.out.print("Enter the amount :");
                amnt=sc.nextInt();
                b=true;
            }
            else {
                System.out.println("Invalid number");
            }

            //if the number is valid
            if(b==true) {
                System.out.print("Enter your pin :");
                int pin=sc.nextInt();
                if(pin==4227 && (amnt>act_blc || act_blc==0)) {
                    System.out.println("Insufficient funds");
                }
                if(pin==4227) {
                    for(i=0;i<num.length()-4;i++) {
                        pnum[i]='X';
                    }
                    System.out.print(amnt +" sending to +91");
                    System.out.println(pnum);
                    for(i=3;i>0;i--) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                        System.out.println(i);
                    }

                    System.out.println("Payment successful");
                    System.out.println("Want to check balance (y-1/n-0)");
                    int opinion=sc.nextInt();
                    if(opinion == 1) {
                        rblc=act_blc-amnt;
                        System.out.print("Enter your pin :");
                        pin=sc.nextInt();
                        if(pin==4227) {

                            System.out.println("Remaining balance is "+rblc);
                        }

                    }
                    else {
                        System.out.println("thank you");
                    }

                }
                else {
                    System.out.println("Incorrect pin");
                }

            }
        }

    }
    public static void contact() {

        String name[]= {"Giri","Sunny","Abhi","Shiva"};
        System.out.println("Select your contact");
        for(i=0;i<name.length;i++) {
            System.out.println(name[i]);
        }
        String select=sc.next();
        for(i=0;i<name.length;i++) {
            if(select.equals(name[i])) {
                System.out.println("Enter the amount");
                amnt=sc.nextInt();
                System.out.println("Enter your pin");
                int pin=sc.nextInt();
                if(pin==4227) {
                    System.out.println(amnt+" sending to "+select);
                    for(i=3;i>0;i--) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println(i);
                    }

                    System.out.println("Payment successful");
                    System.out.println("Want to check balance (y-1/n-0)");
                    int opinion=sc.nextInt();
                    if(opinion == 1) {
                        rblc=act_blc-amnt;
                        System.out.println("Enter your pin");
                        pin=sc.nextInt();
                        if (pin==4227) {
                            System.out.println("Remaining balance is "+rblc);
                        }

                    }break;

                }

            }
        }

    }
    public static void show() {
        System.out.println("Enter your pin");
        int pin=sc.nextInt();
        if(pin==4227) {
            System.out.println("Checking your balance");
            for(i=3;i>0;i--) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(i);
            }
            System.out.println("Your balance is "+act_blc);

        }
    }
    public static void exit(){
        System.out.print("Exiting");
        for (i = 5; i > 0; i--) {
            System.out.print(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.exit(0);
    }
}