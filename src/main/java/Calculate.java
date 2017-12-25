public class Calculate {
    int amount;
    private boolean newObject;


    public Calculate() {
        this.amount = 0;
        this.newObject = true;
    }

    private boolean isNew() {
        return this.newObject;
    }

    private boolean equalsByZero(int input) {
        return input == 0;
    }

    public boolean equals(int input) {
        Calculate newOne = new Calculate();
        newOne.apply(input);
        return amount == newOne.amount;
    }

    boolean apply(int amount) {
        if (isNew()) {
            this.amount = amount;
            this.newObject = false;
            return true;
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
}