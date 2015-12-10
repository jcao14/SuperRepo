public interface ListInt{
    
    //Pre: input is an integer
    //Post: adds input to the end of the int array
    void add (Comparable item);

    //Pre: inputs are both integers
    //Post: adds an item to the specified index of an int array. Returns error if index is greater than length of int array.
    void add (int index, Comparable item); 

    //Pre: input is an integer
    //Post: removes an item at a given index of an int array.
    void remove (int index);
    
    //Pre:
    //Post: returns to the size of an array.
    int size ();
    
    //Pre: input is an integer
    //Post: returns the item at the specified index of the array.
    Object get(int index);

    //Pre: inputs are both integers
    //Post: changes the item at the specified index of an array to the specified item.
    Object set (int index, Comparable item);
    
    int linSearch (Comparable x);

}
