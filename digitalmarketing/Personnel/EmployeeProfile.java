
package digitalmarketing.Personnel;

import java.util.ArrayList;
import digitalmarketing.OrderManagement.Order;


public class EmployeeProfile {
    ArrayList<Order> salesorders;

    Person person;
    public EmployeeProfile(){
        
    }

    public void addSalesOrder(Order o){
        salesorders.add(o);
        
    }
    

    public EmployeeProfile(Person p) {

        person = p;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }




}
