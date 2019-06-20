package a3_bollings;

import java.util.ArrayList;

/**
 * This class constructs an empty ArrayList called shipmentList, 
 * Includes -> 
 * get method - to find the Shipment object at a certain index
 * add method - to prevent Shipments with the same destination from creating 
 * duplicate objects in the list
 * findShipment method - locates the index of Shipment with matching destination
 * length method - access number of Shipment objects populating the ShipmentList
 * toString method - prints each Shipment object in the ShipmentList on new line
 * @author Stuart Bollinger
 */
public class ShipmentList  {
    
    /**
     * Declare empty ArrayList called shipmentList,
     * Will eventually be populated with Shipment objects
     */
    private ArrayList<Shipment> shipmentList = new ArrayList();

    /**
     * Constructor for ShipmentList, creates empty shipmentList
     */
    public ShipmentList(){}
    
    /**
     * Access the Shipment object at a certain index of the ShipmentList
     * @param index of the desired Shipment Object
     * @return the Shipment object at the index argument
     */
    public Shipment get(int index){
        
       return shipmentList.get(index);
    }
    
    /**
     * For loop iterates through each element of the ShipmentList:
     * If the destination of the accepted Shipment object has the same
     * destination as any of the Shipment objects that populate shipmentList:
     * Then invoke addShipValue method from Shipment class to combine their 
     * respective shipment values, 
     * Create a new Shipment object with their combined values,
     * And set (replace) that Shipment object in the 
     * Shipmentlist with the new Shipment object containing the combined values 
     * If the Shipment object argument has a destination that isn't currently
     * in the shipmentList, add that Shipment object to the end of shipmentList
     * @param shipment accepts Shipment object, compares to Shipmentlist 
     * to find out if destination already exists
     */
    public void add(Shipment shipment){
                    
        boolean found = false;
        for (int i = 0; i<shipmentList.size(); i++){                                                
            if (shipment.destination.getName().equals(shipmentList.get(i).destination.getName())){      
                double shipmentTotal = (shipmentList.get(i).getShipValue() + shipment.getShipValue());   
                shipmentList.set(i, new Shipment(shipment.destination, shipmentTotal)); 
                found = true;    
            }
        }
            if (!found){
                shipmentList.add(new Shipment(shipment.destination, shipment.getShipValue()));
            }
        }

    /**
     * For loop iterates through each element of the arrayList shipmentList:
     * If the accepted Destination object has the same province code,
     * (getName() from Destination enumeration) that matches any of the
     * destination names of the Shipment objects that populate shipmentList:
     * Return the index of that Shipment object (in shipmentList)
     * If the name isn't found, index variable remains -1
     * @param destination This method accepts a Destination Object
     * @return integer representing the indexOf matching destination, 
     * or -1 (no matching destination)
     */
    public int findShipment(Destination destination){
        
        int index = -1;
        for (int i = 0; i<shipmentList.size(); i++){
            if (destination.getName().equals
                    (shipmentList.get(i).destination.getName())){                         
                index = shipmentList.indexOf(shipmentList.get(i));         
            }
        }
        return index;
    }
    
    /**
     * Access the length of the ArrayList shipmentLest
     * @return integer representing number of elements in shipmentList
     */
    public int length(){
        
        return shipmentList.size();
    }
    /**
     * Displays every Shipment objects toString method, 
     * Each on new line
     * @return String 
     */
    @Override
    public String toString(){
        
        String results = "";
         for (int i = 0; i<shipmentList.size(); i++){
     
         results += shipmentList.get(i).toString() + "\n";
        }
    return results;
    }
}