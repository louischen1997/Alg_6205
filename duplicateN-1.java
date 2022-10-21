import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;



/**
 * File Name: duplicateN.java 
 */

class duplicateN{
	private int[] a ; //a[i] guaranteed > 0 && < n-1
	//contents of a should be exactly like the original after your algorithms
	private String algName ;
	private int [] numDup ;
	private double [] work ;
	private boolean show ; //show only is show = true
		
	duplicateN(int[] a, String algName,int [] numDup,double [] work, boolean show) {
		this.a = a ;
		this.algName = algName;
		this.numDup = numDup;
		this.work = work ;
		this.show = show ;
		AlgduplicateN b = new AlgduplicateN(this,algName,show) ;
	}
	
	public int size() {
		return a.length ;
	}
	public int getI(int i) {
		work[0]++ ;
		return a[i];
	}
	public void setI(int i, int v) {
		work[0]++ ;
		a[i] = v ;
	}
	
	public void setnumDup(int v) {
		numDup[0] = v ;
	}
}


class AlgduplicateN {
		private duplicateN f;
		private String algName;
		private boolean show ; //show only is show = true

		AlgduplicateN(duplicateN f, String algName, boolean show) {
			//NOTHING CAN BE CHANGED HERE
			this.f = f ;
			this.show = show;
			if (algName == "NsquareTimeConstantSpace") {
				alg_nsquare_time_constant_space();
			}else if (algName == "NTimeNSpace") {
				//alg_nsquare_time_constant_space();
				alg_ntime_n_space();
			}else if (algName == "NTimeConstantSpace") {
				//alg_nsquare_time_constant_space();
				alg_ntime_constant_space();
			}
		}


		/*
		 * Time complexity O(n^2)
		 * Space Complexity O(1)
		 */
		private void alg_nsquare_time_constant_space() {
			int[] solution;
			solution = new int[f.size() / 2];
			boolean dup = false;
			int count = 0;
			for (int i = 0; i < f.size(); i++) {
				for (int k = 0; k < count; k++) {
					if (solution[k] == f.getI(i)) {
						dup = true;
					}
				}
				if (dup == false) {
					for (int j = i + 1; j < f.size(); j++) {

						if (f.getI(i) == (f.getI(j))) {
							solution[count] = f.getI(i);
							count++;
							break;
						}
					}
				}
				dup=false;
			}
			f.setnumDup(count);
			String stringans="{";
			if(show==true){
				for(int p=0;p<count;p++){
					if(p==count-1){
						stringans=stringans+solution[p];
					}
					else {
						stringans = stringans + solution[p] + ",";
					}
				}
				stringans+="}";
				System.out.println("duplicate: "+stringans);
				System.out.println("Num duplicates= "+count);
			}

		}


		/*
		 * Time complexity O(n)
		 * Space Complexity O(n)
		 */
		private void alg_ntime_n_space() {
			long [] solution;
			int[] print=new int[10];

			solution=new long[f.size()];
			for(int i=0;i<f.size();i++){
				solution[i]=f.getI(i);
			}

			int count=0;
			for (int j = 0; j < f.size(); j++)
			{
				int c = f.getI(j) % f.size();
				solution[c]+=f.size();
			}


			for (int k = 0; k < f.size(); k++)
			{
				if ((solution[k] / f.size()) >= 2){
					if(show==true){
						print[count]=k;
					}
					count++;
				}
			}
			f.setnumDup(count);
			String stringans="{";
			if(show==true){
				for(int p=0;p<count;p++){
					if(p==count-1){
						stringans=stringans+print[p];
					}
					else {
						stringans = stringans + print[p] + ",";
					}
				}
				stringans+="}";
				System.out.println("duplicate: "+stringans);
				System.out.println("Num duplicates= "+count);
			}
		}
		/*
		 * Time complexity O(n)
		 * Space Complexity O(1)
		 */
		private void alg_ntime_constant_space() {
			int count=0;
			int[] print=new int[10];

			for (int j = 0; j < f.size(); j++)
			{
				int c = f.getI(j) % f.size();
				if(f.getI(c)<0||f.getI(c)+f.size()<0){
					f.setI(c,f.size()-1);
					count++;
					break;
				}
				f.setI(c,f.getI(c)+f.size());
			}

			for (int k = 0; k < f.size(); k++)
			{
				if ((f.getI(k) / f.size()) >= 2){

					if(show==true){
						print[count]=k;
					}
					count++;

				}
				f.setI(k,f.getI(k)%f.size());

			}

			f.setnumDup(count);
			String stringans="{";
			if(show==true){
				for(int p=0;p<count;p++){
					if(p==count-1){
						stringans=stringans+print[p];
					}
					else {
						stringans = stringans + print[p] + ",";
					}
				}
				stringans+="}";
				System.out.println("duplicate: "+stringans);
				System.out.println("Num duplicates= "+count);
			}


		}


	public static void main(String[] args) {
		System.out.println("Run duplicateNTest.java");

	}
}
