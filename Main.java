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

