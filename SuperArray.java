public class SuperArray implements ListInt {

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
			for (int i = 0; i < _data.length; i++){
				if(x.compareTo (_data[i]) == 0){
					index = i;
				}
			}
		return -1;}


		
		
	
	
		
	
    //main method for testing
    public static void main( String[] args ) {
	

	ListInt leche = new SuperArray();
	System.out.println("Printing empty LastInt leche...");
	System.out.println(leche);

	Rational a = new Rational (5,10);
	Binary b = new Binary (10);
	Hexadecimal c = new Hexadecimal("F");
	Binary d = new Binary ("1110");
	Hexadecimal e = new Hexadecimal ("31");
	
	leche.add(a);
	leche.add(b);
	leche.add(c);
	leche.add(d);
	leche.add(e);

	System.out.println("Printing populated ListInt leche...");
	System.out.println(leche);

	leche.remove(3);
	System.out.println("Printing ListInt leche post-remove...");
	System.out.println(leche);
	leche.remove(3);
	System.out.println("Printing ListInt leche post-remove...");
	System.out.println(leche);

	Binary f = new Binary ("0");
	Hexadecimal g = new Hexadecimal("2F");
	Rational h = new Rational (1,3);
	
	leche.add(3,f);
	System.out.println("Printing ListInt leche post-insert...");
	System.out.println(leche);
	leche.add(1,g);
	System.out.println("Printing ListInt leche post-insert...");
	System.out.println(leche);
	leche.add(1,h);
	System.out.println("Printing ListInt leche post-insert...");
	System.out.println(leche);

	System.out.println("Printing value at index 2");
	System.out.println(leche.get(2));

	Hexadecimal i = new Hexadecimal ("A");
	System.out.println("Setting value at index 2 to A");
	leche.set(2,i);
	System.out.println(leche);

	System.out.println("Printing the size of leche");
	System.out.println(leche.size());
	
	Comparable j = new Binary (64);
	System.out.println(leche.linSearch(j));

    }//end main

}//end clas
