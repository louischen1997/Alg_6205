
package digitalmarketing.ProductManagement;


//this class will extract summary data from the product
public class ProductSummary {

    Product subjectproduct;
    int numberofsalesabovetarget;
    int numberofsalesbelowtarget;
    int salesvalume; //total profit above target --could be negative too
    int acutalsalesvolume;
    int rank; // will be done later

    public ProductSummary(Product p) {

        numberofsalesabovetarget = p.getNumberOfProductSalesAboveTarget();
        salesvalume = p.getOrderPricePerformance();
        subjectproduct = p; //keeps track of the product itself not as well;
        acutalsalesvolume = p.getSalesVolume();
    }

    public int getNumberAboveTarget() {
        return numberofsalesabovetarget;
    }

    public boolean isProductAlwaysAboveTarget() {
        return false; // to be implemented
    }
    
    public void print(){
        
        System.out.println(subjectproduct.getName() + " | " +  acutalsalesvolume + "|" + salesvalume);
        
    }

}
