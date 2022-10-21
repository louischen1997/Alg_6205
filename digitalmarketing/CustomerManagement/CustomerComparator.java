
package digitalmarketing.CustomerManagement;

import java.util.Comparator;


public class CustomerComparator implements Comparator<CustomerProfile> {

    @Override
    public int compare(CustomerProfile o1, CustomerProfile o2) {
        // -1, 0, 1
        return (-1) * o1.getName().compareTo(o2.getName());
    }
    
}
