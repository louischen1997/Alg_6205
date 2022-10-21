
package digitalmarketing.ProductManagement;

import java.util.ArrayList;
import digitalmarketing.Supplier.Supplier;
import java.util.Collections;


public class ProductCatalog {

    Supplier supplier;
    String type;
    ArrayList<Product> products;

    public ProductCatalog(String t, Supplier s) {
        type = t;
        products = new ArrayList();
        supplier = s;
    }

    public ProductCatalog() {
        type = "noname";
        products = new ArrayList();
    }

    public Product newProduct(int fp, int cp, int tp, String n,String t) {
        Product p = new Product(fp, cp, tp, n,t);
        products.add(p);
        return p;
    }

    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsreport = new ProductsReport();

        for (Product p : products) {

            ProductSummary ps = new ProductSummary(p);
            productsreport.addProductSummary(ps);
        }
        return productsreport;
    }
    
    
    public Product getProductsByName(String name){
    for(Product p :products){
    if(p.getName()==name){
    return p;}}
    return null;}
    
    
    public Product search(String n){
    for(Product p :products){
    if (n.equals(p.getName())){
    return p;
    }
    
    }
    return null;
    }
    
    
    
    public void printDetails(){
        
        Collections.sort(products, new ProductComparator(0));
        
        System.out.println("Product Catalog for : " + type);
        for (Product p : products){
            p.printDetails();
        }
    }
    
}
