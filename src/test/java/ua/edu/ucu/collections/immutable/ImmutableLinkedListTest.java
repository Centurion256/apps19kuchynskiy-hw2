package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableLinkedListTest {


    @Test
    public void TestConstuctorEmpty()
    {
        Object[] empty = {};
        ImmutableList lst = new ImmutableLinkedList();
        assertEquals(true, lst.isEmpty());
        assertArrayEquals(empty, lst.toArray());
    }
    @Test
    public void TestConstuctor()
    {
        Object[] arr = {1,2};
        ImmutableList lst = new ImmutableLinkedList(arr);
        assertEquals(false, lst.isEmpty());
        assertArrayEquals(arr, lst.toArray());
    }
    @Test
    public void testAdd() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] newArr = {1, 2, 3, 4, 5};
        ImmutableList newLst = lst.add(5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddZeroIndex() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] newArr = {5, 1, 2, 3, 4};
        ImmutableList newLst = lst.add(0, 5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddAnyIndex() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] newArr = {1, 2, 5, 3, 4};
        ImmutableList newLst = lst.add(2, 5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIncorrectIndex() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] newArr = {1, 2, 3, 4};
        ImmutableList newLst = lst.add(5, 5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddToEmpty() 
    {
        Object[] arr = {};
        ImmutableList lst = new ImmutableLinkedList();
        Object[] newArr = {5};
        ImmutableList newLst = lst.add(0, 5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddAll() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] addedElements = {5,6,7};
        Object[] newArr = {1, 2, 3, 4, 5, 6, 7};
        ImmutableList newLst = lst.addAll(addedElements);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddAllZeroIndex() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] addedElements = {5,6,7};
        Object[] newArr = {5, 6, 7, 1, 2, 3, 4};
        ImmutableList newLst = lst.addAll(0, addedElements);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddAllAnyIndex() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] addedElements = {5,6,7};
        Object[] newArr = {1, 2, 5, 6, 7, 3, 4};
        ImmutableList newLst = lst.addAll(2, addedElements);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIncorrectIndex() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] addedElements = {5,6,7};
        Object[] newArr = {1, 2, 5, 6, 7, 3, 4};
        ImmutableList newLst = lst.addAll(5, addedElements);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }
    @Test
    public void testAddAllToEmpty() 
    {
        Object[] arr = {};
        ImmutableList lst = new ImmutableLinkedList();
        Object[] addedElements = {5,6,7};
        Object[] newArr = {5,6,7};
        ImmutableList newLst = lst.addAll(0, addedElements);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }
    @Test
    public void testGet() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        assertEquals(3, lst.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExpection() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        assertEquals(3, lst.get(5));
    }

    @Test
    public void testRemove() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {1, 2, 3, 4};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.remove(4);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testRemoveZeroIndex() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.remove(0);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }
    @Test
    public void testRemoveAnyIndex() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {1,2, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.remove(2);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndex() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {1, 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.remove(5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testSet() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {1, 2, 3, 4, 10};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.set(4, 10);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testSetZeroIndex() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {"Zero", 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.set(0, "Zero");
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetInvalidIndex() 
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {1, 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.set(5, 10);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testClear()
    {
        Object[] arr = {1, 2, 3, 4, 5};
        Object[] newArr = {};
        ImmutableList lst = new ImmutableLinkedList(arr);
        ImmutableList newLst = lst.clear();
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testToArray()
    {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        Object[] newArr = lst.toArray();
        assertArrayEquals(arr, newArr);
    }

    @Test
    public void testToString()
    {
        Object[] arr = {1, 2, 3, 4, 5};
        String arrStr = "1, 2, 3, 4, 5";
        ImmutableList lst = new ImmutableLinkedList(arr);
        String newStr = lst.toString();
        assertEquals(arrStr, newStr);
    }

    @Test
    public void testIsEmpty()
    {
        ImmutableList lst = new ImmutableLinkedList();
        assertEquals(true, lst.isEmpty());
    }
    @Test
    public void testIsEmptyFalse()
    {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        assertEquals(false, lst.isEmpty());
    }

    @Test
    public void testIndexOf()
    {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        int index = 4;
        assertEquals(index, lst.indexOf(5));
    }

    @Test
    public void testIndexOfNotFound()
    {
        Object[] arr = {1, 2, 3, 4, 5};
        ImmutableList lst = new ImmutableLinkedList(arr);
        int index = -1;
        assertEquals(index, lst.indexOf(0));
    }
    @Test
    public void testAddFirst() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        Object[] newArr = {5, 1, 2, 3, 4};
        ImmutableList newLst = lst.addFirst(5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }

    @Test
    public void testAddLast() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        Object[] newArr = {1, 2, 3, 4,5};
        ImmutableList newLst = lst.addLast(5);
        assertNotSame(lst, newLst);
        //assertEquals(lst, newLst);
        assertArrayEquals(arr, lst.toArray());
        assertArrayEquals(newArr, newLst.toArray());
    }
    @Test
    public void testGetFirst() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        assertEquals(1, lst.getFirst());
    }
    @Test
    public void testGetLast() 
    {
        Object[] arr = {1, 2, 3, 4};
        ImmutableLinkedList lst = new ImmutableLinkedList(arr);
        assertEquals(4, lst.getLast());
    }
}
