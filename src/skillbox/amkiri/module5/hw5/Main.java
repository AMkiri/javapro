package skillbox.amkiri.module5.hw5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Forming list...");
        List<String> list = genAutoNumbers();
        System.out.println("List's formed.");

        System.out.println("Adding to sets..");
        TreeSet<String> treeSet = new TreeSet<>(list);
        HashSet<String> hashSet = new HashSet<>(list);
        System.out.println("Data completed.\n");

        System.out.println("Number of elements: " + treeSet.size());

        String stringToFind = list.get(list.size() - 1);
        System.out.println("Element to find: " + stringToFind);

        long start = System.nanoTime();
        boolean fromArray = list.contains(stringToFind);
        long end = System.nanoTime();
        System.out.println("By direct search: " + (end - start) + " ns. "+ fromArray);

        start = System.nanoTime();
        boolean byBinarySearch = Collections.binarySearch(list, stringToFind) >= 0;
        end = System.nanoTime();
        System.out.println("By binary search: " + (end - start) + " ns. "+ byBinarySearch);

        start = System.nanoTime();
        boolean fromTreeSet = treeSet.contains(stringToFind);
        end = System.nanoTime();
        System.out.println("By tree search: " + (end - start) + " ns. "+ fromTreeSet);

        start = System.nanoTime();
        boolean fromHashSet = hashSet.contains(stringToFind);
        end = System.nanoTime();
        System.out.println("By hash search: " + (end - start) + " ns. "+ fromHashSet);

    }

    private static List<String> genAutoNumbers() {
        List<String> list = new ArrayList<>(5000000);

        for (char ch = 'A'; ch <= 'Z'; ch++) {

            System.out.println(ch + "\t...");

            for (int i = 0; i < 1000; i++) {

                String numPart = ch + intToString(i) + ch + ch;
                appendAllRegions(numPart, list);

            }
        }

        return list;
    }

    private static void appendAllRegions(String autoNum, List<String> list) {

        autoNum = autoNum.concat(" ");

        for (int i = 1; i < 179; i++) {
            list.add( autoNum + intToString(i) );
        }

    }

    private static String intToString(int i) {
        return String.format("%03d" , i);
    }
}
