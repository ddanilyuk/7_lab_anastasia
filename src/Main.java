import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyVegetableList myVegetableList = new MyVegetableList();

        Vegetable pomidor = new Vegetable(200, "pomidor ", 3);

        myVegetableList.add(pomidor);
        myVegetableList.add(new Vegetable(123, "cucumber", 2));
        myVegetableList.add(new Vegetable(400, "luk     ", 5));
        // myVegetableList.clear();
        Iterator<Vegetable> iterator = myVegetableList.iterator();


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("====================");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }


        System.out.println("====================");
        System.out.println("Try if contains");
        System.out.println("MyVegetableList contains pomidor: " + myVegetableList.contains(pomidor));




    }
}
