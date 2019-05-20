import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyVegetableList myVegetableList = new MyVegetableList();
        myVegetableList.add(new Vegetable(123, "cucumber", 2));
        myVegetableList.add(new Vegetable(200, "pomidor ", 3));
        myVegetableList.add(new Vegetable(400, "luk     ", 5));

        Iterator<Vegetable> iterator = myVegetableList.iterator();

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        try {
            System.out.println(iterator.next());
        } catch (NoSuchElementException e) {
            System.out.println("Ты не прав:)");
        }
        System.out.println("====================");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }
    }
}
