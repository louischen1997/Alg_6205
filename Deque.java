import java.util.ArrayList;
import java.util.Collections;

/**
 * File Name: DequeTest.java
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Deque.java DequeTest.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2022
 */

// Kaiwen Chen 002146255
class Deque {
	//You can use any data structure you want except Deque like ArrayDeque from Java library
	//All operation must be O(1)

	ArrayList<Integer> tmp;
	ArrayList<Integer> reverse;
	int size=0;
	Deque() {tmp=new ArrayList<Integer>();
		reverse=new ArrayList<Integer>();

	}
	
	/*
	 * MUST BE Time:O(1)
	 * MUST BE Space O(1)
	 */
	public void addFirst(Integer v) {
		// simple add is O(1) complexity
		size++;
		if(tmp.size()==0){
			tmp.add(v);
		}
		else{
			reverse.add(v);
		}
	}
	
	/*
	 * MUST BE Time:O(1)
	 * MUST BE Space O(1)
	 */
	public void addLast(Integer v) {
		// simple add is O(1) complexity
		size++;
		tmp.add(v);
	}
	
	/*
	 * MUST BE Time:O(1)
	 * MUST BE Space O(1)
	 */
	public int removeFirst() {
		size--;

		if(reverse.size()!=0){
			// romove from last index is O(1) complexity
			reverse.remove(reverse.size()-1);
		}
		else{
			tmp.remove(0);
		}

		return 0 ; //FILL		
	}
	
	/*
	 * MUST BE Time:O(1)
	 * MUST BE Space O(1)
	 */

	public int removeLast() {

		size--;
		if(tmp.size()==0){
			//special case has to reverse
			Collections.reverse(reverse);
			tmp.addAll(reverse);
			reverse.clear();
		}
		// romove from last index is O(1) complexity
		tmp.remove(tmp.size()-1);
		return 0; //FILL
	}	
	
	/*
	 * MUST BE Time:O(1)
	 * MUST BE Space O(1)
	 */
	public int size() {
		return this.size; //FILL
	}	
	
	/*
	 * MUST BE Time:O(1)
	 * MUST BE Space O(1)
	 * THIS IS THE HEART OF MY INFO 6205
	 * Can you get item at 'pos' in time O(1) and space O(1)
	 * For 100% grade, this must work
	 */
	public int getV(int pos) {
		// get(index) is O(1) complexity
		if(reverse.size()==0){
			return tmp.get(pos);
		}
		else{
			if(pos<reverse.size()){
				return reverse.get(reverse.size()-1-pos);
			}
			else{
				return tmp.get(pos-(reverse.size()));

			}
		}
		  //FILL
	}


	/*************************************************************
	 * ALL PRIVATE ROUTINES BELOW
	 **************************************************************/
	
}