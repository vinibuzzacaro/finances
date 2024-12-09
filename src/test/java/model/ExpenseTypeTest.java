package model;

import model.movement.ExpenseType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTypeTest {

    @Test
    void validStringToFood() { assertAll(() -> assertEquals(ExpenseType.FOOD, ExpenseType.fromString("fOoD"))); }

    @Test
    void validStringToWater() { assertAll(() -> assertEquals(ExpenseType.WATER, ExpenseType.fromString("WaTer"))); }

    @Test
    void validStringToElectricity() { assertAll(() -> assertEquals(ExpenseType.ELECTRICITY, ExpenseType.fromString("EleCtrIciTY"))); }

    @Test
    void validStringToDiaper() { assertAll(() -> assertEquals(ExpenseType.DIAPER, ExpenseType.fromString(("DiapER")))); }

    @Test
    void validStringToGasoline() { assertAll(() -> assertEquals(ExpenseType.GASOLINE, ExpenseType.fromString("GasOLINe"))); }

    @Test
    void validStringToGas() { assertAll(() -> assertEquals(ExpenseType.GAS, ExpenseType.fromString(("gaS")))); }

    @Test
    void validStringToRent() { assertAll(() -> assertEquals(ExpenseType.RENT, ExpenseType.fromString("REnt"))); }

    @Test
    void invalidStringShouldThrow() { assertThrows(Exception.class, () -> ExpenseType.fromString("INCORRECT")); }
}