package Introduction;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Wildcards {

    /**
     * Using in old JAVA, notice we know nothing about the type in the collection.
     */
    static void printCollectionOld(Collection c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }

    /**
     * Using foreach, but loosing features as connection has to contain objects.
     */
    static void printCollectionNaive(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    /**
     * Using generic types
     */
    static <T> void printCollectionUsingGenerics(Collection<T> c) {
        for (T e : c) {
            System.out.println(e);
        }
    }

    /**
     * Using wildcard types
     */
    static void printCollectionNew(Collection<?> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Collection<String> stringCollection = new HashSet<>(Arrays.asList("one", "two", "three"));

        //printCollectionNaive(stringCollection); // <- Not possible as this is NOT a string og objects..
        printCollectionNew(stringCollection); // <- Is possible as we are using wildcard type..
        printCollectionUsingGenerics(stringCollection); // <- Is possible as we are using generic type..
    }
}
