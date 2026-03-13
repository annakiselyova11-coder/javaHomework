public class Bowl {
    private int food;

    public Bowl(int foodAmount) {
        this.food = foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            this.food += amount;
    } else {
            System.out.println("Невозможно добавить отрицательное количество еды.");
        }
    }

    public boolean takeFood(int amount) {
        if (this.food >= amount) {
            this.food -= amount;
            return true;
        } else {
            return false;
        }

    }
}
