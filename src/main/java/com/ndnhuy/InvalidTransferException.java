package com.ndnhuy;

public class InvalidTransferException extends RuntimeException {
    public InvalidTransferException(Account sender, Account receiver, long amt) {
        super(String.format("cannot transfer from sender %s to receiver %s the amount %d", sender, receiver, amt));
    }
}
