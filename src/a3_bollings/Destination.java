package a3_bollings;

/**
 * This enumeration contains two constants:
 * The full name of the province/territory associated with the destination code
 * The price of sending a shipment to that province/territory destination code
 * Includes:
 * getName, and getCost methods to access the constants
 * @author Stuart Bollinger
 */
public enum Destination {
    
    AB ("Alberta", 21.95),
    BC ("British Columbia", 25.95),
    MN ("Manitoba", 21.95),
    NB ("New Brunswick", 21.95),
    NS ("Nova Scotia", 22.95),
    NT ("Northwest Territories", 27.95),
    NU ("Nunavut",27.95),
    ON ("Ontario", 12.49),
    PE ("Prince Edward Island", 23.49),
    QC ("Quebec", 16.95),
    SK ("Saskatchewan", 21.95),
    YT ("Yukon", 29.95);
    
    private String name;
    private double cost;
    
    //Constructor accepting two arguments, province/territory name and cost
    Destination(String name, double cost){
        this.name = name;
        this.cost = cost;
    }
    
    /**
     * Accessor method for name
     * @return name of the province/territory
     */
    public String getName(){
        return name;
    }
    
    /**
     * Accessor method for cost
     * @return cost to of Shipment to that location
     */
    public double getCost(){
        return cost;
    }
}