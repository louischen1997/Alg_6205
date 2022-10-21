
package digitalmarketing.ProductManagement;

import java.util.ArrayList;
import digitalmarketing.MarketModel.Market;


public class SolutionOffer {
    ArrayList<Product> products;
    int price;
    Market market;
    public SolutionOffer(Market m){
        market = m;
        products = new ArrayList();
    }
    
    public void addProduct(Product p){
        products.add(p);
    }
    public void setPrice(int p){
        price = p;
        
    }
    
}
