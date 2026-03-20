import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades = new ArrayList<>();

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public void addGrade(int grade) {
        if (grade >= 2 && grade <= 5) {
            this.grades.add(grade);
        } else {
            System.out.println("Недопустимая оценка.");

        }
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum = sum + grade;
        }
        return (double) sum / grades.size();
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group);
    }

}
