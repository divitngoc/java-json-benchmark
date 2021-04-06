package com.divitbui.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;

import com.divitbui.model.yapily.Account;

public final class AccountUtils {

    private final static EasyRandom r = new EasyRandom();

    private AccountUtils() {}

    public static List<Account> generateYapilyAccounts() {
        return generateYapilyAccounts(1000);
    }

    public static List<Account> generateYapilyAccounts(int listSize) {
        return r.objects(Account.class, listSize)
                .collect(Collectors.toList());
    }
}
