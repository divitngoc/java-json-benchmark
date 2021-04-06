package com.divitbui.model.yapily;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalance {
    private String type;
    private LocalDateTime dateTime;
    private BalanceAmount balanceAmount;
    private boolean creditLineIncluded;
    private List<CreditLine> creditLines;
}
