import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private String name;
    private BigDecimal price;
    private LocalDate productionDate;
    private String manufacturer;
    private String country;
    private boolean isBooked;

    public Product(String name, BigDecimal price, LocalDate productionDate, String manufacturer, String country, boolean isBooked) {
        this.name = name;
        this.price = price;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.isBooked = isBooked;
    }

    public void printInfo(){
        System.out.println("Название: " + this.name);
        System.out.println("Цена: " + this.price);
        System.out.println("Дата производства: " + this.productionDate);
        System.out.println("Производитель: " + this.manufacturer);
        System.out.println("Страна происхождения: " + this.country);

        if (this.isBooked){
            System.out.println("Состояние бронирования покупателем: Забронировано");
        } else {
            System.out.println("Состояние бронирования покупателем: Свободен");
        }

    }





}
