import java.util.ArrayList;
import java.util.Collections;

/**
 * File Name: DequeTest.java
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java Deque.java DequeTest.java
 * 
 */

// Kaiwen Chen 002146255
class Deque {
	

	ArrayList<Integer> tmp;
	ArrayList<Integer> reverse;
	int size=0;
	Deque() {tmp=new ArrayList<Integer>();
		reverse=new ArrayList<Integer>();

	}
	
	
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
	
	public void addLast(Integer v) {
		// simple add is O(1) complexity
		size++;
		tmp.add(v);
	}
	
	
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
	
	public int size() {
		return this.size; //FILL
	}	
	
	
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
		  
	}
	
}
