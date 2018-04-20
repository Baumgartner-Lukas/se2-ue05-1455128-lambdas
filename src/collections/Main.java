package collections;

import inout.In;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        List<String> l = new HigherOrderArrayList<>();
//        l.add("A");
//        l.add("AA");
//        l.add("AAA");
//        l.add("AAAA");
//
//        for (String e : l) {
//            System.out.println(e);
//        }
//        List<Integer> li = l.map(String::length)
//                .filter(i -> i % 2 == 0);
//        for (Integer e : li) {
//            System.out.println(e);
//        }
//        List<Integer> lr = new HigherOrderArrayList<>();
//        lr.add(1);
//        lr.add(2);
//        lr.add(3);
//        lr.add(4);
//
//        int test = lr.reduce(0, (a, b) -> a + b);
//        System.out.println(test);
//
//        List<String> lu = new HigherOrderArrayList<>();
//        lu.add("b");
//        lu.add("bb");
//        lu.add("bbb");
//        lu.forEach(System.out::println);

        List<Integer> list = new HigherOrderArrayList<>();
        final String fileName = "SunMeasurements.txt";
        // Disclaimer: The In class was not used to import the file!
        //The following was used to import the data from the file.

        //Lesen Sie die Integer-Werte in der Datei SunMeasurements.txt ein und
        //speichern Sie diese in einer HigherOrderArrayList.
        Scanner s = new Scanner(new File(fileName));
        while (s.hasNext()) {
            if (s.hasNextInt()) {
                list.add(s.nextInt());
            } else {
                s.next();
            }
        }

        //Geben Sie dann die Anzahl der dunklen, mittelhellen und hellen Minuten aus.
        //Ein Helligkeitswert zählt als dunkel, wenn sein Wert 30 oder weniger beträgt,
        //als mittelhell, wenn sein Wert größer 30 und kleiner gleich
        //70 ist, und höhere Werte gelten als hell. Verwenden Sie die Methode filter.
        List<Integer> dark = list.filter(i -> i <= 30);
        List<Integer> medium = list.filter(i -> i > 30 && i <= 70);
        List<Integer> bright = list.filter(i -> i > 70);
        System.out.println("Dunkel: " + dark.size());
        System.out.println("Mittel: " + medium.size());
        System.out.println("Hell: " + bright.size());

        //Nutzen Sie die reduce-Funktionalität, um den Wert der hellsten Messung zu berechnen.

        //Die E-Bike-Station kann Räder nur laden, wenn die Helligkeit mindestens 50 erreicht.
        //Dies soll visualisiert werden, indem Sie für jede Helligkeitsmessung entweder
        //das Zeichen „C“ (für Charge) oder „N“ (für No Charge) ausgeben.



    }
}
