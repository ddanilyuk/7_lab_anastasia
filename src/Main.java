import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyVegetableList myVegetableList = new MyVegetableList();
        MyVegetableList myVegetableList2 = new MyVegetableList();


        Vegetable pomidor = new Vegetable(200, "pomidor ", 3);
        Vegetable kapusta = new Vegetable(200, "kapusta ", 3);
        Vegetable cucumber = new Vegetable(123, "cucumber", 2);
        myVegetableList2.add(pomidor);
        //myVegetableList2.add(kapusta);
        myVegetableList.add(pomidor);

        myVegetableList.add(cucumber);

        // myVegetableList.add(new Vegetable(400, "luk     ", 5));
        // myVegetableList.clear();
        Iterator<Vegetable> iterator = myVegetableList.iterator();
        System.out.println("=========Array===========");
        Object[] arr = myVegetableList.toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("=========new===========");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("====================");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }
        System.out.println(myVegetableList.containsAll(myVegetableList2));
        //myVegetableList.remove(pomidor);
        System.out.println("123");

        System.out.println(myVegetableList.retainAll(myVegetableList2));
        System.out.println("123");
        System.out.println("==========somesmoe==========");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }


        Iterator<Vegetable> iterator2 = myVegetableList.iterator();


        System.out.println("=========new===========");
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        System.out.println("====================");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }
        System.out.println("====================");
        System.out.println("Try if contains");
        System.out.println("MyVegetableList contains pomidor: " + myVegetableList.contains(pomidor));


        myVegetableList.set(0, kapusta);
        myVegetableList.set(2, kapusta);
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }
        System.out.println("===");
        System.out.println(myVegetableList.get(1));




    }
}
