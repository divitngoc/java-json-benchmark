package com.divitbui.model.yapily;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    
    private String id;
    private String type;
    private String description;
    private int balance;
    private String currency;
    private String usageType;
    private String accountType;
    private String nickname;
    private String details;
    private List<AccountName> accountNames;
    private List<AccountIdentification> accountIdentifications;
    private List<AccountBalance> accountBalances;
    
}
