import java.util.Scanner;

class Enetraccount {
    public static void main(String[] args) throws Exception {


        Scanner scr = new Scanner(System.in);
        String[] acnt = {"6711120099", "0099664422", "9966442211", "2224446660", "1111122222"};

        String inpt;
        System.out.println("Enter account name (10 digits)");
        inpt = scr.nextLine();


        for (int i = 0; i < inpt.length(); i++) {
            char result = inpt.charAt(i);
            if (!Character.isDigit(result)) {
                throw new IllegalArgumentException("Please, enter only digits!");

            }
        }

        int x = 0;

        for (int j=0; j < acnt.length; j++) {
            if (inpt.equals(acnt[j])) {
                System.out.print("True!!!");
            } else {
                x = x + 1;
            }
        }

        if (x > acnt.length-1) {
            throw new NotValidAccountException("Not valid!");
        }

    }
}