


class SolutionL0066 { 
	
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
	
	
	L0066(int[] a, int[][] ans, int[] work) {
		this.a = a ;
		this.ans = ans ;
		this.work = work ;
		alg();
	} 

	

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

	}

	public static void main(String[] args) {
		//int [] myarray={9,9,9};
		//SolutionL0066.plusOne( myarray );

		System.out.println("Run L0066Test.java");
	}
}


