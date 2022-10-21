/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalmarketing.MarketModel;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.Supplier.Supplier;
import digitalmarketing.Supplier.SupplierDirectory;
import digitalmarketing.Business.Business;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Market {
    Channel amazon=new Channel("Amazon",true,false);
    Channel apple=new Channel("Apple",true,true);
    Channel wee=new Channel("Wee",true,false);
    Channel walmart=new Channel("Walmart",true,true);
    Channel ikea=new Channel("Ikea",true,true);
    Channel target=new Channel("Target",true,true);
    ArrayList<MarketChannelAssignment> channels;
    ArrayList<String> characteristics;
    int type;
    double mar_revenue=0;
    String name;
public Market(String s,int n ){
    characteristics = new ArrayList();
    characteristics.add(s);
    type=n;
    this.name=s;
}

public double getRev(){
return mar_revenue;
}

public void setRev(double d){
mar_revenue+=d;
}
public String getName(){
return name;
}
public Channel getChannel(String s){
if(s.equals("1")||s.equals("4")||s.equals("7")){
return amazon;
}
else if (s.equals("2")||s.equals("9")){
return walmart;
}
else if (s.equals("3")){
return apple;
}
else if (s.equals("5")){
return ikea;
}

else if (s.equals("6")){
return target;
}

else if (s.equals("8")){
return wee;
}
return null;
}



public void passTotal(double d,String s){
if(s.equals("1")||s.equals("1")||s.equals("1")){
amazon.service(d);
}
else if(s.equals("2")||s.equals("9")){
walmart.service(d);
}
else if(s.equals("3")){
apple.service(d);
}
else if(s.equals("5")){
ikea.service(d);
}
else if (s.equals("6")){
target.service(d);

}
else if (s.equals("8")){
wee.service(d);

}

}




public double searchProduct(Product p,int size, String s){
    if(p!=null){
    System.out.println("----------------------");    
    System.out.println("You have select: "+p.getName());
    System.out.println("Origianl price is "+String.valueOf(p.getTargetPrice()));    
    if (type==1){    
       
    if (p.getType().equals("electronic")){
  
    if(s.equals("1")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.8*amazon.giveSolution(p,size)));
    //amazon.service(p.getTargetPrice()*0.8*amazon.giveSolution(p,size));
    return p.getTargetPrice()*0.8*amazon.giveSolution(p,size);
    }
    if(s.equals("2")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.8*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.8*walmart.giveSolution(p,size);
    }
    if(s.equals("3")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.8*apple.giveSolution(p,size)));
    return p.getTargetPrice()*0.8*apple.giveSolution(p,size);
    }
 
    }
    else if(p.getType().equals("furniture")){
    

    if(s.equals("4")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*amazon.giveSolution(p,size);
    }
    if(s.equals("5")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*ikea.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*ikea.giveSolution(p,size);
    }
    if(s.equals("6")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*target.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*target.giveSolution(p,size);
    }
    
    }
    else{
    
    
    if(s.equals("7")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.7*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.7*amazon.giveSolution(p,size);
    }
    if(s.equals("8")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.7*wee.giveSolution(p,size)));
    return p.getTargetPrice()*0.7*wee.giveSolution(p,size);
    }
    if(s.equals("9")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.7*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.7*walmart.giveSolution(p,size);
    }
    
    }
    }
    else if(type==2){
       
    if (p.getType().equals("electronic")){
   
    if(s.equals("1")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*amazon.giveSolution(p,size);
    }
    if(s.equals("2")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*walmart.giveSolution(p,size);
    }
    if(s.equals("3")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*apple.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*apple.giveSolution(p,size);
    }
    
    }
    else if(p.getType().equals("furniture")){
   
    if(s.equals("4")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*amazon.giveSolution(p,size);
    }
    if(s.equals("5")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*ikea.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*ikea.giveSolution(p,size);
    }
    if(s.equals("6")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*target.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*target.giveSolution(p,size);
    }
    
    }
    else{
    
  
    if(s.equals("7")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*amazon.giveSolution(p,size);
    }
    if(s.equals("8")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*wee.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*wee.giveSolution(p,size);
    }
    if(s.equals("9")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*walmart.giveSolution(p,size);
    }
    
    }    
           
    }
    else if(type==3){
        
          if (p.getType().equals("electronic")){
    
   
    
    if(s.equals("1")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*amazon.giveSolution(p,size);
    }
    if(s.equals("2")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*walmart.giveSolution(p,size);
    }
    if(s.equals("3")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*apple.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*apple.giveSolution(p,size);
    }
    
   
    }
    else if(p.getType().equals("furniture")){
   
    
    if(s.equals("4")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*amazon.giveSolution(p,size);
    }
    if(s.equals("5")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*ikea.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*ikea.giveSolution(p,size);
    }
    if(s.equals("6")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.95*target.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*target.giveSolution(p,size);
    }
    
    }
    else{
   
    if(s.equals("7")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*amazon.giveSolution(p,size);
    }
    if(s.equals("8")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*wee.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*wee.giveSolution(p,size);
    }
    if(s.equals("9")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.95*walmart.giveSolution(p,size);
    }
   
    }
    
    }
    else{
        
      if (p.getType().equals("electronic")){
    
    
    if(s.equals("1")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*amazon.giveSolution(p,size);
    }
    if(s.equals("2")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*walmart.giveSolution(p,size);
    }
    if(s.equals("3")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*apple.giveSolution(p,size)));
    return p.getTargetPrice()*0.9*apple.giveSolution(p,size);
    }
    
    }
    else if(p.getType().equals("furniture")){
    
    
    if(s.equals("4")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.85*amazon.giveSolution(p,size);
    }
    if(s.equals("5")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*ikea.giveSolution(p,size)));
    return p.getTargetPrice()*0.85*ikea.giveSolution(p,size);
    }
    if(s.equals("6")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.9*target.giveSolution(p,size)));
    return p.getTargetPrice()*0.85*target.giveSolution(p,size);
    }
    
    }
    else{
    
    
    if(s.equals("7")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.8*amazon.giveSolution(p,size)));
    return p.getTargetPrice()*0.8*amazon.giveSolution(p,size);
    }
    if(s.equals("8")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.8*wee.giveSolution(p,size)));
    return p.getTargetPrice()*0.8*wee.giveSolution(p,size);
    }
    if(s.equals("9")){
    System.out.println("The new price is "+String.valueOf(p.getTargetPrice()*0.8*walmart.giveSolution(p,size)));
    return p.getTargetPrice()*0.8*walmart.giveSolution(p,size);
    }
    
    }    
        
    }
    
        
}

return 0;    
}







}
