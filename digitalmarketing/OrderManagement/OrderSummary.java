
package digitalmarketing.OrderManagement;

public class OrderSummary {

    int salesvolume;
    boolean totalabovetarget;
    int orderpriceperformance;
    int numberofOrderitemsabovetarget;

    public OrderSummary(Order o) {
        salesvolume = o.getOrderTotal();
        totalabovetarget = o.isOrderAboveTotalTarget();
        orderpriceperformance = o.getOrderPricePerformance();
        numberofOrderitemsabovetarget = o.getNumberOfOrderItemsAboveTarget();

    }

    public int getOrderProfit() {
        return 0; // to be implemented
    }
}
