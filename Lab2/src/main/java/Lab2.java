import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

void main() {

    //2.7.1

    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    List<Integer> xPlusY = new ArrayList(); //a
    Set<Integer> zSet = new TreeSet(); //b
    List<Integer> xMinusY = new ArrayList();//c
    int p = 4;

    List<Integer> xPlusYLimitedByP = new ArrayList();

    Random rand = new Random();
    IntStream.range(0,5).forEach(i -> x.add(rand.nextInt(10)));
    Collections.sort(x);
    IntStream.range(0,7).forEach(i -> y.add(rand.nextInt(10)));
    Collections.sort(y);

    System.out.println("Problema 2.7.1");
    System.out.println();

    System.out.println("Elementele din lista x (sortate):" +x);
    System.out.println("Elementele din lista y (sortate):" +y);

    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    System.out.println("Elementele din lista xPlusY (sortate):" +xPlusY);

    zSet.addAll(x);
    zSet.retainAll(y);
    System.out.println("Elementele din zSet (sortate):" +zSet);

    xMinusY.addAll(x);
    xMinusY.removeAll(y);
    System.out.println("Elementele din lista xMinusY (sortate):" +xMinusY);

    xPlusYLimitedByP.addAll(x);
    xPlusYLimitedByP.addAll(y);
    xPlusYLimitedByP.removeIf(i -> i > p);
    Collections.sort(xPlusYLimitedByP);
    System.out.println("Elementele din lista xPlusLimitedByP (sortate):" +xPlusYLimitedByP);
    System.out.println();

    //2.7.2

    System.out.println("Problema 2.7.2");

    List<Student> students = new ArrayList<>();
    students.add(new Student("Popescu", "Marian", "225_3"));
    students.add(new Student("Popescu", "Maria", "225_3"));
    students.add(new Student("Popa", "Marian", "225_3"));
    students.add(new Student("Bica", "Irina", "225_3"));
    students.add(new Student("Badea", "Ion", "225_1"));
    students.add(new Student("Cacoveanu", "Andreea", "225_1"));
    students.add(new Student("Onofrei", "Mircea", "225_1"));

    for (Student s : students) {
        for (int i = 0; i < 5; i++) {
            s.addGrade(rand.nextInt(7) + 4);
        }
    }

    class ByGroupAndAlphabet implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            int groupCompare = s1.getGroup().compareTo(s2.getGroup());
            if (groupCompare != 0) {
                return groupCompare;
            }
            int surnameCompare = s1.getSurname().compareTo(s2.getSurname());
            if (surnameCompare != 0) {
                return surnameCompare;
            }
            return s1.getName().compareTo(s2.getName());
        }
    }

    class ByAverageDescending implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.Average(), s1.Average());
        }
    }

    class ByFailedSubjects implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.failedExams(), s2.failedExams());
        }
    }

    List<Student> integralists = new ArrayList<>();
    List<Student> failedStudents = new ArrayList<>();

    for(Student s: students){
        if(s.Integralist()){
            integralists.add(s);
        }
        else{
            failedStudents.add(s);
        }
    }

    System.out.println();
    System.out.println("b1) Ordine alfabetica pe grupe:");
    Collections.sort(students, new ByGroupAndAlphabet());
    for(Student s: students){
        System.out.println(s);
    }

    System.out.println();
    System.out.println("b2) Integralisti (medie descrescator):");
    Collections.sort(integralists, new ByAverageDescending());
    for(Student s: integralists){
        System.out.println(s);
    }

    System.out.println();
    System.out.println("b3) Restantieri (nr. restante):");
    Collections.sort(failedStudents, new ByFailedSubjects());
    for(Student s: failedStudents){
        System.out.println(s);
    }
}

