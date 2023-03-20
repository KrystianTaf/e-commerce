package pl.s221516.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;

    public CreditCard(String cardNumber) {

    }

    public void assignCredit(BigDecimal creditAmount)  {
        if (isCreditAlreadyAssigned()) {
            throw new LimitAssignedTwiceException();
        }

        if (creditAmount.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new CreditBelowLimitException();
        }
        this.balance = creditAmount;
        this.credit = creditAmount;

    }

    private boolean isCreditAlreadyAssigned() {
        return credit !=  null;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        if (balance.compareTo(money) > 0) {
            this.balance = balance.subtract(money);
        }
    }
}
