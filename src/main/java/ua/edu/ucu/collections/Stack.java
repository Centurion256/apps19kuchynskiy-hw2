package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.ImmutableList;

public class Stack 
{
    private ImmutableLinkedList top;

    public Stack()
    {
        this.top = new ImmutableLinkedList();
    }
    
    public void push(Object e)
    {
        this.top = this.top.addFirst(e);
    }
    public Object peek() throws IndexOutOfBoundsException
    {
        return this.top.getFirst();
    }
    public Object pop()
    {
        Object peak = this.peek();
        this.top = this.top.removeFirst();
        return peak;
    }
    public boolean isEmpty()
    {
        try
        {
            this.peek();
            return false;
        } 
        catch (IndexOutOfBoundsException e)
        {
            return true;
        }
    }
    
}
