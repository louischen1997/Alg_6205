
/**
 * File Name: SlistSort.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */
/*
 * To compile you require: IntUtil.java RandomInt.java Slist2.java SlistSort.java
 */

public class SlistSort {
	private Slist2 s;
	private int[] work ;
	private boolean show ;
	private static IntUtil u = new IntUtil();
  //You cannot add any variables to this class 
	
	SlistSort(Slist2 s,String method,int[] work, boolean show) { 
		this.s = s ;
		this.work = work;
		this.show = show ;
		if (method == "merge_sort")	{
			merge_sort() ;
		}else if (method == "quick_sort") {
			quick_sort() ;
		}
	}
	
	private void increment_numCompare(int x) {
		work[0] = work[0] + x ;
	}
	
	private void increment_numSwap(int x) {
		work[1] = work[1] + x ;
	}
	
	private void increment_Recursion(int x) {
		work[2] = work[2] + x ;
	}
	
	
	/************************************************************
					WRITE YOUR CODE BELOW
		YOU CAN HAVE ANY NUMBER OF PRIVATE METHODS AND PRIVATE CLASS
	 *************************************************************/
	private void merge_sort() {
		if (show) {
			s.Pln("Before sort s = ");
		}
		//WRITE CODE BELOW
		//YOU CAN HAVE ANY NUMBER OF PRIVATE METHODS
		s.first=mergebegin(s.first);

		if (show) { 
			s.Pln("After  sort s = ");
		}
	}
	
	private void quick_sort() {
		if (show) {
			s.Pln("Before sort s = ");
		}
		//WRITE CODE BELOW
		//YOU CAN HAVE ANY NUMBER OF PRIVATE METHODS

		Node2 n = s.first;
		if(n!=null){
		while (n.next != null){
			n = n.next;}}

		quickSort(s.first,n);


		if (show) { 
			s.Pln("After  sort s = ");
		}
	}


	private Node2 merge(Node2 a, Node2 b)
	{
		Node2 result = null;

		if (a == null){
			return b;}

		if (b == null){
			return a;}

		increment_Recursion(1);

		if (a.d <= b.d) {
			increment_numCompare(1);
			result = a;
			result.next = merge(a.next, b);
		}
		else {
			increment_numCompare(1);
			increment_numSwap(1);
			result = b;
			result.next = merge(a, b.next);
		}
		return result;
	}

	private Node2 mergebegin(Node2 head)
	{
		if (head == null || head.next == null) {
			return head;
		}
		if(show){
        s.Pln("before partition= ",head);}

		increment_Recursion(1);
		Node2 mid1 = findmid(head);

		Node2 mid2 = mid1.next;

		mid1.next = null;

		Node2 l = mergebegin(head);
		Node2 r= mergebegin(mid2);

		if(show){
			s.Pln("after partition a= " ,l);
			s.Pln("after partition b= " ,r);}

		Node2 result = merge(l,r);

		if(show){
			s.Pln("after merge= " ,result);}

		return result;
	}

	private Node2 findmid(Node2 head)
	{
		if (head == null)
			return head;
		Node2 first = head.next;
		Node2 second = head;

		while (first != null) {
			first = first.next;
			if (first != null) {
				second = second.next;
				first = first.next;
			}
		}
		return second;
	}


	public Node2 partition(Node2 first, Node2 last)
	{
		if(show){
		quickpln2("working on= ",first,last);}

		Node2 pivot = first;
		Node2 front = first;
		int tmp ;

		while ( front != last && front != null )
		{       increment_numCompare(1);
			if (front.d < last.d) {
				pivot = first;

				if(first.d!=front.d){increment_numSwap(1);}
				tmp = first.d;
				first.d = front.d;
				front.d = tmp;
				first = first.next;
			}
			front = front.next;
		}

		if(first.d!=last.d){increment_numSwap(1);}
		tmp = first.d;
		first.d = last.d;
		last.d = tmp;
		return pivot;
	}


	private void quickSort(Node2 first, Node2 last)
	{
		if (first == last) {
			return;}

		Node2 pivot = partition(first, last);
		if(show){
			quickpln("l= ",first,pivot);
			System.out.println("p= "+pivot.d+"->NIL");
			quickpln2("r= ",pivot.next,last);
		}
		if (pivot.next != null && pivot != null )
		{   increment_Recursion(1);
			quickSort(pivot.next, last);
		}
		if ( first != pivot && pivot != null)
		{   increment_Recursion(1);
			quickSort(first, pivot);
		}
	}


	private void quickpln(String t,Node2 n, Node2 m){
		System.out.print(t);
		while (n != null) {
            if(n==m){
				System.out.print("NIL");
				break;
			}
			System.out.print(n.d);
			if (n.next == null) {
				System.out.print(n.d);
				System.out.print("->NIL");
				break;
			} else {
				System.out.print("->");
			}
			n = n.next;
		}
		System.out.println();
	}


	private void quickpln2(String t,Node2 n, Node2 m){
		System.out.print(t);
		while (n != null) {

			System.out.print(n.d);
			if (n.next == null || n==m) {
				System.out.print("->NIL");
				break;
			} else {
				System.out.print("->");
			}
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("SlistSort STARTS");
		System.out.println("SlistSort ENDS");
	}
	
}
	