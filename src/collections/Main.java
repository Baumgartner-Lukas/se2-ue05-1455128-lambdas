package collections;

import inout.In;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

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

        System.out.println("Filter dark, medium and bright minutes: ");
        List<Integer> dark = list.filter(i -> i <= 30);
        List<Integer> medium = list.filter(i -> i > 30 && i <= 70);
        List<Integer> bright = list.filter(i -> i > 70);
        System.out.println("Dunkel: " + dark.size());
        System.out.println("Mittel: " + medium.size());
        System.out.println("Hell: " + bright.size() + "\n");

        System.out.printf("Max Value: %d%n%n", list.reduce(0, (a, b) -> a > b ? a : b));

        System.out.printf("If brightness is < 50 map value to N(no charge) else to C (charge) %n%s%n%n",
                list.map(i -> i < 50 ? "N" : "C").reduce("", (a,b) -> a + b));

        System.out.printf("Daily energy production %.0f%n", list.filter(i -> i >= 50)
                .map(i -> Math.pow((0.01 * i), 2))
                .filter(i -> i < 0.5)
                .reduce(0.0, (a,b) -> a+b));

        System.out.println("\nPrint extreme brightness (value >= 80): ");
        list.filter(i -> i >= 80).forEach(i -> System.out.println("Extreme Helligkeit: " + i));

    }
}
