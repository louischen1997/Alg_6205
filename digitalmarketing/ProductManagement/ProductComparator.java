
package digitalmarketing.ProductManagement;

import java.util.Comparator;


public class ProductComparator implements Comparator<Product>{

    int compareOptions;

    public ProductComparator(int compareOptions) { // 0 - floorprice, 1 - alphabetically
        this.compareOptions = compareOptions;
    }

    @Override
    public int compare(Product o1, Product o2) {

        if (compareOptions == 0) {
            return (-1) * Integer.compare(o1.getFloorPrice(), o2.getFloorPrice());
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }

}
