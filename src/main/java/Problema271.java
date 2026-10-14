import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

void main() {
    List<Integer> x = new ArrayList();
    List<Integer> y = new ArrayList();
    List<Integer> xPlusY = new ArrayList(); //a
    Set<Integer> zSet = new TreeSet(); //b
    List<Integer> xMinusY = new ArrayList();//c
    int p = 4;

    List<Integer> xPlusYLimitedByP = new ArrayList();
    java.util.Random rand = new java.util.Random();
    IntStream.range(0,5).forEach(i -> x.add(rand.nextInt(10)));
    Collections.sort(x);
    IntStream.range(0,7).forEach(i -> y.add(rand.nextInt(10)));
    Collections.sort(y);

    System.out.println("Elementele din lista x (sortate):" +x);
    System.out.println("Elementele din lista y (sortate):" +y);

    xPlusY.addAll(x);
    xPlusY.addAll(y);
    Collections.sort(xPlusY);
    System.out.println("Elementele din lista xPlusY (sortate):" +xPlusY);

    zSet.addAll(x);
    zSet.addAll(y);
    System.out.println("Elementele din zSet (sortate):" +zSet);

    xMinusY.addAll(x);
    xMinusY.removeAll(y);
    System.out.println("Elementele din lista xMinusY (sortate):" +xMinusY);

    xPlusYLimitedByP.addAll(x);
    xPlusYLimitedByP.addAll(y);
    xPlusYLimitedByP.removeIf(i -> i > p);
    Collections.sort(xPlusYLimitedByP);
    System.out.println("Elementele din lista xPlusLimitedByP (sortate):" +xPlusYLimitedByP);
}
