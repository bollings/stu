package a3_bollings;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class repeatedly creates Shipment objects and adds them to shipmentList
 * based on user input for Province code and shipment value,
 * Until the user signals they are done inputing shipments,
 * At which point: the shipments populating shipmentList are printed,
 * Followed by the printing of the shipment with the greatest cost,
 * A list of shipments with the greatest cost is printed if multiple 
 * Shipment objects in shipmentList are equal
 * @author Stuart Bollinger
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Variables to be populated with user input
        String location = "";
        double value = 0;
        String keepInputing = "";
        
        //Variables to manage user input
        boolean moreShipments = true;
        boolean isLegit = false;
        
        //declare Scanner and empty ShipmentList 
        Scanner input = new Scanner(System.in);       
        ShipmentList shipmentList = new ShipmentList();
        
        //Create Shipment object with destination Ontario and value of 0
        Shipment s1 = new Shipment();
        Destination d1 = s1.destination;
        
        
        /* do-while loop containing 3 do-while loops to manage the creation of
        Shipment objects that are added to the Shipment list using user input
        First is the destination of the shipment,
        Second is the value of the shipment,
        Third is prompt to determine if user wants to enter more Shipments 
        to the ShipmentList - if yes, the loop restarts here
        */
        do {
        /* User inputed province/territory codes are not case sensitive, 
        Loop continues until a valid code is entered, 
        Displays error message along with a repeated prompt for the code
        if user inputs invalid code
         */
            do {
                try{
                    System.out.print("Enter Destination Province Code: ");
                    location = input.nextLine();      
                    d1 = Destination.valueOf(location.toUpperCase()); 
                    isLegit = true;
                } catch (Exception ex){
                    System.out.println("Error: Not a Valid Province Code.");    
                    isLegit = false;
                }
            }while (!isLegit);

        /* User input for value of the Shipment cannot be a negative number,
        Cannot include any non-digit keys (one decimal accepted),
        Loop continues until valid Shipment value is entered,
        Displays one of two error messages depending on validity issue
         */
            do {
                try{                   
                    System.out.print("Enter Total Value of Shipment: ");
                    input = new Scanner(System.in);
                    value = input.nextDouble();  
                    s1 = new Shipment(d1, value);               
                    shipmentList.add(s1);
                    isLegit = true;
                }catch(InputMismatchException ex){
                    System.out.println("Error: Value of Shipment must be a "
                            + "number.");
                    isLegit = false;
                }catch(Exception ex){
                    System.out.println(ex.getMessage());     
                    isLegit = false;
                }
            }while(!isLegit);
            
        /* Prompts user to enter Y/N if they wish to add another Shipment
        object to the ShipmentList,
        User input is not case sensitive,
        Invalid user input will result in the prompt repeating,
        //TODO: add try-catch block displaing appropriate error message (issues)
        */ 
            do{      
                    isLegit = false;
                    System.out.print("Add another shipment(Y/N)?: "); 
                    input = new Scanner(System.in);
                    keepInputing = input.nextLine();
                    if (keepInputing.toUpperCase().equals("N")){                       
                        moreShipments = false;
                    }
                    if ((keepInputing.toUpperCase().equals("N") 
                            || keepInputing.toUpperCase().equals("Y"))){
                        isLegit = true;
                    }                                                
            }while(!isLegit);
        } while(moreShipments);
        
        //Print the Shipment objects populating shipmentList, each on seperate line
        System.out.println(shipmentList);
        
        
        /* Determine Shipment in ShipmentList with greatest cost, and its index,
        This includes the values entered by users, 
        Combined with the standard cost of sending a Shipment to
        that destination
        */       
        Shipment greatestShipment = shipmentList.get(0);        
        int index = 0;
        for (int i = 1; i<shipmentList.length(); i++){
            if ((shipmentList.get(i).getShipValue()  
                    + (shipmentList.get(i).destination.getCost()))  
                    > (greatestShipment.getShipValue()  
                    +greatestShipment.destination.getCost())){
                greatestShipment = shipmentList.get(i);
                index = i;
            }     
        }   
        
        /* Add Shipment in shipmentList with the greatest cost to 
        greatestShipmentList,
        Along with any other Shipments in shipmentList with equal cost 
        */
        ShipmentList greatestShipmentList = new ShipmentList();
        greatestShipmentList.add(greatestShipment);
        for (int j = 0; j<shipmentList.length(); j++){
            if (j != index){
                if ((shipmentList.get(j).getShipValue() 
                        + (shipmentList.get(j).destination.getCost())) 
                        ==(greatestShipment.getShipValue() 
                        + greatestShipment.destination.getCost())){
                    Shipment greatestShips = shipmentList.get(j);
                    greatestShipmentList.add(greatestShips);       
                }     
            }
        }
        
        //Print the Shipments in greatestShipmentList, each on seperate line
        System.out.println("Most expensive Shipment:\n" + greatestShipmentList);
    }
}