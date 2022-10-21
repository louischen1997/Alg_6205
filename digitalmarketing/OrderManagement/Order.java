
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.Personnel.EmployeeProfile;
import digitalmarketing.ProductManagement.Product;


public class Order {

    ArrayList<OrderItem> orderitems;
    ArrayList<OrderPackage> orderpackages;
    CustomerProfile customer;
    EmployeeProfile salesperson;

    public Order() {
    }

    public Order(CustomerProfile cp) {
        orderitems = new ArrayList();
        orderpackages=new ArrayList();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson = null;
    }

    public Order(CustomerProfile cp, EmployeeProfile ep) {
        orderitems = new ArrayList();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson.addSalesOrder(this);
    }

    public OrderItem newOrderItem(Product p, int q, int ap) {
        OrderItem oi = new OrderItem(p, q, ap);
        orderitems.add(oi);
        return oi;
    }
    
    public OrderPackage newPackage(){
        
    OrderPackage newP=new OrderPackage("","","",0);
    orderpackages.add(newP);
    return newP;
    
    }
    
    public void setNewPack(String p,String s, String n, double pr){
    for (OrderPackage o:orderpackages){
    o.setP(p, s, n, pr);
  
    } 
    }

    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    //sum all the item targets and compare to the total of the order 
    public boolean isOrderAboveTotalTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTargetTotal(); //product targets are added
        }
        if (getOrderTotal() > sum) {
            return true;
        } else {
            return false;
        }

    }

    public void printOrderDetails(){
        System.out.println(" ");
        System.out.println("Order details");
        for (OrderPackage oi : orderpackages){
            oi.printDetails();
        }
    }
    
   
    
    
}
