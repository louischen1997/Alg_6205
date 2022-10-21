/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalmarketing;

import com.github.javafaker.Faker;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.Personnel.Person;
import digitalmarketing.Supplier.SupplierDirectory;
import java.util.Random;

/**
 *
 * @author alelashvili
 */
public class DataLoader {
    
    Faker faker;
    
    
    public DataLoader(){
        faker = new Faker();
    }
    
    public void populateBusiness(Business b){
       populateSupplierDirectory(b.getSupplierDirectory(), 3);
       //populateCustomerDirectory(b.getCustomerDirectory(), 1);
       // add products
       // add orders
       // add
       
       }
    
    
    public void populateSupplierDirectory(SupplierDirectory sd, int count){
        
            
            sd.newSupplier("supplier_one", "electronic");
            sd.newSupplier("supplier_two", "furniture");
            sd.newSupplier("supplier_three", "grocery");
        
    }
    
    public void populateCustomerDirectory(CustomerDirectory cd, int count,String customerName){
        for (int i=0; i<count; i++){
            //String customerName = faker.name().fullName();
            cd.newCustomerProfile(new Person(customerName));
        }
    }
    
   
    
    
    
    
    
    
    public int getRandomPrice(int lower, int upper){
        Random random = new Random();
        int result = 0;
        result = lower + random.nextInt(upper - lower);
        return result;
    }
    
}
