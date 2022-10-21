/**
 * File Name: Stock1.java 
 * Stock1 concrete class
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Stock1.java Stock1Base.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class Stock1 extends Stock1Base{
	//You can have any number of private data members here
	//You can have any number of private functions here
	Stock1() {
		//NOTHING CAN BE CHANGED HERE
		testBed() ;
	}
	
	@Override
	void NSquareTimeConstantSpace() {
		//NOTHING CAN BE CHANGED HERE
    	nsquareTimeConstantSpace() ;
	}
	
	@Override
  void NlognTimeLognSpace() {
		//NOTHING CAN BE CHANGED HERE
    	nlognTimelognSpace() ;
	}
	
	@Override
  void NTimeLognSpace() {
		//NOTHING CAN BE CHANGED HERE
    	nTimelognSpace() ;
	}
	void NTimeConstantSpace() {
		//NOTHING CAN BE CHANGED HERE
		nTimeConstantSpace() ;
	}

	
	/*
	 * Time: O(n^2)
	 * Space: THETA(1)
	 * All your routine should match this answer
	 * Nothing can be changed in this routine
	 */
	private void nsquareTimeConstantSpace() {
		int gp = 0 ;
		int l = size() ;
		for (int buy = 0; buy < l-1; ++buy) {
			for (int sell = buy + 1; sell < l; ++sell) {
				++numConquer;
				int p = profit(sell,buy);
				if (p >= gp) { //So that I can make profit by keeping stock for less time
					gp = p ;
					buyDay = buy ;
					sellDay = sell ;
				}
			}
		}
	}
	
	/*
	 * Time: O(nlogn)
	 * Space: O(logn)
	 */

	private void nlognTimelognSpace() {
		//must write the routine. UNTIL YOU WRITE UNCOMMENT BELOW
    	//nsquareTimeConstantSpace();
		int l = size() ;
		returnmax(0,l-1);
	}

	private int returnmax(int x, int y){

		if(x-y+1==1){
			return 0;
		}
		else{
			++numDivide;
			int indexmin=x;
			int indexmax=y;
			int min=price(x);
			int max=price((x+y)/2+1);
            int one=returnmax(x,(x+y)/2);
		    int two=returnmax((x+y)/2+1,y);

            for(int i=x;i<=((x+y)/2);i++){
				++numConquer;
				int tmp=price(i);
				if(tmp<=min){
					min=tmp;
					indexmin=i;
				}
			}
			for(int i=((x+y)/2)+1;i<=y;i++){
				++numConquer;
				int tmp=price(i);
				if(tmp>=max){
					max=tmp;
					indexmax=i;
				}
			}
			int three=max-min;
			int re=one;
            int[] array=new int[3];
			array[0]=one;
			array[1]=two;
			array[2]=three;
			for(int i=0;i<3;i++){
				++numConquer;
				int tmp=array[i];
				if(tmp>=re){
					re=tmp;
				}
			}

			if(re==0){
				buyDay = x ;
				sellDay = x ;
				return re;

			}
			if(re==one){
				int tmpmin=price((x+y)/2);
				int tmpmax=price(x);
				int indexminone=(x+y)/2;
				int indexmaxone=x;
                for (int i=(x+y)/2;i>=x;i--){
					++numConquer;
					if(price(i)<=tmpmin){
					tmpmin=price(i);
					indexminone=i;}

				}
				for (int i=x;i<=(x+y)/2;i++){
					++numConquer;
					if(price(i)>=tmpmax){
					tmpmax=price(i);
					indexmaxone=i;}
				}
				buyDay = indexminone ;
				sellDay = indexmaxone ;

			}
			if(re==two){
				int tmpmin=price(y);
				int tmpmax=price((x+y)/2+1);
				int indexmintwo=y;
				int indexmaxtwo=(x+y)/2+1;
				for (int i=y;i>=(x+y)/2+1;i--){
					++numConquer;
					if(price(i)<=tmpmin){
					tmpmin=price(i);
					indexmintwo=i;}
				}
				for (int i=(x+y)/2+1;i<=y;i++){
					++numConquer;
					if(price(i)>=tmpmax){
					tmpmax=price(i);
					indexmaxtwo=i;}
				}
				buyDay = indexmintwo ;
				sellDay = indexmaxtwo ;

			}
			if(re==three){
				buyDay = indexmin ;
				sellDay = indexmax ;
			}
			return re;
		}
	}
	
	/*
	 * Time: O(n)
	 * Space: O(logn)
	 */

	private void nTimelognSpace() {
		//must write the routine. UNTIL YOU WRITE UNCOMMENT BELOW
	    //nsquareTimeConstantSpace();
		int l = size() ;
		returnmaxarray(0,l-1);
	}

	private int[] returnmaxarray(int x, int y){

		int[] re=new int[3];
		if(x-y+1==1){
			re[0]=0;
			re[1]=price(x);
			re[2]=price(y);
			return re;
		}
		else{
			++numDivide;
			int []left=returnmaxarray(x,(x+y)/2);
			int []right=returnmaxarray((x+y)/2+1,y);
			int indexmin=x;
			int indexmax=y;
			int min=price(x);
			int max=price((x+y)/2+1);

			for(int i=x;i<=((x+y)/2);i++){
				++numConquer;
				int tmp=price(i);
				if(tmp<=min){
					min=tmp;
					indexmin=i;
				}
			}
			for(int i=((x+y)/2)+1;i<=y;i++){
				++numConquer;
				int tmp=price(i);
				if(tmp>=max){
					max=tmp;
					indexmax=i;
				}
			}

			int three=right[2]-left[1];
			int max_profit=left[0];

			int[] tmparray=new int[3];
			int fmin=left[1];
			int fmax=right[2];


			tmparray[0]=left[0];
			tmparray[1]=right[0];
			tmparray[2]=three;
			for(int i=0;i<3;i++){
				++numConquer;
				int tmp=tmparray[i];
				if(tmp>=max_profit){
					max_profit=tmp;
				}
			}

			if(left[1]>right[1]){
				fmin=right[1];
			}
			if(left[2]>right[2]){
				fmax=left[2];
			}
			re[0]=max_profit;
			re[1]=fmin;
			re[2]=fmax;
            if(re[0]==0){
				buyDay=x;
				sellDay=x;
				return re;
			}

			if(re[0]==left[0]){
				int tmpmin=price((x+y)/2);
				int tmpmax=price(x);
				int indexminone=(x+y)/2;
				int indexmaxone=x;
				for (int i=(x+y)/2;i>=x;i--){
					++numConquer;
					if(price(i)<=tmpmin){
						tmpmin=price(i);
						indexminone=i;}

				}
				for (int i=x;i<=(x+y)/2;i++){
					++numConquer;
					if(price(i)>=tmpmax){
						tmpmax=price(i);
						indexmaxone=i;}
				}
				buyDay = indexminone ;
				sellDay = indexmaxone ;

			}
			if(re[0]==right[0]){
				int tmpmin=price(y);
				int tmpmax=price((x+y)/2+1);
				int indexmintwo=y;
				int indexmaxtwo=(x+y)/2+1;
				for (int i=y;i>=(x+y)/2+1;i--){
					++numConquer;
					if(price(i)<=tmpmin){
						tmpmin=price(i);
						indexmintwo=i;}
				}
				for (int i=(x+y)/2+1;i<=y;i++){
					++numConquer;
					if(price(i)>=tmpmax){
						tmpmax=price(i);
						indexmaxtwo=i;}
				}
				buyDay = indexmintwo ;
				sellDay = indexmaxtwo ;


			}
			if(re[0]==three){
				buyDay = indexmin ;
				sellDay = indexmax ;
			}

			return re;

		}
	}
	/*
	 * Time: O(n)
	 * Space: O(1)
	 */


    private void nTimeConstantSpace() {
		//IF YOU CANNOT WRITE USE THE ROUTINE BELOW
	    nsquareTimeConstantSpace();
    }


	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("Stock1 problem STARTS");
		Stock1 m = new Stock1() ;
		System.out.println("All Stock1 tests passed. Now you can pass interviews");
		System.out.println("Stock1 problem ENDS");
	}
}
