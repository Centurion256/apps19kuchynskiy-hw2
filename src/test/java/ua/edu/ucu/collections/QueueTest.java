package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testCreate() 
    {
        Queue stc = new Queue();
        assertEquals(true, stc.isEmpty());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekException() 
    {
        Queue stc = new Queue();

        assertEquals(null, stc.peek());
    }
    @Test
    public void testPeek() 
    {
        Queue stc = new Queue();
        stc.enqueue(1);
        stc.enqueue(10);
        assertEquals(1, stc.peek());
    }
    @Test
    public void testenqueue() 
    {
        Queue stc = new Queue();
        stc.enqueue(1);

        assertEquals(1, stc.peek());
    }

    @Test
    public void testenqueue2() 
    {
        Queue stc = new Queue();
        stc.enqueue(1);
        stc.enqueue(2);

        assertEquals(1, stc.peek());
    }

    @Test
    public void testDequeue() 
    {
        Queue stc = new Queue();
        stc.enqueue(1);
        stc.enqueue(2);

        assertEquals(1, stc.dequeue());
        assertEquals(2, stc.peek());
    }
    @Test
    public void testdequeueOneElem() 
    {
        Queue stc = new Queue();
        stc.enqueue(1);

        assertEquals(1, stc.dequeue());
        assertEquals(true, stc.isEmpty());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testdequeueEmpty() 
    {
        Queue stc = new Queue();
        assertEquals(null, stc.dequeue());
    }
    
}
