import java.util.ArrayList;

/**
 * File Name: L0322.java 
 */

class Solution { 
	
	public int coinChange(int[] coins, int amount) {
		int [] work = {0} ;
		ArrayList<Integer> ans = new ArrayList<Integer>() ;
		boolean show = false;
		L0322 h = new L0322(coins,amount,ans,work,show);
		int numChange = ans.size() ;
		if (numChange == 1) {
			if (ans.get(0) == -1) {
				numChange = -1 ;
			}
		}
		return numChange;
	}
}


class L0322 {
	private int[] d;
	private int amount ;
	private ArrayList<Integer> ans ;
	private int [] work;
	private boolean show ;
	private int[] m;
	private int[]k;
	private int[][]doublelist;
	
	
	L0322(int[] coins, int amount, ArrayList<Integer> ans, int []work, boolean show) {
		//NOTHING CAN BE CHANGED HERE
		this.d = coins ;
		this.amount =  amount ;
		this.ans = ans;
		this.work = work ;
		this.show = show ;
		//MUST WRITE 2 routines
		alg() ; //1
		getSolution(); //2
		if (show) {
			System.out.println("WORK DONE = "+ work[0]);
		}
	} 

	private void incrementWork() {
		work[0]++ ;
	}

	

	
	private void getSolution() {
		if(show==true) {
			System.out.print("i=      ");
			for (int i = 0; i <= amount; i++) {
				if(i<10){
				System.out.print(" " + i + " ");}
				else if(i>=10&&i<=100){
					System.out.print(" " + i );
				}
			}
			System.out.println(" ");

			System.out.print("m array ");
			for (int i = 0; i <= amount; i++) {
				if(m[i]<10 &&m[i]>=0){
					System.out.print(" " + m[i] + " ");}
				else if(m[i]>=10&&m[i]<=100){
					System.out.print(" " + m[i] );
				}
				else if(m[i]<0){
					System.out.print(  m[i] +" " );
				}
			}
			System.out.println(" ");

			System.out.print("k array ");
			for (int i = 0; i <= amount; i++) {
				if(k[i]<10){
					System.out.print(" " + k[i] + " ");}
				else if(k[i]>=10&&k[i]<=100){
					System.out.print(" " + k[i] );
				}
			}
			System.out.println(" ");
			System.out.println("minimum change for 0 cents can be achieved using 0 coins");

		for(int f=1;f<=amount;f++) {
			int tmpval=0;
			if(doublelist[f][0]!=0){
			System.out.println("minimum change for "+f+" cents can be achieved using "+doublelist[f].length+" coins");}
			else{
				System.out.println("minimum change for "+f+" cents can be achieved using -1 coins");
			}
			for (int y = 0; y < doublelist[f].length; y++) {

				if(doublelist[f][y]!=0){
					tmpval+=doublelist[f][y];
					System.out.println((y+1)+"::Pick coin "+doublelist[f][y]+". Current val= "+tmpval+". Remaining val= "+(f-tmpval));
				}
				else{
					System.out.println("Change cannot be given");
				}
			}
		  }
		}

		else{
			System.out.println("minimum change for "+amount+" cents can be achieved using "+ans.size()+" coins");
		}
	}
	
	private void alg(){
		System.out.print("Give minimum change for "+amount+" cents using coins {");
		for(int l=0;l<d.length;l++){
			if(l!=0 && d.length!=1){
				System.out.print(",");
			}
			System.out.print(+d[l]);
		}
		System.out.println("}");

		m=new int[amount+1];
		k=new int[amount+1];
		doublelist=new int[amount+1][];
		m[0]=0;
		k[0]=0;

		int solution=running(d,amount);

		 if(solution==-1){
			 incrementWork();
			ans.add(-1);
		}

		else {
			if(solution!=0) {
				for (int i = 0; i < doublelist[amount].length; i++) {
					incrementWork();
					ans.add(doublelist[amount][i]);
				}
			}
		}
	}

	private int running(int [] ar, int amount){
		ArrayList<Integer> a=new ArrayList<Integer>();
		if(amount==0){
			return 0;
	}
		double max=Math.pow(2,31)-1;
		int value = (int)max;

		for(int i=1;i<=amount;i++){
			m[i]=value;
			doublelist[i]=new int[]{0};
		}

		for(int i=1; i<=amount; i++){
			for(int c: ar){

				if(i==c){
					m[i]=1;
					doublelist[i]= new int[]{c};
					break;
				}
				else if(i>c){
					if(m[i-c]==value){
						incrementWork();
						continue;
					}
					else{
						if(m[i-c]+1<m[i]){
							a.clear();
							a.add(c);
							for(int j=0;j<doublelist[i-c].length;j++){
								incrementWork();
								a.add(doublelist[i-c][j]);
							}

						m[i]=m[i-c]+1;
							int[] tmp=new int[m[i]];
							for(int k=0;k<m[i];k++){
								incrementWork();
								tmp[k]=a.get(k);
							}
							doublelist[i]=tmp;
						}
					}
				}
			}

			int min=doublelist[i][0];

			for(int z=0;z<doublelist[i].length;z++){
				if(doublelist[i][z]<min){
					min=doublelist[i][z];
				}
			}
			k[i]=min;

		}

		for(int i=0;i<=amount;i++){
			if(m[i]==value){
				m[i]=-1;
			}
		}

		if(m[amount]==-1){
			return -1;
		}
		return m[amount];
	}

	public static void main(String[] args) {
		System.out.println("Run L0322Test.java");
	}
}
