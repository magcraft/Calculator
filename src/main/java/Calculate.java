public class Calculate {
    private int amount;
    private boolean newObject;

    public Calculate() {
        this.amount = 0;
        this.newObject = true;
    }

    private Calculate(int amount) {
        this.amount = amount;
        this.newObject = false;
    }

    private boolean isNew() {
        return this.newObject;
    }

    private boolean equalsByZero(int input) {
        return input == 0;
    }

    public boolean equals(int input) {
        Calculate newOne = new Calculate(input);
        return amount == newOne.amount;
    }

    boolean apply(int amount) {
        if (isNew()) {
            this.amount = amount;
            this.newObject = false;
            return equals(amount);
        }
        return false;
    }

    boolean add(int amount) {
        if (!(isNew())) {
            this.amount += amount;
            return true;
        }
        return false;
    }

    boolean divide(int amount) {
        if (equalsByZero(amount)) {
            return false;
        }
        if (!isNew()) {
            this.amount /= amount;
            return true;
        }
        return false;
    }

    boolean subtract(int amount) {
        if (!isNew()) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    boolean multiply(int amount) {
        if (!isNew()) {
            this.amount *= amount;
            return true;
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }
}