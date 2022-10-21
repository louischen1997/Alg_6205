
/**
 * File Name: L0066.java 
 * @author Jagadeesh Vasudevamurthy
 * @year 2022
 */

/************************************************************
 * CUT AND PASTE ENTIRE FILE IN LEETCODE
 *************************************************************/
class SolutionL0066 { 
	//In LEETCODE SolutionL0066 changed to Solution
	//Nothing can be changed below
	//LEETCODE VERSION
	  public int[] plusOne(int[] digits) {
		int [][] ans = new int [1] [] ;
		int [] work = {0} ;


		L0066 a = new L0066(digits,ans,work);
		//System.out.println(ans[0][4]);
		//System.out.println("test");
		return ans[0] ;
	}
}

class L0066 {
	private int[] a;
	private int[][] ans;
	private int[] work;
	//YOU CAN HAVE ANY NUMBER OF PRIVATE VARIABLES and FUNCTIONS
	
	L0066(int[] a, int[][] ans, int[] work) {
		this.a = a ;
		this.ans = ans ;
		this.work = work ;
		alg();
	} 

	/*-----------------  WRITE CODE BELOW ---------------------------------*/

	private void alg() {
		int n = a.length ;
		for (int i=n-1;i>=0;i--){

			if(a[i]<9){
				a[i]++;
				ans[0]=a;
				work[0]++;
				break;
			}
			a[i]=0;
			int[] newarr=new int[a.length+1];
			newarr[0]=1;
			ans[0]=newarr;
			work[0]++;
		}

		//WRITE CODE


	}

	public static void main(String[] args) {
		//int [] myarray={9,9,9};
		//SolutionL0066.plusOne( myarray );

		System.out.println("Run L0066Test.java");
	}
}


