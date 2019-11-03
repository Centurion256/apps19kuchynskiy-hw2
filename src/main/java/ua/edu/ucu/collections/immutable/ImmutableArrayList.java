package ua.edu.ucu.collections.immutable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.StringJoiner;

public final class ImmutableArrayList implements ImmutableList
{
    private Object[] array;

    public ImmutableArrayList()
    {
        this.array = new Object[0];
    }
    public ImmutableArrayList(Object[] initial)
    {
        this.array = initial.clone();
    }
    public ImmutableArrayList copyOf()
    {
        try 
        {      
              ByteArrayOutputStream exportedData = new ByteArrayOutputStream();
              ObjectOutputStream exportedObject = new ObjectOutputStream(exportedData);
              
              exportedObject.writeObject(this); //Serialize an instance of Immutable list.

              //create a new byte array and store the contents of the stream in it
              ByteArrayInputStream importedData = new ByteArrayInputStream(exportedData.toByteArray());
              //Turn it into an object
              ObjectInputStream importedObject = new ObjectInputStream(importedData);
              return (ImmutableArrayList) importedObject.readObject(); //read the deserialized object
        }
        catch (Exception e)
        {
              e.printStackTrace();
              return null;
        }
    }
    private boolean isAValidIndex(int i)
    {
          return (i >= 0) && (i <= this.array.length); 
    }

    @Override
    public ImmutableArrayList add(Object e)
    {
        return this.add(this.array.length, e);
    }
    @Override
    public ImmutableArrayList add(int index, Object e)
    {
        if (!isAValidIndex(index))
        {
              throw new IndexOutOfBoundsException();
        }
        //ImmutableArrayList newObject = this.copyOf();
        Object[] newArray = new Object[this.array.length + 1];
        //Copy all elements until a certain index.
        System.arraycopy(this.array, 0, newArray, 0, index);
        //Set the element with appropriate index to the desired value
        newArray[index] = e;
        //Continue copying the array from that index
        System.arraycopy(this.array, index, newArray, index+1,
                this.array.length - index);
        //this.array = newArray;
        //had to replace a copy with the following construct:
        return new ImmutableArrayList(newArray);
    }
    @Override
    public ImmutableArrayList addAll(Object[] c)
    {
        return this.addAll(this.array.length, c);
    }
    @Override
    public ImmutableArrayList addAll(int index, Object[] c)
    {
        //Perhaps there is a way to implement add via addAll, but
        //I haven't figured that out yet.
        
        //ImmutableArrayList newObject = this.copyOf();
        Object[] newArray = new Object[this.array.length + c.length];
        System.arraycopy(this.array, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(this.array, index, newArray, index+c.length,
                this.array.length - index);

        //this.array = newArray;
        return new ImmutableArrayList(newArray);
    }
    @Override
    public Object get(int index)
    {
        return this.array[index];
    }
    @Override
    public ImmutableList remove(int index)
    {
        if (!isAValidIndex(index))
        {
            throw new IndexOutOfBoundsException();
        }
        //ImmutableArrayList newObject = this.copyOf();
        Object[] newArray = new Object[this.array.length - 1];
        System.arraycopy(this.array, 0, newArray, 0, index);
        //Skip the index item
        System.arraycopy(this.array, index + 1, newArray, index,
                this.array.length - index - 1);

        //this.array = newArray;
        return new ImmutableArrayList(newArray);
    }
    @Override
    public ImmutableList set(int index, Object e)
    {
        //ImmutableArrayList newObject = this.copyOf();
        if (!isAValidIndex(index))
        {
            throw new IndexOutOfBoundsException();
        }
        //ImmutableArrayList newObject = this.copyOf();
        Object[] newArray = this.array.clone();
        newArray[index] = e;
        return new ImmutableArrayList(newArray);
    }
    @Override
    public int indexOf(Object e)
    {
        for (int i = 0; i < this.array.length; i++)
        {
            if (this.array[i] == e)
            {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int size()
    {
        return this.array.length;
    }
    @Override
    public ImmutableArrayList clear()
    {
        return new ImmutableArrayList();
    }
    @Override
    public boolean isEmpty()
    {
        return this.array.length == 0;
    }
    @Override
    public Object[] toArray()
    {
        return this.array.clone();
    }
    @Override
    public String toString()
    {
        StringJoiner strJoiner = new StringJoiner(", ");
        for (Object object : this.array) 
        {
              strJoiner.add(object.toString());
        }
        return strJoiner.toString();
    }

}
