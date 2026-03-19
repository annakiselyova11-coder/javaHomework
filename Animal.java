public class Animal {
    private static int animalCount = 0;

    public Animal() {
    }

    public static int getAnimalCount() {
        return animalCount;
    }
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount ++;
    }

    public void run(int distance){
        System.out.println(name + " бежит.");
    }

    public void swim(int distance) {
        System.out.println(name + " плывет.");
    }

    public String getName(){
        return name;
    }

}
