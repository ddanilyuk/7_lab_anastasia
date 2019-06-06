import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;


public class MyVegetableListTest {
    private Vegetable pomidor = new Vegetable(200, "pomidor ", 3);
    private MyVegetableList one = new MyVegetableList();
    private Vegetable kapusta = new Vegetable(200, "kapusta ", 3);
    private MyVegetableList another = new MyVegetableList();
    private Vegetable cucumber = new Vegetable(123, "cucumber", 2);

    @Test
    public void size() {
        one.add(kapusta);
        int expected = 1;
        int actual = one.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isEmpty() {
        one.add(pomidor);
        Assert.assertFalse(one.isEmpty());
        Assert.assertTrue(another.isEmpty());
    }


    @Test
    public void contains() {
        one.add(pomidor);
        Assert.assertTrue(one.contains(pomidor));
        Assert.assertFalse(one.contains(kapusta));
    }

    @Test
    public void iterator() {
        another.add(pomidor);
        another.add(kapusta);
        another.add(cucumber);
        Iterator<Vegetable> iter = another.iterator();
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals(pomidor, iter.next());
        Assert.assertEquals(kapusta, iter.next());
        Assert.assertEquals(cucumber, iter.next());
        Assert.assertFalse(iter.hasNext());
    }

    @Test
    public void toArray() {
        another.add(pomidor);
        another.add(kapusta);
        Object[] arr = another.toArray();
        Assert.assertEquals((arr[0]), pomidor);
        Assert.assertEquals((arr[1]), kapusta);
    }


    @Test
    public void add() {
        Assert.assertTrue(one.add(pomidor));
    }


    @Test
    public void remove() {
        one.add(kapusta);
        Assert.assertTrue(one.remove(kapusta));
    }

    @Test
    public void addAll() {
        another.add(pomidor);
        another.add(kapusta);
        Assert.assertTrue(one.addAll(another));
    }


    @Test
    public void removeAll() {
        another.add(pomidor);
        another.add(kapusta);
        one.add(pomidor);
        Assert.assertTrue(another.removeAll(one));

    }

    @Test
    public void containsAll() {
        another.add(pomidor);
        another.add(kapusta);
        one.add(cucumber);
        Assert.assertFalse(another.containsAll(one));
    }

    @Test
    public void retainAll() {
        ArrayList<Vegetable> test = new ArrayList<>();
        test.add(pomidor);
        test.add(cucumber);
        test.add(kapusta);
        another.addAll(test);
        Assert.assertTrue(another.retainAll(test));
        Assert.assertEquals(3, another.size());
    }


    @Test
    public void clear() {
        another.add(pomidor);
        another.clear();
        Assert.assertEquals(0, another.size());
    }

    @Test
    public void get() {
        another.add(pomidor);
        another.add(kapusta);
        Assert.assertEquals(pomidor, another.get(0));
        Assert.assertEquals(kapusta, another.get(1));
    }

    @Test
    public void set() {
        another.add(kapusta);
        another.set(0, pomidor);
        Assert.assertEquals(another.get(0), pomidor);
    }

    @Test
    public void indexOf() {
        one.add(pomidor);
        Assert.assertEquals(0, one.indexOf(pomidor));
        Assert.assertEquals(-1, one.indexOf(kapusta));
    }

    @Test
    public void lastIndexOf() {
        one.add(pomidor);
        one.add(kapusta);
        Assert.assertEquals(1, one.lastIndexOf(kapusta));
        Assert.assertEquals(-1, one.indexOf(cucumber));
    }

    @Test
    public void listIterator() {
        another.add(pomidor);
        another.add(kapusta);
        another.add(cucumber);
        Iterator<Vegetable> iter = another.iterator();
        Assert.assertTrue(iter.hasNext());
        Assert.assertEquals(pomidor, iter.next());
        Assert.assertEquals(kapusta, iter.next());
        Assert.assertEquals(cucumber, iter.next());
        Assert.assertFalse(iter.hasNext());
    }


    @Test
    public void subList() {
        another.add(pomidor);
        another.add(kapusta);
        another.add(cucumber);
        one.add(kapusta);
        one.add(pomidor);
        one.add(cucumber);
        Assert.assertEquals(one.subList(1, 2), another.subList(0, 1));
    }
}

