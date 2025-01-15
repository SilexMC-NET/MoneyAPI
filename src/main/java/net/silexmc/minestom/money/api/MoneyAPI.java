package net.silexmc.minestom.money.api;

import java.math.BigDecimal;
import java.util.UUID;

public interface MoneyAPI {
    BigDecimal getMoney(UUID uniqueID);

    String getMoney(UUID uniqueID, boolean format);

    BigDecimal getTotalMoney(UUID uniqueID);

    String getTotalMoney(UUID uniqueID, boolean format);

    void setMoney(UUID uniqueID, BigDecimal amount);

    default void setMoney(UUID uniqueID, double amount) {
        this.setMoney(uniqueID, BigDecimal.valueOf(amount));
    }

    void giveMoney(UUID uniqueID, BigDecimal amount);

    default void giveMoney(UUID uniqueID, double amount) {
        this.setMoney(uniqueID, BigDecimal.valueOf(amount));
    }

    void takeMoney(UUID uniqueID, BigDecimal amount);

    default void takeMoney(UUID uniqueID, double amount) {
        this.setMoney(uniqueID, BigDecimal.valueOf(amount));
    }

    boolean hasMoney(UUID uniqueID, BigDecimal amount);

    default boolean hasMoney(UUID uniqueID, double amount) {
        return this.hasMoney(uniqueID, BigDecimal.valueOf(amount));
    }
}
