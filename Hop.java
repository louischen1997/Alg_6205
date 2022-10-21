/**
 * File Name: Hop.java 
 * Hop concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Hop.java HopBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Hop extends HopBase{
	//You cannot have any functions or data here
	Hop() {
		//NOTHING CAN BE CHANGED HERE
		testBed();
	}
	
	@Override
  int hopSmart(int [] s, int x) {
		//NOTHING CAN BE CHANGED HERE
    return alg(s,x) ;
	}

	/*
	 * WRITE CODE IN alg
	 *  YOU CANNOT USE ANY static variable in this function
	 *  YOU can use many local variables inside the function
	 *  Cannot use any loop statements like:  for, while, do, while, go to
	 *  Can use if
	 *  ONLY AFTER THE execution of this routine array s MUST have the same contents as you got it.
	 *  YOU cannot call any subroutine inside this function except alg itself 
	 *  
	 */

	private int alg(int [] s, int x) {
		//WRITE CODE
		//If your code is more than 10 lines, you don't understand the problem

		if(s[x]==x){return 0;}
		else if(s[x]==-1){return -1;}
		else{
			int tmp=s[x];
			s[x]=-1;
			int re=alg(s,tmp);
			s[x]=tmp;
			return re+1;
		}
	}
	
	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Hop problem STARTS");
		Hop m = new Hop() ;
		System.out.println("All Hop tests passed. You are great");
		System.out.println("Include a doc that shows stack trace of {5,1,0,4,2,3}");
		System.out.println("Hop problem ENDS");
	}
}