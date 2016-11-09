import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Collection;

/**
 * author: Chaitanya Kovuri
 * git username: itsck
 * Warehouse Final Project: Orders
 */

public class Orders{

	//All the below are Instance variables.
	HashMap<Integer, order> initialOrders;  
	Queue<Integer> ordersQueue; //LinkedList and the Integer is the OrderID
	

	//constructor
	public Orders () {
		//using "order" instead of Object because
		//wont have to cast back while calling getters.
		
		initialOrders  = new HashMap<Integer,order>(); 
		ordersQueue = new LinkedList<Integer>();
	}

	
	/*Generates a new order. The HashMap is used for storing an 
	 * Order's item Name and the desired Quantity
	 */
	
	public void generateOrder (int OrderID, HashMap<String,Integer> itemAndQty, String address){
		int OrderIDcpy = OrderID;
		order CustomerOrder = new order (OrderID, itemAndQty, address);
		
		/*Create Use Boolean verifyOrderItems() method here to see if customerOrder is 
		 * in the warehouse.
		 * 
		 * if (verifyOrderItems == true){ // then proceed with generating new Order. 
		 */
		
		initialOrders.put(OrderIDcpy, CustomerOrder); //HashMap contains all the Info on Orders
		ordersQueue.offer(OrderIDcpy); //This new order is on a queue
	}
	
	
	//order reaches the exit/truck
	public void orderFulfilled(int OrderID){
		int exitOrderID = ordersQueue.poll(); //dequeue
		order details = initialOrders.get(exitOrderID);//update the order status.
		details.updateStatus("Fulfilled"); //the customer order has been fulfilled
		//initialOrders.remove(OrderID); 
		
		/*We can remove the mapping of that OrderID
		 * once it's fulfilled but it could be 
		 * useful when dealing with wrong orders,
		 * returns or damaged goods. 
		 */
	}
	
	//Boolean method to check if Order items are present in Inventory
	public boolean verifyOrderItems (order customerOrder){
		boolean itemsPresent;
		boolean qtyPresent;
		boolean bothPresent = true; //This is TRUE if both items and quantities are present.
		Set items = customerOrder.getSetOfItems();
		Collection <Integer> qty = customerOrder.getItemQty();
		int listLength = customerOrder.getNumberOfItems();
		for (int i=0; i<listLength; i++){
			
			/*Use loop to check if item & quantity Present. 
			 * ALL ITEMS & Quantity HAVE TO BE PRESENT for TRUE
			 * compare 2 bool's for result of "bothPresent"
			 */
		}
		return bothPresent;
	}
	
	
	
}
