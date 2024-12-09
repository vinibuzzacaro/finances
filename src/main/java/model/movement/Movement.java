package model.movement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Movement {
    private final MovementType type;
    private float value;

    public Movement(MovementType type, float value) {
        this.type = type;
        this.value = value;
    }

    public String summarize() {
        return String.format(
            "%s %s: %.2f",
            this.type.toString(),
            this.getClass().getName().replace("model.movement.", ""),
            this.value
        );
    }

    public float getValue() {
        return this.value;
    }

    public MovementType getType() {
        return this.type;
    }

    public Collection<Movement> mergeWith(Collection<Movement> collection) {
        boolean objectWasInsertedInTheList = false;
        List<Movement> mergedList = new ArrayList<>();
        final Class<? extends Movement> thisClass = this.getClass();
        Class<? extends Movement> currentClass;
        MovementType currentType;
        for (Movement movement : collection) {
            currentClass = movement.getClass();
            if (thisClass != currentClass) {
                mergedList.add(movement);
                continue;
            }
            currentType = movement.getType();
            if (this.type != currentType) {
                mergedList.add(movement);
                continue;
            }
            this.value += movement.getValue();
            mergedList.add(this);
            objectWasInsertedInTheList = true;
        }
        if (!objectWasInsertedInTheList) {
            mergedList.add(this);
        }
        return mergedList;
    }
}
