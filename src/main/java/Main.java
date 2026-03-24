import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Student s1 = new Student("Olga", "G-1", 1);
        Student s2 = new Student("Anna", "G-2", 2);
        Student s3 = new Student("Prince", "G-1", 1);

        s1.addGrade(5);
        s1.addGrade(4);
        s1.addGrade(3);

        s2.addGrade(3);
        s2.addGrade(3);
        s2.addGrade(3);

        s3.addGrade(2);
        s3.addGrade(2);
        s3.addGrade(4);

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Количество студентов " + students.size());
        removeLowGPAStudents(students);
        System.out.println("Количество студентов после удаления: " + students.size());

        System.out.println("До перевода на следующий курс:");
        for (Student s : students) {
            System.out.println(s.getName() + " - курс " + s.getCourse());
        }
        promoteStudents(students);

        System.out.println("После перевода на следующий курс:");
        for (Student s : students) {
            System.out.println(s.getName() + " - курс " + s.getCourse());
        }

        System.out.println("======");
        System.out.println("Студенты 2 курса:");
        printStudents(students, 2);

        System.out.println("Студенты 3 курса:");
        printStudents(students, 3);
    }

    public static void removeLowGPAStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}


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
