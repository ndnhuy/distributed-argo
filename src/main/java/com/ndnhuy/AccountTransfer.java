package com.ndnhuy;

public class AccountTransfer {
    public void transfer(Account sender, Account receiver, long amt) {
        if (!sender.canTransfer(amt)) {
            throw new InvalidTransferException(sender, receiver, amt);
        }
        sender.decrease(amt);
        receiver.increase(amt);
    }
}
