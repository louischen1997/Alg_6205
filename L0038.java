public class SolutionL0038 {
     public String countAndSay(int n) {
        String ans = alg(n);
        return ans ;
    }
    //My Version
     public String countAndSay(String n) {
        String ans = alg(n);
        return ans ;
    }


    //WRITE YOUR CODE BELOW
     private String alg(String s) {
            char first = s.charAt(0);
            String res="";
            int count=1;
            for(int i=1;i<s.length();i++){
                if(first!=s.charAt(i)){
                    String scount=String.valueOf(count);
                    res=res+scount;

                    String sfirst=String.valueOf(first);
                    res=res+sfirst;
                    count=0;
                    first=s.charAt(i);
                }
                count++;
            }
        String scount=String.valueOf(count);
        res=res+scount;

        String sfirst=String.valueOf(first);
        res=res+sfirst;

        return res;

//WRITE CODE
    }
     private String alg(int n) {
        if(n==1){
            return "1";
        }
        String res="";
        String sn=String.valueOf(1);
        for(int i=1;i<n;i++){
            res=countAndSay(sn);
            sn=res;
        }
        return res;
//WRITE CODE
    }

    public static void main(String[] args) {
        System.out.println("Run L0038Test.java");
    }
}


