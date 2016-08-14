package ex001.account;


import ex001.account.BankAccountCheckImpl;
import ex001.exc.AccountNotFoundException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BanckAccountCheckImplTest {
    public static final String ACCOUNT_WITH_STRING = "123456789n";
    public static final String ACCOUNT_LESS_LENGTH = "123456789";
    public static final String[] FAKE_VALID_ACCOUNTS = new String[]{"1234567890"};

    BankAccountCheckImpl bankAccountCheck;

    @Before
    public void before() {
        bankAccountCheck = new BankAccountCheckImpl(FAKE_VALID_ACCOUNTS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsAccountValidLengthAndString() {
        bankAccountCheck.isAccountValid(ACCOUNT_WITH_STRING);
        bankAccountCheck.isAccountValid(ACCOUNT_LESS_LENGTH);

    }

    @Test(expected = AccountNotFoundException.class)
    public void testIsAccountApplicableInList() {
        bankAccountCheck.isAccountValid("0987654321");
    }

    @Test
    public void testIfPassAllChecks() {
        assertThat(bankAccountCheck.isAccountValid("1234567890"), is(true));
    }
}
