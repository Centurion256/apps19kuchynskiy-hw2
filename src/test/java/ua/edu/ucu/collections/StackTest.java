package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testCreate() 
    {
        Stack stc = new Stack();
        assertEquals(true, stc.isEmpty());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekException() 
    {
        Stack stc = new Stack();

        assertEquals(null, stc.peek());
    }
    @Test
    public void testPeek() 
    {
        Stack stc = new Stack();
        stc.push(1);
        stc.push(10);
        assertEquals(10, stc.peek());
    }
    @Test
    public void testPush() 
    {
        Stack stc = new Stack();
        stc.push(1);

        assertEquals(1, stc.peek());
    }

    @Test
    public void testPush2() 
    {
        Stack stc = new Stack();
        stc.push(1);
        stc.push(2);

        assertEquals(2, stc.peek());
    }

    @Test
    public void testPop() 
    {
        Stack stc = new Stack();
        stc.push(1);
        stc.push(2);

        assertEquals(2, stc.pop());
        assertEquals(1, stc.peek());
    }
    @Test
    public void testPopOneElem() 
    {
        Stack stc = new Stack();
        stc.push(1);

        assertEquals(1, stc.pop());
        assertEquals(true, stc.isEmpty());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmpty() 
    {
        Stack stc = new Stack();
        assertEquals(null, stc.pop());
    }
}
