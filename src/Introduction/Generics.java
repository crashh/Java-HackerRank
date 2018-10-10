package Introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Generics {

    static <T> void fromArrayToCollection(T[] array, Collection<T> collection) {
        for (T entry : array) {
            collection.add(entry);
        }
    }

    static <T> T pickOne(T first, T second) {
        return first;
    }

    public static void main (String args[]) {
        GenericMethodUsage();
        CollectionHashSet();
    }

    private static void GenericMethodUsage() {
        Integer[] intArray = new Integer[] {1, 2, 3, 4, 5};
        String[] stringArray = new String[] {"one", "two", "three"};

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();

        fromArrayToCollection(intArray, arrayList);
        fromArrayToCollection(stringArray, stringList);

        String[] picked = pickOne(stringArray, new String[0]);
        System.out.println(Arrays.toString(picked));
    }

    private static void CollectionHashSet() {

        String[] stringArray = new String[] {"one", "two", "three"};
        Collection<String> stringCollection = new HashSet<>();

        fromArrayToCollection(stringArray, stringCollection);
        System.out.println(stringCollection.toString());

        stringCollection.add("test");
        System.out.println(stringCollection.toString());

        stringCollection.remove("test");
        System.out.println(stringCollection.toString());
    }
}
