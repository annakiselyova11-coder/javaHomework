import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phone) {
        if (!book.containsKey(surname)) {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            book.put(surname, phones);
        } else {
            book.get(surname).add(phone);
        }
    }

    public List<String> get(String surname) {
        if (book.containsKey(surname)) {
            return book.get(surname);
        } else {
            return new ArrayList<>();
        }
    }
}
