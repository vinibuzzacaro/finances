import model.account.Account;
import model.movement.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final List<Movement> originalList = new ArrayList<>(
            Arrays.asList(
                new Income(IncomeType.SALARY, 3100f),
                new Income(IncomeType.RENT, 600f),
                new Expense(ExpenseType.RENT, 1200f),
                new Expense(ExpenseType.FOOD, 1500f)
            )
        );
        final Collection<Movement> collection = new HashSet<>(
            Arrays.asList(
                new Income(IncomeType.SALARY, 3100f),
                new Income(IncomeType.RENT, 900f),
                new Income(IncomeType.VOUCHER, 600f),
                new Expense(ExpenseType.RENT, 1200f),
                new Expense(ExpenseType.GASOLINE, 300f),
                new Expense(ExpenseType.FOOD, 1400f)
            )
        );
        var s = new Account(originalList);
        System.out.printf("Income: %.2f, Expense: %.2f", s.getTotalIncome(), s.getTotalExpense());
        s.addMovement(new Income(IncomeType.RENT, 600f));
        System.out.printf("\nIncome: %.2f, Expense: %.2f", s.getTotalIncome(), s.getTotalExpense());
        s.addMovements(collection);
        System.out.printf("\nIncome: %.2f, Expense: %.2f", s.getTotalIncome(), s.getTotalExpense());
        s.resume();
    }
}
