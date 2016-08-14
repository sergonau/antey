package ex001;

import ex001.account.BankAccountCheckImpl;
import ex001.account.BankApplication;

public class Process {

    public static void main(String[] args) {
        String[] accounts = {"6711120099", "0099664422", "9966442211", "2224446660", "1111122222"};
        BankApplication gogogo = new BankApplication(new BankAccountCheckImpl(accounts), new ConsoleIO());
        gogogo.runBankApp();
    }
}
