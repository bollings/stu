package a3_bollings;

/*
 * Shipment class: Lab 3 Summer 2016
 * Wendi Jollymore
 * DO NOT EDIT THIS CLASS
 */


/**
 * The Shipment class represents a single shipment going 
 * to a specific province (Destination).  Each shipment 
 * has a Destination province and a total value of items shipped.
 * 
 * @author Wendi Jollymore
 * @see Destination
 * @see ShipmentList
 */
public class Shipment {
    
    /** The Destination province for this shipment. */
    public Destination destination = Destination.ON;
    
    // the total value of this shipment
    private double shipValue = 0;
    
    /**
     * Constructs an empty Shipment object with a Destination
     * of Ontario and a shipping value of $0.
     */
    public Shipment() {}
    
    /**
     * Constructs a shipment to a specific Destination province
     * and initial shipping value.
     * 
     * @param dest the province this shipment is going to
     * @param value the total value of this shipment
     */
    public Shipment(Destination dest, double value) {
        
        destination = dest;
        setShipValue(value);
    }
        
    /**
     * Places a valid value into the shippingValue member. The
     * shipping value must be 0 or greater.
     * 
     * @param value the total value of this shipment
     * @throws IllegalArgumentException if the shipment value is less than 0
     */
    public void setShipValue(double value) {
        
        // ensure value is 0 or greater, otherwise throw exception
        if (value < 0)
            throw new 
                IllegalArgumentException("Error: Shipment value must be 0 or "
                        + "more.");
        else  // value is valid
            shipValue = value;
    }
    
    /**
     * Retrieves the value of this shipment.
     * 
     * @return the total value of this shipment
     */
    public double getShipValue() { return shipValue; }
  
    /**
     * Adds a dollar amount to the shipment's current value.
     * The value must be greater than 0, otherwise an exception
     * is thrown.
     * 
     * @param value the value to add to this shipment
     */
    public void addShipValue(double value)  {
        
        // ensure value is greater than 0, otherwise throw exception
        if (value <= 0)
            throw new IllegalArgumentException("Error: Shipment value must be "
                    + "greater than 0.");
        else // value is valid
            shipValue += value;
    }
    
    /**
     * Returns a formatted String representing this shipment object.
     * 
     * @return this Shipment as a String
     */
   
    @Override
    public String toString() {
        
        // return a formatted String containing destination
        // name and shipment value
        return String.format("%s $%.2f", destination.getName(),
            shipValue);
    }
}
