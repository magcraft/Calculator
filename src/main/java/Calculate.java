public class Calculate {
    int amount;
    boolean newOblect;


    public Calculate() {
        this.amount = 0;
        this.newOblect = true;
    }

    private boolean isNew() {
        return this.newOblect;
    }

    boolean apply(int amount) {
        if (isNew()) {
            this.amount = amount;
            this.newOblect = false;
            return true;
        }
        return false;
    }

    void add(int amount) {
        this.amount += amount;
    }

    void divide(int amount) {
        this.amount /= amount;
    }
}