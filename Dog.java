public class Dog extends Animal {

    private static final int maxRunDistance = 500;
    private static final int maxSwimDistance = 10;

    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount ++;
    }

    public static int getDogCount() {
        return dogCount;
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
        if (distance <= maxSwimDistance){
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может плавать на большие дистанции.");
        }
    }
}

