public class SuperArray  {

    //~~~~~INSTANCE VARS~~~~~
    //underlying container, or "core" of this data structure:
    private Comparable[] _data;

    //position of last meaningful value
    private int _lastPos;

    //size of this instance of SuperArray
    private int _size;


    //~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_data = new Comparable[10];
	_lastPos = -1; //flag to indicate no lastpos yet
	_size = 0;
    }


    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String retStr = "[";
	for( int i = 0; i < _size; i++ ) {
	    retStr += _data[i] + ",";
	}
	//shave off trailing comma
	if ( retStr.length() > 1 )
	    retStr = retStr.substring( 0, retStr.length()-1 );
	retStr += "]";
	return retStr;
    }


    //double capacity of this SuperArray
    private void expand() {
	Comparable[] temp = new Comparable[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor -- return value at specified index
    public Comparable get( int index ) { return _data[index]; }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public Comparable set( int index, Comparable newVal) {
 	Comparable temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
    //adds an item after the last item
    public void add( Comparable newVal ) {
	if (_size == _data.length)
	    expand();

	_lastPos += 1;
	_size += 1;
	_data[_lastPos] = newVal;
    }


    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, Comparable newVal ) {
	if (index < _size && index > -1) {
	    for (int i = _lastPos; i > index - 1; i--) {
	        _data[i + 1] = _data[i];
	    }
	    _data[index] = newVal;
	    _lastPos++;
	    _size++;
	}
	else
	    System.out.println("error: index out of range");
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) {
        if (index < _size && index > -1) {
	    for (int i = index; i < _lastPos; i++) {
		_data[i] = _data[i+1];
	    }
	    _data[_lastPos] = null;
	    _lastPos--;
	    _size--;
	}
	else
	    System.out.println("error: index out of range");
    }


    //return number of meaningful items in _data
    public int size() { return _size; }
    
	public int linSearch (Comparable x){
		int index = -1;
			for (int i = 0; _data[i] instanceof Comparable; i++){
				System.out.println ("The Comprable is + " + _data[i]);
				if(x.compareTo(_data[i]) == 0){
					index = i;
				}
			}
		return index;}

	public boolean isSorted() {
		for (int i=1; _data[i] instanceof Comparable; i++){
			if (!(_data[i -1].compareTo (_data[i]) < 0)){
				return false;
			}
		}
		return true;
	}

    

	
	
	
		
	
    //main method for testing
    public static void main( String[] args ) {
	

	SuperArray mayfield = new SuperArray();
	//===============================================//
	
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	//Test Add Methods
	mayfield.add(new Rational (5, 1));
	mayfield.add(new Binary (8));
	mayfield.add(new Hexadecimal (16));
	mayfield.add(new Binary (56));
	mayfield.add(new Rational (6, 2));

	
	
	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	
	
	//Test Remove Method
	mayfield.remove(3);
	System.out.println("Printing ListInt mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing ListInt mayfield post-remove...");
	System.out.println(mayfield); 

	
	//Test Add-at-Index
	mayfield.add(2,new Binary (56));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,new Binary (58));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,new Binary (57));
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	
	
	//Test Size 
	System.out.println("Printing ListInt mayfield size");
	System.out.println (mayfield.size());
	
	//isSorted Test


	//linSearch Test
	System.out.println (mayfield.linSearch (new Binary(8)));
	System.out.println( mayfield.isSorted());

    }//end main

}//end clas
