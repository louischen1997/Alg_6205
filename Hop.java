/**
 * File Name: Hop.java 
 * Hop concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Hop.java HopBase.java
 */

class Hop extends HopBase{
	
	Hop() {
		
		testBed();
	}
	
	@Override
  int hopSmart(int [] s, int x) {
		
    return alg(s,x) ;
	}


	private int alg(int [] s, int x) {
		

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
