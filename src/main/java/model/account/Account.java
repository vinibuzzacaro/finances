package model.account;

import model.movement.Expense;
import model.movement.Income;
import model.movement.Movement;

import java.util.Collection;
import java.util.List;

public class Account {
    private Collection<Movement> movements;
    private float totalIncome = 0f;
    private float totalExpense = 0f;

    public Account() {}

    public Account(List<Movement> movements) {
        this.movements = movements;
        updateValues();
    }

    public float getTotalIncome() {
        return this.totalIncome;
    }

    public float getTotalExpense() {
        return this.totalExpense;
    }

    private void updateValues() {
        this.totalExpense = 0f;
        this.totalIncome = 0f;
        for (Movement movement : this.movements) {
            if (movement instanceof Income) {
                this.totalIncome += movement.getValue();
            } else if (movement instanceof Expense) {
                this.totalExpense += movement.getValue();
            }
        }
    }

    public void addMovement(Movement movement) {
        this.movements = movement.mergeWith(this.movements);
        updateValues();
    }

    public void addMovements(Collection<Movement> list) {
        for (Movement movement : list) {
            this.movements = movement.mergeWith(this.movements);
        }
        updateValues();
    }

    public void resume() {
        String message = "\n";
        String summary = "";
        int upperBound  = this.movements.stream()
            .map(movement -> movement.getType().toString().length())
            .max(Integer::compare)
            .orElse(0);
        for (Movement movement : this.movements) {
            summary = movement.summarize();
            message = message
                .concat(summary)
                .concat("\n");
        }
        message = message.concat(
            String.format(
                "Total Income: %.2f\nTotal Expense: %.2f\nLiquid Income: %.2f",
                this.totalIncome,
                this.totalExpense,
                this.totalIncome - this.totalExpense
            )
        );
        System.out.println(message);
    }
}
