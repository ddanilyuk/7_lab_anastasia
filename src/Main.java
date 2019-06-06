import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyVegetableList myVegetableList = new MyVegetableList();
        MyVegetableList myVegetableList2 = new MyVegetableList();


        Vegetable pomidor = new Vegetable(200, "pomidor ", 3);
        Vegetable kapusta = new Vegetable(200, "kapusta ", 3);
        Vegetable cucumber = new Vegetable(123, "cucumber", 2);


        myVegetableList.add(pomidor);
        myVegetableList.add(cucumber);
        myVegetableList.add(pomidor);
        myVegetableList2.add(pomidor);


        /*
        MyVegetableList.separator("clear");
        myVegetableList.clear();

        System.out.println("add");
        myVegetableList.addAll(0, myVegetableList2);
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }
        */



        MyVegetableList.separator("Iterator");
        Iterator<Vegetable> iterator = myVegetableList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        MyVegetableList.separator("Array");
        Object[] arr = myVegetableList.toArray();
        System.out.println(Arrays.toString(arr));


        MyVegetableList.separator("myVegetableListForEach");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }


        MyVegetableList.separator("myVegetableList2ForEach");
        for (Vegetable vegetable : myVegetableList2) {
            System.out.println(vegetable);
        }


        MyVegetableList.separator("ContainsAll myVegetableList2 in myVegetableList");
        System.out.println(myVegetableList.containsAll(myVegetableList2));


        /*
        MyVegetableList.separator("remove");
        myVegetableList.remove(pomidor);
        */

        MyVegetableList.separator("retainAll");
        System.out.println(myVegetableList.retainAll(myVegetableList2));


        MyVegetableList.separator("Try if contains");
        System.out.println("MyVegetableList contains pomidor: " + myVegetableList.contains(pomidor));


        MyVegetableList.separator("Set some elements to some index");
        myVegetableList.set(0, kapusta);
        myVegetableList.set(2, kapusta);
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }


        MyVegetableList.separator("Get some elements");
        System.out.println(myVegetableList.get(1));


        MyVegetableList.separator("AddALL");
        System.out.println("1");
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }
        System.out.println("2");
        for (Vegetable vegetable : myVegetableList2) {
            System.out.println(vegetable);
        }
        System.out.println("add");
        //myVegetableList.addAll(4, myVegetableList2);
        for (Vegetable vegetable : myVegetableList) {
            System.out.println(vegetable);
        }

    }
}
