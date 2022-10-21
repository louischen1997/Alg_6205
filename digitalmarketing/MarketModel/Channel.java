
package digitalmarketing.MarketModel;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import java.util.Scanner;

public class Channel {
    String name;
    boolean delivery;
    boolean walkin;
    double finalPrice;
    String survice;
    double ch_revenue=0;
    
    public Channel(String s,boolean b, boolean w){
        name=s;   
        delivery=b;
        walkin=w;
    }
    public double getRev(){
    return ch_revenue;
    
    }
    public void setRev(double d){
    ch_revenue+=d;
    
    }
    public String getName(){
    return name;
    }
    
    public double giveSolution(Product p,int size){
        double x=1;
    if(name.equals("Amazon")){     
    if (size>=3){        
        x=0.85;
    return x;
    }
    }
    
    else if (name.equals("Apple")){    
    return x;
    }
    
     else if (name.equals("Walmart")){
         
        if (size>=5){
        x=0.75;
    return x;
    }
    }
    
    else if (name.equals("Target")){
        
        if (size>=2){
        x=0.9;
    return x;
    }
    }
    
    else if (name.equals("Wee")){
        
        if (size>=3){
        x=0.8;
    return x;
    }
    }
    else if (name.equals("Ikea")){
       return x;
    } 
    return x;
    }
    
    public void service(double i){
    if(name.equals("Amazon")){   
        System.out.println("Delivery option:1. 7days 2.3days");
        System.out.println("extra 20% on total price if you choose 7days");
        System.out.println("extra 50% on total price if you choose 3days");
        Scanner answer = new Scanner(System.in); 
        String  Answer= answer.next();
        if(Answer.equals("1")){
        System.out.println("your final solution is:");
        System.out.println(i*1.2);
        survice="You get a 7 days delivery service";
        finalPrice=i*1.2;
        
        }
        else{
        System.out.println("your final solution is:");
        System.out.println(i*1.5);
        survice="You get a 3 days delivery service";
        finalPrice=i*1.5;
        }
    
    }
    
    else if (name.equals("Apple")){
       System.out.println("Warranty option:1. 1year 2.2years");
       System.out.println("extra 20% on total price if you choose 1year");
        System.out.println("extra 30% on total price if you choose 2years");
        Scanner answer = new Scanner(System.in); 
        String  Answer= answer.next();
        if(Answer.equals("1")){
        System.out.println("your final solution is:");
        System.out.println(i*1.2);
        survice="You get a one year warranty";
        finalPrice=i*1.2;
        
        }
        else{
        System.out.println("your final solution is:");
        System.out.println(i*1.3);
        survice="You get a two years warranty";
        finalPrice=i*1.3;
        
        
    }}
    
     else if (name.equals("Walmart")){
         System.out.println("Delivery option:1. 7days 2.3days");
         System.out.println("extra 10% on total price if you choose 7days");
        System.out.println("extra 30% on total price if you choose 3days");
        Scanner answer = new Scanner(System.in); 
        String  Answer= answer.next();
        if(Answer.equals("1")){
        System.out.println("your final solution is:");
        System.out.println(i*1.1);
        survice="You get a 7 days delivery service";
        finalPrice=i*1.1;
        
        }
        else{
        System.out.println("your final solution is:");
        System.out.println(i*1.3);
        survice="You get a 3 days delivery service";
        finalPrice=i*1.3;
        
    }}
    
    else if (name.equals("Target")){
        System.out.println("Delivery option:1. 7days 2.pick up at the store");
        System.out.println("extra 20% on total price if you choose 7days");
        
        Scanner answer = new Scanner(System.in); 
        String  Answer= answer.next();
        if(Answer.equals("1")){
        System.out.println("your final solution is:");
        System.out.println(i*1.2);
        survice="You get a 7 days delivery service";
        finalPrice=i*1.2;
        
        }
        else{
        System.out.println("your final solution is:");
        System.out.println(i);
        survice="You should pick up in person";
        finalPrice=i;
        }
    }
    
    else if (name.equals("Wee")){
        System.out.println("Delivery option:1. 3days 2.1days");
        System.out.println("extra 30% on total price if you choose 3days");
        System.out.println("extra 50% on total price if you choose 1days");
        Scanner answer = new Scanner(System.in); 
        String  Answer= answer.next();
        if(Answer.equals("1")){
        System.out.println("your final solution is:");
        System.out.println(i*1.3);
        survice="You get a 3 days delivery service";
        finalPrice=i*1.3;
        
        }
        else{
        System.out.println("your final solution is:");
        System.out.println(i*1.5);
        survice="You get a one days delivery service";
        finalPrice=i*1.5;
        }  
    }
    else if (name.equals("Ikea")){
       System.out.println("Warranty option:1. 1year 2.2years");
       System.out.println("extra 20% on total price if you choose 1year");
        System.out.println("extra 30% on total price if you choose 2years");
        Scanner answer = new Scanner(System.in); 
        String  Answer= answer.next();
        if(Answer.equals("1")){
        System.out.println("your final solution is:");
        System.out.println(i*1.2);
        survice="You get a one year warranty service";
        finalPrice=i*1.2;
        
        }
        else{
        System.out.println("your final solution is:");
        System.out.println(i*1.3);
        survice="You get a two years warranty service";
        finalPrice=i*1.3;
      
    }
     
    }
    
    }
    
    
    public String getSurvice(){
        return survice;
    
    }
    
    public double getFinalPrice(){
    return finalPrice;
    
    }
}
