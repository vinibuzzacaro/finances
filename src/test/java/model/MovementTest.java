package model;

import model.movement.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class MovementTest {
    private final List<Movement> originalList = new ArrayList<>(
        Arrays.asList(
            new Income(IncomeType.SALARY, 3100f),
            new Income(IncomeType.RENT, 600f),
            new Expense(ExpenseType.RENT, 1200f),
            new Expense(ExpenseType.FOOD, 1500f)
        )
    );

    @Test
    void repeatedIncomeMergesWithAnExistingOne() {
        final Movement incomeToMerge = new Income(IncomeType.RENT, 100f);
        List<Movement> newList = (List<Movement>) incomeToMerge.mergeWith(originalList);
        float newValue = newList.stream()
            .filter(movement -> (movement.getClass() == Income.class) && (movement.getType() == IncomeType.RENT))
            .map(Movement::getValue)
            .findFirst()
            .orElse(0f);
        assertAll(
            () -> assertEquals(700f, newValue),
            () -> assertEquals(originalList.size(), newList.size()),
            () -> assertNotEquals(0, newValue)
        );
    }

    @Test
    void differentIncomeIsAppended() {
        final Movement expenseToMerge = new Expense(ExpenseType.GASOLINE, 300f);
        List<Movement> newList = (List<Movement>) expenseToMerge.mergeWith(originalList);
        boolean everyValueRemainsTheSame = newList.stream()
            .filter(movement -> movement.getType() != ExpenseType.GASOLINE)
            .toList()
            .equals(originalList);
        assertAll(
            () -> assertTrue(everyValueRemainsTheSame),
            () -> assertNotEquals(originalList.size(), newList.size())
        );
    }

    @Test
    void repeatedExpenseMergesWithAnExistingOne() {
        final Movement expenseToMerge = new Expense(ExpenseType.FOOD, 100f);
        List<Movement> newList = (List<Movement>) expenseToMerge.mergeWith(originalList);
        float newValue = newList.stream()
            .filter(movement -> (movement.getClass() == Expense.class) && (movement.getType() == ExpenseType.FOOD))
            .map(Movement::getValue)
            .findFirst()
            .orElse(0f);
        assertAll(
            () -> assertEquals(1600f, newValue),
            () -> assertEquals(originalList.size(), newList.size()),
            () -> assertNotEquals(0, newValue)
        );
    }

    @Test
    void differentExpenseIsAppended() {
        final Movement expenseToMerge = new Expense(ExpenseType.ELECTRICITY, 100f);
        List<Movement> newList = (List<Movement>) expenseToMerge.mergeWith(originalList);
        boolean everyValueRemainsTheSame = newList.stream()
            .filter(movement -> (movement.getType() != ExpenseType.ELECTRICITY))
            .toList()
            .equals(originalList);
        assertAll(
            () -> assertTrue(everyValueRemainsTheSame),
            () -> assertNotEquals(originalList.size(), newList.size())
        );
    }
}