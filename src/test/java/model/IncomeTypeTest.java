package model;

import model.movement.IncomeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTypeTest {

    @Test
    void validStringToRent() {
        assertAll(() -> assertEquals(IncomeType.RENT, IncomeType.fromString("rEnT")));
    }

    @Test
    void validStringToSalary() {
        assertAll(() -> assertEquals(IncomeType.SALARY, IncomeType.fromString("sAlAry")));
    }

    @Test
    void validStringToVoucher() {
        assertAll(() -> assertEquals(IncomeType.VOUCHER, IncomeType.fromString("vOUCheR")));
    }

    @Test
    void rentToValidString() { assertEquals("Rent", IncomeType.RENT.toString()); }

    @Test
    void salaryToValidString() {
        assertEquals("Salary", IncomeType.SALARY.toString());
    }

    @Test
    void voucherToValidString() {
        assertEquals("Voucher", IncomeType.VOUCHER.toString());
    }

    @Test
    void invalidStringShouldThrow() {
        assertThrows(Exception.class, () -> IncomeType.fromString("INCORRECT"));
    }
}