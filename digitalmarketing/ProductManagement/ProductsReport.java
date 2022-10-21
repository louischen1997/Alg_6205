
package digitalmarketing.ProductManagement;

import java.util.ArrayList;


public class ProductsReport {

    ArrayList<ProductSummary> productsummarylist;
    ArrayList<ProductSummary> besttenlist;

    public ProductsReport() {
        productsummarylist = new ArrayList();
        besttenlist = new ArrayList();
    }

    public void addProductSummary(ProductSummary ps) {

        productsummarylist.add(ps);
    }

    public ProductSummary getTopProductAboveTarget() {
        ProductSummary currenttopproduct = null;

        for (ProductSummary ps : productsummarylist) {
            if (currenttopproduct == null) {
                currenttopproduct = ps; // initial step 
            } else if (ps.getNumberAboveTarget() > currenttopproduct.getNumberAboveTarget()) {
                currenttopproduct = ps; //we have a new higher total
            }

        }
        return currenttopproduct;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        ArrayList<ProductSummary> productsalwaysabovetarget = new ArrayList(); //temp array list

        for (ProductSummary ps : productsummarylist) {
            if (ps.isProductAlwaysAboveTarget() == true) {
                productsalwaysabovetarget.add(ps);
            }
        }

        return productsalwaysabovetarget;
    }
    
    public void printbestten(){
        
        
        for (ProductSummary ps : productsummarylist){
            
            if (ps.salesvalume>0){
            besttenlist.add(ps);
            
            }
            
        }
        
        for (ProductSummary ps : besttenlist){
            ps.print();
        }
    
    }
    
     public int printbestsupplier(){
        
        int sum=0;
        for (ProductSummary ps : productsummarylist){
            sum+=ps.salesvalume;
             
        }
        
        return sum;
        
    }
    public void print(){
        System.out.println(" -----------  Product Report ----------- ");
        for (ProductSummary ps : productsummarylist){
            ps.print();
        }
    }

}
