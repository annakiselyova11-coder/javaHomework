public class Cat extends Animal {

    private static final int maxRunDistance = 200;
    private static final int maxSwimDistance = 0;
    private boolean isSatiated = false;

    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount ++;
    }
    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может бегать на большие дистанции.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не плавают.");
    }

    public void eat(Bowl bowl, int appetite) {
        if (bowl.takeFood(appetite)) {
            this.isSatiated = true;
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }

    public boolean isSatiated() {
        return isSatiated;
    }
}
