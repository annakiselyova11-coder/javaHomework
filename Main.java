import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung Galaxy S26 Ultra",new BigDecimal("144990"),LocalDate.of(2026,10,10),"Samsung","Vietnam",true);
        productsArray[1] = new Product("Samsung Galaxy Z TriFold",new BigDecimal("499990"), LocalDate.of(2026,12,12),"Samsung","Vietnam", false);
        productsArray[2] = new Product("Вертикальный пылесос Samsung Jet 85 pet", new BigDecimal("30990"),LocalDate.of(2025,12,13),"Samsung","Vietnam", true);
        productsArray[3] = new Product("Беспроводные наушники Samsung Galaxy Buds3 Pro", new BigDecimal("17490"), LocalDate.of(2023,8,23),"Samsung", "Vietnam", false);
        productsArray[4] = new Product("Смарт-часы Samsung Galaxy Watch Ultra LTE 47 мм", new BigDecimal("38490"),LocalDate.of(2025,6,7),"Samsung","Vietnam",true);

        for (Product product : productsArray) {
            if (product != null) {
                product.printInfo();
                System.out.println("------------");

            }
        }

        Address address = new Address("Самара","улица Советской Армии","181В" );
        Park park = new Park("Парк аттракционов 'Три медведя'",address, "10:00 - 22:00");

        Park.Attraction a1 = park.new Attraction("Лазерный тир","10:00 - 22:00",new BigDecimal("250"));
        Park.Attraction a2 = park.new Attraction("Летающая тарелка","10:00 - 22:00",new BigDecimal("300"));
        Park.Attraction a3 = park.new Attraction("Автодром","10:00 - 22:00",new BigDecimal("300"));
        Park.Attraction a4 = park.new Attraction("Супер Полет","10:00 - 22:00", new BigDecimal("400"));
        Park.Attraction a5 = park.new Attraction("Колесо обозрения", "10:00 - 22:00",new BigDecimal("300"));

        park.addAttraction(a1,0);
        park.addAttraction(a2,1);
        park.addAttraction(a3,2);
        park.addAttraction(a4,3);
        park.addAttraction(a5,4);

        park.printParkInfo();
    }


}

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
