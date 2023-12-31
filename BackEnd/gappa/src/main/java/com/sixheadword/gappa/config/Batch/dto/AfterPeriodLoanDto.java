package com.sixheadword.gappa.config.Batch.dto;

import com.sixheadword.gappa.account.Account;
import com.sixheadword.gappa.accountHistory.AccountHistory;
import com.sixheadword.gappa.loan.Loan;
import com.sixheadword.gappa.loanHistory.entity.LoanHistory;
import com.sixheadword.gappa.user.User;
import com.sixheadword.gappa.webAlarm.WebAlarm;
import lombok.*;

@Data
@Getter @Setter
public class AfterPeriodLoanDto {

    private Loan loan;
    private LoanHistory loanHistory;
    private User fromUser;
    private User toUser;
    private Account fromUserAccount;
    private Account toUserAccount;
    private AccountHistory fromUserAccountHistory;
    private AccountHistory toUserAccountHistory;
    private WebAlarm fromUserWebAlarm;
    private WebAlarm toUserWebAlarm;

    public AfterPeriodLoanDto(Loan loan, LoanHistory loanHistory, User fromUser, User toUser, Account fromUserAccount, Account toUserAccount, AccountHistory fromUserAccountHistory, AccountHistory toUserAccountHistory, WebAlarm fromUserWebAlarm, WebAlarm toUserWebAlarm) {
        this.loan = loan;
        this.loanHistory = loanHistory;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.fromUserAccount = fromUserAccount;
        this.toUserAccount = toUserAccount;
        this.fromUserAccountHistory = fromUserAccountHistory;
        this.toUserAccountHistory = toUserAccountHistory;
        this.fromUserWebAlarm = fromUserWebAlarm;
        this.toUserWebAlarm = toUserWebAlarm;
    }
}
