import java.math.BigDecimal;

public class Park {
    private String name;
    private Address address;
    private String workingHours;
    private Attraction[] attractions;

    public Park(String name, Address address, String workingHours) {
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        this.attractions = new Attraction[5];
    }
    public void addAttraction(Attraction attraction, int index) {
        attractions[index] = attraction;
    }


       public class Attraction {
        private String name;
        private String workingHours;
        private BigDecimal price;

           public Attraction(String name, String workingHours, BigDecimal price) {
               this.name = name;
               this.workingHours = workingHours;
               this.price = price;
           }

           public void printInfo(){
               System.out.println("* " + name);
               System.out.println("Время работы: " + workingHours);
               System.out.println("Стоимость: "+ price + " руб.");
           }
       }

       public void printParkInfo(){
           System.out.println(name);
           System.out.println("Адрес: " + address.getFullAddress());
           System.out.println("Режим работы: " + workingHours);
           System.out.println("Аттракционы:");
           for (Attraction attraction : attractions) {
               if (attraction != null){
                   attraction.printInfo();
                   System.out.println("--------------");

               }
           }
       }

}
