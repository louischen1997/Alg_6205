
package digitalmarketing.OrderManagement;

import java.util.ArrayList;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerProfile;


public class MasterOrderList {
    Business business;
    ArrayList<Order> orders;
    MasterOrderReport masterorderreport;

    public MasterOrderList(Business b) {
        orders = new ArrayList();
        business = b;
    }

    public Order newOrder(CustomerProfile cp) {
        Order o = new Order(cp);
        orders.add(o);
        return o;

    }

    public MasterOrderReport generateMasterOrderReport() {
        masterorderreport = new MasterOrderReport();

        return masterorderreport;

    }

    public int getSalesVolume() {

        int sum = 0;
        for (Order order : orders) {
            sum = sum + order.getOrderTotal();
        }
        return sum;
    }
    
    public void printOrders(){
        System.out.println("Order List:");
        for (Order o : orders){
            o.printOrderDetails();
        }
    }

}
