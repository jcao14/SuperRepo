public class Rational implements Comparable{
    public int numerator;
    public int denominator;
    
    public Rational() {
        numerator = 0;
        denominator = 1;
    }
    
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("STOP DIVIDING BY 0!!!!!!!");
            this.denominator = 1;
            this.numerator = 0;
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public float floatValue(){
        return this.numerator / this.denominator;
    }

    
    public void multiply(Rational other) {
        this.numerator *= other.numerator;
        this.denominator *= other.denominator;
    }
    
    public void divide(Rational other) {
    	if (other.numerator == 0) {
        	this.numerator *= other.denominator;
        	this.denominator *= other.numerator;
    	} else {
	    System.out.println("Cannot divide by 0.");
    	}
    }
    
    public int getNum(){
        return numerator;
    }
    
    public int getDem(){
        return denominator;
    }

  /*=====================PHASE 2=====================*/

     public void add(Rational other){
	 this.numerator *= other.denominator;
	 this.numerator += (other.numerator * this.denominator);
	 this.denominator *= other.denominator;
     }

     public void subtract(Rational other){
	 this.numerator *= other.denominator;
	 this.numerator -= (other.numerator * this.denominator);
	 this.denominator *= other.denominator;
     }

     public int gcdEW(){
	 int gcd = 0;
	 int a = this.numerator;
	 int b = this.denominator;
	     if (a == 0){
		 return b;
	     }
	 while (a != 0 || b != 0){
	     if (a > b) {
		 if (a % b == 0){
		     gcd = b;
		 }
		 a = a % b;
	     }
	     else {
		 if ( b % a == 0){
		     gcd = a;
		 }
		 b = b % a;
	     }
	 }
	 return gcd;
     }

     public void reduce(){
	 int gcd = gcdER(this.numerator, this.denominator);
	 this.numerator /= gcd;
	 this.denominator /= gcd;
     }

     /*=====================PHASE 3=====================*/
     public static int gcdER (int a, int b){
	 if ((a == b) || (b == 0)){
	     return a;} //returns the GCD.
	 else if (a < b){
	     return gcdER (b,a);} //If b is greater than a, the function will be run again with both values swapped.
	 else{
	     return gcdER (b , (a-b));
	 }
     }
     
     
    public int compareTo( Object o ) {
     if (!(o instanceof Comparable)) {
        throw new ClassCastException("Argument to compareTo is not " + 
              "an instanceof Comparable");
      }
      
      if (o == null) {
        throw new NullPointerException ("NULLWAYYYYYY");
      }
      

       if ((numerator % denominator == 0) ){
            int a = numerator / denominator;
   
           
        if (o instanceof Hexadecimal ) {
          Hexadecimal thisH = new Hexadecimal (a);
          Hexadecimal other = (Hexadecimal) o;
          
          if (thisH.getDecH() == other.getDecH() ) {
            return 0;}
            return -1;
        }
        
          if (o instanceof Binary ) {
          Binary thisB = new Binary (a);
          Binary other = (Binary) o;
          if (thisB.getDecB() == other.getDecB()) {
            return 0;}
            return -1;
          
        }
           
       }
       
        else  {
          Rational other = (Rational) o;
          int diff = this.numerator*other.denominator - other.numerator*this.denominator;
           if (diff == 0){
                return 0;
             }
            return -1;
       }
        return -1;
        
    }
      

    


    /*=====================PHASE 4=====================*/
    public boolean equals(Object other){
	boolean retboo = this == other;
	if (!retboo) {
	    retboo = (other instanceof Rational && ((this).compareTo((Rational)other))==0);
	}
	return retboo;
    }

    public static void main(String[] args) {
        Rational r = new Rational(1, 1);
        Hexadecimal s = new Hexadecimal("F");
	Rational t = new Rational(14, 40);
	System.out.println ("Fraction 1:\t" + r);
	System.out.println ("Fraction 2:\t"+ s);
	System.out.println ("Fraction 3:\t" +t);
    System.out.println("Comparing Fraction 2 to Fraction 1:\t" + r.compareTo(s)); //should return -13
	System.out.println("Checking to see if Fraction 2 is equal to Fraction 1\t" + s.equals(r)); // should return false
	System.out.println("Checking to see if Fraction 2 is equal to Fraction 3\t" + s.equals(t)); //should return true
    }
}
