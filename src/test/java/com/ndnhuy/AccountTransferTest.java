package com.ndnhuy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTransferTest {

    @Test
    void testTransfer_shouldTransferCorrectly() {
        var accountTransfer = new AccountTransfer();
        var acc1 = new Account("alice", 100);
        var acc2 = new Account("bob", 0);
        accountTransfer.transfer(acc1, acc2, 100);
        shouldHaveBalance(acc1, 0);
        shouldHaveBalance(acc2, 100);

        accountTransfer.transfer(acc2, acc1, 40);
        shouldHaveBalance(acc1, 40);
        shouldHaveBalance(acc2, 60);

        accountTransfer.transfer(acc2, acc1, 60);
        shouldHaveBalance(acc1, 100);
        shouldHaveBalance(acc2, 0);

        assertThrows(InvalidTransferException.class, () -> accountTransfer.transfer(acc1, acc2, 200));
    }

    @Test
    void testTransferConcurrently() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        try {
            var acc1 = new Account("acc1", 100);
            var acc2 = new Account("acc2", 0);
            var tasks = new ArrayList<Callable<Void>>();
        } finally {
            executor.close();
        }
    }

    void shouldHaveBalance(Account acc, long wantBalance) {
        assertEquals(wantBalance, acc.getBalance());
    }
}