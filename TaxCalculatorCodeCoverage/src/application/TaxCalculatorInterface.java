package application;
public interface TaxCalculatorInterface {

	/**
	 * Indicates a single, unmarried filer.
	 */
	public static final int SINGLE = 0;

	/**
	 * Indicates a person filing as a head of the household.
	 */
	public static final int HEAD_OF_HOUSEHOLD = -1;

	/**
	 * Indicates a married couple filing jointly.
	 */
	public static final int MARRIED_FILING_JOINTLY = -2;

	/**
	 * Indicates a qualifying widower filing.
	 */
	public static final int QUALIFYING_WIDOWER = -4;

	/**
	 * Indicates a married couple which has chosen to file separately.
	 */

	public static final int MARRIED_FILING_SEPARATELY = -3;

	/**
	 * Obtain the filing status for the tax return.
	 * 
	 * @return The filing status value will be returned.
	 */
	public abstract int getFilingStatus();

	/**
	 * Obtain the age of the filer. Age must be greater than 0.
	 * 
	 * @return The age of the filer.
	 */
	public abstract int getAge();

	/**
	 * Obtain the age of the spouse. If there is no spouse based on the filing
	 * type, a value of 0 will be returned.
	 * 
	 * @return The age of the spouse.
	 */
	public abstract int getSpouseAge();

	
	/**
	 * This method will set the gross income. The gross income must be greater
	 * than or equal to 0. Otherwise, the change will not occur.
	 * 
	 * @param grossIncome
	 *            This is the gross income for the taxpayer.
	 */
	public abstract void setGrossIncome(double grossIncome);
	
	/**
	 * Obtain the gross income.
	 * 
	 * @return The gross income will be returned.
	 */
	public abstract double getGrossIncome();
	
	/**
	 * This routine will determine if a tax return is required. A tax return is
	 * required based on income and filing status.
	 * 
	 * @return true will be returned if a tax return is required. False will be
	 *         returned otherwise.
	 */
	public abstract boolean isReturnRequired();
	
	/**
	 * Calculate the standard deduction.
	 * 
	 * @return This method will return the standard deduction.
	 */
	public abstract double getStandardDeduction();

	/**
	 * Obtain the taxable income. Taxable income is the gross income minus the
	 * standard deduction.  Taxable income must never be less than 0.
	 * 
	 * @return The taxable income will be returned.
	 */
	public abstract double getTaxableIncome();

	/**
	 * Calculate the tax due. Calculation will be based upon IRS tax tables.
	 * 
	 * @return The tax due will be returned.
	 */
	public abstract double getTaxDue();

	/**
	 * Calculate the net tax rate.  The net tax rate is defined as the tax due divided by the gross income.
	 * @return The net tax rate will be returned.  The value is returned as a percent.
	 */
	public abstract double getNetTaxRate();
	
	/**
	 * This method will obtain the name of the tax payer.
	 * @return The name of the taxpayer is returned.
	 */
	public abstract String getName();

	/**
	 * This method will set the name of the tax payer to the appropriate value.
	 * @param name This is the name of the taxpayer.
	 */
	public abstract void setName(String name);
}