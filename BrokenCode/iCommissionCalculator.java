
/**
 * This interface defines the interface for a monthly commission calculator.  An implementation of this interface will be able to calculate the commission on sales in an appropriate fashion.
 */
public interface iCommissionCalculator {

	/**
	 * This indicates that an employee is to receive commissions at a probationary rate.
	 */
	public static final int PROBATIONARY = 0;
	
	/**
	 * This indicates that the employee is to receive commissions at the experienced rate.
	 */
	public static final int EXPERIENCED = 1;

	public static final int BASIC_ITEM = 0;
	
	public static final int MAINTENANCE_ITEM = 1;
	
	public static final int REPLACEMNET_ITEM = 3;
	
	public static final int CONSULTING_ITEM = 3;
	
	/**
	 * This method will obtain the name of the salesman and return it for analysis.
	 * @return The name of the salesman will be returned.
	 */
	public abstract String getName();
	
	/**
	 * This method will add a sale to the list of items that have been sold for the given month.
	 * @param salesType This is the type of sale.  The type of sale should match the items given above.
	 * @param dollarAmount This is the amount of the sale in dollars.
	 */
	public abstract void addSale(int salesType, double dollarAmount);
	
	/**
	 * This method will obtain the total sales for the salesman for the month.
	 * @return
	 */
	public abstract double getTotalSales();
	
	/**
	 * This method will set the employee experience.
	 * @param employeeExperience This parameter is either PROBATIONARY or EXPERIENCED.
	 */
	public abstract void setEmployeeExperience(int employeeExperience);
	
	
	/**
	 * This method will calculate the commission based upon the sales that have occurred.
	 * @return The total commission will be returned based on the commission formula.
	 */
	public abstract double calculateCommission();
	
	/**
	 * This method will calculate and return the bonus commission for the given salesman.
	 * @return The bonus commission will be returned.
	 */
	public abstract double calculateBonusCommission();
	
	/**
	 * This method will return the minimum sales that are necessary before a commission will be paid.
	 * @return The minimum sales before a commission will be returned.
	 */
	public abstract double getMinimumSales();
	
	
	
}
