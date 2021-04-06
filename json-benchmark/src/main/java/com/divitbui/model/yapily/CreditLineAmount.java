package com.divitbui.model.yapily;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditLineAmount {
    private int amount;
    private String currency;
}
