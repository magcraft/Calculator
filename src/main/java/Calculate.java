public class Calculate {
    int amount;

    public Calculate() {
        this.amount = 0;
    }

    void apply(int amount) {
        this.amount = amount;
    }

    void add(int amount) {
        this.amount += amount;
    }

    void divide(int amount) {
        this.amount /= amount;
    }
}