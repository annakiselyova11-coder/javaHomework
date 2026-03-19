public class Main {
    public static void main(String[] args) {

        Bowl bowl = new Bowl(30);

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Барсик");
        cats[1] = new Cat("Мурзик");
        cats[2] = new Cat("Пушок");

        for (Cat cat : cats) {
            cat.eat(bowl,10);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiated());
        }


        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog("Шарик");
        dogs[1] = new Dog("Бобик");
        dogs[2] = new Dog("Федор");


        dogs[0].run(300);
        dogs[1].run(150);
        dogs[2].run(501);

        dogs[0].swim(400);
        dogs[1].swim(100);
        dogs[2].swim(300);

        cats[0].run(100);
        cats[1].run(300);
        cats[2].run(200);

        cats[0].swim(100);
        cats[1].swim(200);
        cats[2].swim(300);

        System.out.println("Результаты:");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());

        System.out.println("----------------------");



        Shape[] figures = new Shape[3];

        figures[0] = new Circle(5.0,"blue", "green");
        figures[1] = new Rectangle(10.00, 7.00,"orange","red");
        figures[2] = new Triangle(5.0, 5.0, 5.0, "beige","black");


        for (Shape shape : figures) {
            System.out.println("------- Figure -------");
            shape.printInfo();
            System.out.println();
        }









    }


}