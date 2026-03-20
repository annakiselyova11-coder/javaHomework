public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // 1. Добавляем записи
        phoneBook.add("Иванов", "8-900-111-11-11");
        phoneBook.add("Петров", "8-900-222-22-22");
        phoneBook.add("Иванов", "8-900-333-33-33");  // Второй телефон для Иванова

        // 2. Ищем телефоны
        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
        System.out.println("Сидоров: " + phoneBook.get("Сидоров"));
    }
}
