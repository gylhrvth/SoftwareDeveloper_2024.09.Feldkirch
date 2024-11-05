package Erik.week08;

import java.util.Random;
import java.util.Vector;

/*
zwei vectoren erstellen mit je 20 elementen
beide vectoren sollen sortiert sein
dritten vector erstellen, indem 1. und 2. vektor gemergt (verschmolzen) wird.
nach dem mergen soll der neue vektor noch sortiert sein
 */

public class VectorenMergen {
    public static Random rand = new Random();

    public static void main(String[] args) {
        Vector<Integer> vec1 = VectorErstellen.fillVectorWithNumbers();     // Wird befüllt mit 20 Random Zahlen
        Vector<Integer> vec2 = VectorErstellen.fillVectorWithNumbers();     // Wird befüllt mit 20 Random Zahlen

        System.out.println("1.Vec Original: >> " + vec1);
        System.out.println("2.Vec Original: >> " + vec2);
        VectorErstellen.sortVectorDescending(vec1);
        VectorErstellen.sortVectorDescending(vec2);
        System.out.println("\n1.Vec Sortiert: >> " + vec1);
        System.out.println("2.Vec Sortiert: >> " + vec2);

        Vector<Integer> merged = mergeBothVectors(vec1, vec2);
        System.out.println(">>Merged Vector<<\n" + merged);
    }

    public static Vector<Integer> mergeBothVectors(Vector<Integer> left, Vector<Integer> right) {
        Vector<Integer> result = new Vector<>();    // Neuer Vektor erstellt

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.firstElement() < right.firstElement()) {
                result.add(left.removeFirst());     // removed die erste Zahl vom linken Vektor und speicher diesen dann in den result Vektor
            } else {
                result.add(right.removeFirst());
            }
        }
        while (left.isEmpty()) {
            result.add(left.removeFirst());
        }
        while (right.isEmpty()) {
            result.add(right.removeFirst());
        }
        return result;
    }
}
/*
    1. Vec = linke Seite
    2. Vec = rechte Seite
    3. Vec = Ergebnis

    vom 1. Vec die erste Zahl mit der 1. Zahl vom 2. Vec vergleichen
    die größer Zahl wird in die 3. Vec gespeichert
    dann wird die übernommene Zahl in der jeweiligen Vec gelöscht
    dann wird wieder die 1. Zahl von der 1. und 2. Vec verglichen

   Tools: (.remove, .get, .set) ?
   ----------------------------------------
   vergleicht die erste Pos von der linken mit der rechten
   if (rightSide.get(pos) > leftSide.get(pos)) {
         result.set(pos, rightSide.get(pos));
         rightSide.remove(pos);

Erster Versuch:
    public static Vector<Integer> mergeTwoVectors(Vector<Integer> leftSide, Vector<Integer> rightSide) {
        Vector<Integer> result = new Vector<>();                  // neuer Vektor erstellt
        result.setSize(leftSide.size() + rightSide.size());       // result Size wird auf 40 Elemente gestellt

        for (int pos = 0; pos < 40; pos++) {
            // eine schleife die result befüllt von 0-40 ?
            // eine schleife die 20 mal durch die jeweiligen vectoren durchgeht ?

            if (leftSide.get(pos) > rightSide.get(pos)) {         // jeweils erste Zahl vergleichen
                result.set(pos, leftSide.get(pos));               // result auf pos pos wird überschrieben
                leftSide.remove(pos);                             // erste Pos wird gelöscht nach der übername

            } else if (rightSide.get(pos) > leftSide.get(pos)) {
                result.set(pos, rightSide.get(pos));
                rightSide.remove(pos);

            }
            // vergleicht, die ersten zahlen miteinander übernimmt die größte zahl
            // überschreibt beim nächsten durchgang diese zahl mit der nächst größeren
        }
        return result;
    }

Zweiter Versuch eig gleich wie erster:
    public static Vector<Integer> test(Vector<Integer> leftSide, Vector<Integer> rightSide) {
        Vector<Integer> result = new Vector<>();                  // neuer Vektor erstellt
        result.setSize(leftSide.size() + rightSide.size());       // result Size wird auf 40 Elemente gestellt

        for (int pos = 0; pos < 40; pos++) {

            if (leftSide.get(pos) > rightSide.get(pos) || rightSide.get(pos) > leftSide.get(pos)) {
                result.set(pos, leftSide.get(pos));
                leftSide.remove(pos);
                result.set(pos, rightSide.get(pos));
                rightSide.remove(pos);
            }

        }
        return result;
    }
*/

