import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Student{
    private String surname;
    private String name;
    private String group;
    private List<Integer> grades;

    public Student(String surname,String name,String group){
        this.surname=surname;
        this.name=name;
        this.group=group;
        this.grades= new ArrayList<>();
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }

    public void addGrade(Integer grade) {
        this.grades.add(grade);
    }

    public boolean Integralist(){
        for(int grade : grades){
            if(grade < 5) return false;
        }
        return true;
    }

    public double Average(){
        double sum=0;
        for(int grade : grades){
            sum+=grade;
        }
        return sum/grades.size();
    }

    public int failedExams(){
        int count=0;
        for(int grade : grades){
            if(grade < 5) count++;
        }
        return count;
    }

    public String toString() {
        String result = "";
        result += group;
        result += String.format(" %10s", surname);
        result += String.format(" %10s", name);
        result += String.format(" %10s", grades);
        return result;
    }

}
