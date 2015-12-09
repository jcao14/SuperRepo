public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	    _decNum = 0;
	    _hexNum = "0";   
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of hexadecimals
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHexadec (n);  
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative Hexadecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	  _hexNum = s;
	  _decNum = hexadecToDec (s);
 
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return this._hexNum;  
    }


    /*=====================================
      String decToHexadec(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of hexadecimals
      eg  decToHexadec(0) -> "0"
      decToHexadec(1) -> "1"
      decToHexadec(15) -> "F"
      decToHexadec(26) -> "1A"
      decToHexadec(31) -> "1F"
      =====================================*/
    public static String decToHexadec( int n ) {
    	int new_dec = n;
    	String Hexadec = "";
    
    	while (new_dec != 0){
         Hexadec = Character.toString(HEXDIGITS.charAt(new_dec % 16)) + Hexadec;
         	new_dec /= 16;
    	}
  	return Hexadec;
    }


    /*=====================================
      String decToHexadecR(int) -- converts base-10 input to Hexadecimal, recursively
      pre:  n >= 0
      post: returns String of hexadecimals
      eg  decToHexadecR(0) -> "0"
      decToHexadecR(1) -> "1"
      decToHexadecR(15) -> "F"
      decToHexadecR(26) -> "1A"
      decToHexadecR(31) -> "1F"
      =====================================*/
      public static String decToHexadecR( int n ) { 
          if (n/16 == 0){
              return Character.toString(HEXDIGITS.charAt(n % 16));
          } else {
              return decToHexadecR(n/16) + Character.toString(HEXDIGITS.charAt(n % 16));
          }
   }


    /*=====================================
      String hexadecToDec(String) -- converts base-10 input to Hexadecimal
      pre:  s represents non-negative Hexadecimal number
      post: returns String of hexadecimals
      eg  
      hexadecToDec("1") -> 1
      hexadecToDec("F") -> 15
      hexadecToDec("1A") -> 26
      hexadecToDec("1F") -> 31
      =====================================*/
    public static int hexadecToDec( String s ) {
	    int hex_length = s.length()-1;
      int _hexNum = 0;
    	for (int i=0; i<= hex_length; i++){
	      _hexNum += HEXDIGITS.indexOf(s.substring(i,i+1)) * Math.pow(16,(hex_length-i));
	    }
	    return _hexNum;
		
      }


    /*=====================================
      String hexadecToDecR(String) -- converts base-10 input to Hexadecimal, recursively
      pre:  s represents non-negative Hexadecimal number
      post: returns String of hexadecimals
      eg  
      hexadecToDecR("1") -> 1
      hexadecToDecR("F") -> 15
      hexadecToDecR("1A") -> 26
      hexadecToDecR("1F") -> 31
      =====================================*/
   public static int hexadecToDecR( String s ) { 
	    if (s.length()==1){
	      return HEXDIGITS.indexOf(s);}
	    else{
	      return HEXDIGITS.indexOf(s.substring(0,1)) * (int)Math.pow(16,(s.length()-1)) + hexadecToDecR (s.substring (1));
      }
	   }
  


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal Hexadecimal values
      =============================================*/

    public boolean equals( Object other ) { 
      boolean retBoo = this == other;
      if (!retBoo){
        retBoo = (other instanceof Hexadecimal && ((this).compareTo((Hexadecimal)other))==0);}
        return retBoo;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
 
    public int compareTo( Object other ) {
        if (other instanceof Hexadecimal ) {
            Hexadecimal o = (Hexadecimal)other;
            return _decNum - o._decNum;
        }
        throw new ClassCastException("Argument to compareTo is not " +
            "an instanceof Hexadecimal");
    }
      

    //main method for testing
    public static void main( String[] args ) {

	
	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(31);
	Hexadecimal b2 = new Hexadecimal(31);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(15);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be pos
	System.out.println( b4.compareTo(b1) ); //should be neg

    }//end main()

} //end class
