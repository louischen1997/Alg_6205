
package digitalmarketing.Supplier;

import java.util.ArrayList;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.ProductManagement.ProductSummary;
import digitalmarketing.ProductManagement.ProductsReport;


public class Supplier {

    SupplierDirectory directory;
    String name;
    ProductCatalog productcatalog;
    ProductsReport productsreport;

    public Supplier(String n, SupplierDirectory d, String type) {
        name = n;
        productcatalog = new ProductCatalog(type, this);
        directory = d;

    }

    public ProductsReport prepareProductsReport() {

        productsreport = productcatalog.generatProductPerformanceReport();
        return productsreport;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {

        if (productsreport == null) {
            productsreport = prepareProductsReport();
        }
        return productsreport.getProductsAlwaysAboveTarget();

    }

    public ProductCatalog getProductcatalog() {
        return productcatalog;
    }
    
    

    public String getName() {
        return name;
    }
    //add supplier product ..

    //update supplier product ...

    public void printSupplierDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Supplier : " + name);
        productcatalog.printDetails();
        
    }

    public Product newProduct(int fp, int cp, int tp, String n,String t) {
        return productcatalog.newProduct(fp, cp, tp, n,t);
    }

}

