
package digitalmarketing.OrderManagement;
import digitalmarketing.ProductManagement.Product;
import java.util.ArrayList;

public class OrderPackage {
    String name;
    String survice;
    ArrayList<String> product;        
    double price;
    public OrderPackage(String p,String s,String n,double pr){
    product = new ArrayList();
    n=name;
    survice=s;
    price=pr;
    }
    
    public void setP(String p,String s,String n,double pr){
    product.add(p);
    name=n;
    survice=s;
    price=pr;
    
    }
    
    public void printDetails(){
    System.out.println("--------------------------");
    System.out.println("This is your order details");
    System.out.println(" ");
    System.out.println("Cusomer name:");
    System.out.println(name);
    System.out.println(" ");
    System.out.println("Products you buy:");
    for(String s:product){
    System.out.println(s);
    }
    System.out.println(" ");
    System.out.println("The bundle survice:");
    System.out.println(survice);
    System.out.println(" ");
    System.out.println("Total price:");
    System.out.println(price);
    System.out.println("--------------------------");
    
    
    
    }
    
    
    
    
}
