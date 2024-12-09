package model.movement;

public enum ExpenseType implements MovementType {
    FOOD,
    WATER,
    ELECTRICITY,
    DIAPER,
    GASOLINE,
    GAS,
    RENT;
    
    @Override
    public String toString() {
        return switch (this) {
            case FOOD -> "Food";
            case WATER -> "Water";
            case ELECTRICITY -> "Electricity";
            case DIAPER -> "Diaper";
            case GASOLINE -> "Gasoline";
            case GAS -> "Gas";
            case RENT -> "Rent";
        };
    }

    public static ExpenseType fromString(String str) throws Exception {
        return switch(str.toUpperCase()) {
            case "FOOD" -> ExpenseType.FOOD;
            case "WATER" -> ExpenseType.WATER;
            case "ELECTRICITY" -> ExpenseType.ELECTRICITY;
            case "DIAPER" -> ExpenseType.DIAPER;
            case "GASOLINE" -> ExpenseType.GASOLINE;
            case "GAS" -> ExpenseType.GAS;
            case "RENT" -> ExpenseType.RENT;
            default -> throw new Exception("Could not parse string to ExpenseType enum variant");
        };
    }
}
