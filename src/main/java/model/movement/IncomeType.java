package model.movement;

public enum IncomeType implements MovementType {
    RENT,
    SALARY,
    VOUCHER;

    @Override
    public String toString() {
        return switch (this) {
            case RENT -> "Rent";
            case SALARY -> "Salary";
            case VOUCHER -> "Voucher";
        };
    }

    public static IncomeType fromString(String str) throws Exception {
        return switch (str.toUpperCase()) {
            case "RENT" -> IncomeType.RENT;
            case "SALARY" -> IncomeType.SALARY;
            case "VOUCHER" -> IncomeType.VOUCHER;
            default -> throw new Exception("Could not parse string to IncomeType enum variant");
        };
    }
}
