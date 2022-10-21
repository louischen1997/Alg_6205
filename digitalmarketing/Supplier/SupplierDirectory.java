
package digitalmarketing.Supplier;

import java.util.ArrayList;
import digitalmarketing.Business.Business;
import java.util.Arrays;   


public class SupplierDirectory {

    Business business;
    ArrayList<Supplier> suppliers;
    int x,y,z,k,m;
        

    public SupplierDirectory(Business b) {
        
        suppliers = new ArrayList();
        business = b;
    }

    public Supplier newSupplier(String n, String t) {
        Supplier supplier = new Supplier(n, this, t);
        suppliers.add(supplier);
        return supplier;

    }

    public Supplier findSupplier(String id) {

        for (Supplier supplier : suppliers) {

            if (supplier.getName().equals(id)) {
                return supplier;
            }
        }
        return null;
    }

    public Supplier findSupplierByIndex(int index) {
        if (index<0) return null;
        if (index>suppliers.size()) return null;
        return suppliers.get(index);
    }
    
    public void getBestTen(){
        System.out.println("----------Best Ten Product Report----------");
    for (int i=0;i<5;i++){
        findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestten();
    
    }
    
    }
    
    public void getBestSupplier(){
        
        System.out.println("----------Best Three Suppliers----------");
        x=findSupplierByIndex(0).getProductcatalog().generatProductPerformanceReport().printbestsupplier();
        y=findSupplierByIndex(1).getProductcatalog().generatProductPerformanceReport().printbestsupplier();
        z=findSupplierByIndex(2).getProductcatalog().generatProductPerformanceReport().printbestsupplier();
        k=findSupplierByIndex(3).getProductcatalog().generatProductPerformanceReport().printbestsupplier();
        m=findSupplierByIndex(4).getProductcatalog().generatProductPerformanceReport().printbestsupplier();
        int [] array=new int[]{x,y,z,k,m};
        Arrays.sort(array);
        for (int i=0;i<5;i++){
        if (array[2]==findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestsupplier()){
            String s=String.valueOf(findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestsupplier()); 
            System.out.println(findSupplierByIndex(i).name+", with total volume : "+s);
        }
        
        if (array[4]==findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestsupplier()){
         String s=String.valueOf(findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestsupplier()); 
            System.out.println(findSupplierByIndex(i).name+", with total volume : "+s);
        }
        
        if (array[3]==findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestsupplier()){
         String s=String.valueOf(findSupplierByIndex(i).getProductcatalog().generatProductPerformanceReport().printbestsupplier()); 
            System.out.println(findSupplierByIndex(i).name+", with total volume : "+s);
        }
        
        
        }
        
       
    }
    
    
    public void printSupplierList(){
        System.out.println("Supplier List:");
        for (Supplier s : suppliers) {
            s.printSupplierDetails();
        }
    }
}
