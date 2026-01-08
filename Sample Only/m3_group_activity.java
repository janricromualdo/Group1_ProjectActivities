package m3_group_activity;

import java.text.DecimalFormat;
import java.util.*;

public class m3_group_activity {
	
    static LinkedList<Product> products = new LinkedList<>();
	static Scanner input = new Scanner(System.in);
	static double checkoutTotal = 0.0;
	
	//PRODUCT CLASS (NAME & PRICE)
	static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }    
        public String getName() { 
        	return name; 
        	return name1; 
        	return name2; 
        	return name3; 
        }
        public double getPrice() { 
        	return price; 
        }
    }
	
	public static void main(String[] args) {
       
        initializeProduct(products);
		Scanner options = new Scanner(System.in);
		DecimalFormat decFormat = new DecimalFormat("#.00");
        
        boolean loopin = true;
		while (loopin) {
			printOptions();		
	        System.out.print("Enter choice: ");
			String userInput = options.nextLine();
			
			switch (userInput) {
	        	case "1":
	        		addProduct(); break;
	        	case "2":
	        		processNextProduct();break;
	        	case "3":
	        		System.out.println("\nProducts waiting in queue : " + products.size());
	        		break;
	        	case "4":
	        		System.out.println("Total bill so far : ₱"+decFormat.format(checkoutTotal) );
	        		break;
	        	case "5":
	        		System.out.println("Closing cashier line...\nFinal total bill: ₱"+decFormat.format(checkoutTotal) );
	        		loopin = false;
	        		break;
	        	default:
	        		System.out.println("\nInvalid entry kindly retry");
			}
		} 
		
		options.close();
	}

	private static void initializeProduct(List<Product> products) {

		products.addAll(Arrays.asList(
				new Product("Intel Core i7-12700K Processor", 349.99),
				new Product("ASUS ROG Strix Z690 Motherboard", 289.99),
				new Product("Corsair Vengeance DDR5 32GB RAM", 159.99),
				new Product("Samsung 980 Pro 1TB NVMe SSD", 129.99),
				new Product("NVIDIA GeForce RTX 4070 Graphics Card", 599.99)
		));
	}
	
	private static void printOptions() {

		System.out.println(
		    "\n--- Cashier Checkout Menu ---\n" +
		    "1. Add a product\n" +
		    "2. Process next product\n" +
		    "3. Check number of products\n" +
		    "4. View total bill so far\n" +
		    "5. Exit"
		);

	}
	
	private static void addProduct() {
		 boolean inputValid = true;
		 String prodName = null;
		 while (inputValid) {
			 System.out.print("Enter product name : ");
			 prodName = input.nextLine().trim();
			 if (!prodName.isEmpty()) {
				 inputValid = false;
			 }
			 else {
				 System.out.println("Invalid Input Kindly Retry"); 
			 } 
		 }
		 
		 inputValid = true;
		 while (inputValid) {
			 System.out.print("Enter product price (₱): ");
			 String priceInput = input.nextLine().trim();
			 
			 if (priceInput.isEmpty()) {
				 System.out.println("Invalid Input Kindly Retry"); 
			 }
			 else {
				 try {
					 	double price = Double.parseDouble(priceInput);
					 	if (price < 0) {
					 		System.out.println("Invalid Input Kindly Retry");
					 	}else {
					 		Product p = new Product(prodName, price);
					 		products.add(p);
					 		System.out.println("Product added to checkout line!");
					 		inputValid = false;
					 	}
		             } catch (NumberFormatException e) {
		                System.out.println("Invalid Input Kindly Retry");
		         }
			 } 
		 }
	}  
	
	private static void processNextProduct() {
		if (products.isEmpty()) {
            System.out.println("Queue is empty, Please add a product");
        } else {
            Product next = products.removeFirst();
            checkoutTotal += next.getPrice();
            System.out.println("Processed: " + next.getName() + " "+ "(Php " +next.getPrice() + ")" );
            DecimalFormat decFormat = new DecimalFormat("#.00");
            System.out.println("Total bill so far : Php" + decFormat.format(checkoutTotal) );
        }
	} 
}