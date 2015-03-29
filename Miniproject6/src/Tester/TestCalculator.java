package Tester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import application.*;


/** This class will... 
 * @author Chris Silvano, Alex Spradlin, Casey Layne
 * */
public class TestCalculator {

	
	iCommissionCalculator calculator;

	
	/** This method tests the code that handles the creation of a salesman
	 * that is neither probationary nor experienced. It then tests to see what
	 * the minimum sales must be and tests the addSale() method in CommissionCalculator
	 * for an invalid dollar amount.
	 * @author Alex Spradlin */
	@Test 
	public void testIncorrect() {
		calculator = new CommissionCalculator("Bob", 2);

		//test getMinimumSales()
		assertEquals(0, calculator.getMinimumSales(), 0);

		//test setExperience()
		calculator.setEmployeeExperience(3);

		//test SalesTransaction()
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, -5);
		calculator.addSale(9, 1000);

		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
	}


	/** This method tests the creation of a CommissionCalculator with parameters
	 * for a probationary salesman. It also tests setting the employee experience to
	 * probationary, ensuring that the name of the salesman matches with the parameter
	 * passed to the CommissionCalculator's constructor, and checks that the minimum sales
	 * required of a probationary salesman before earning commission matches with that
	 * stated in the assignment.
	 * @author Alex Spradlin */
	@Test 
	public void testProbationary() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.PROBATIONARY);

		//test setExperience()
		calculator.setEmployeeExperience(iCommissionCalculator.PROBATIONARY);

		//test getName()
		assertEquals("Bob", calculator.getName());

		//test getMinimumSales()
		assertEquals(2000, calculator.getMinimumSales(), 0);


		//boundaries are 500, 1999, 2000, 2001, 25000, 49999, 50000, 50001, 60000 
	}


	/** This method tests the lower sales boundaries for a probationary salesman. 
	 * It tests a unique value below $2000, the value $1999, the value $2000, and
	 * the value $2001 to see what the commission and bonus commission should be.
	 * @author Alex Spradlin */
	@Test 
	public void testProbationaryLowerBound() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.PROBATIONARY);

		calculator.addSale(iCommissionCalculator.CONSULTING_ITEM, 500); //3% for 500

		//unique lower value
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 1499); //1999

		//the minimum minus 1
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.REPLACEMNET_ITEM, 1); //2000

		//the minimum
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 1); //2001

		//one over the minimum
		assertEquals(0.03, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		assertEquals(2001, calculator.getTotalSales(), 0);
	}



	/** This method tests the upper sales boundaries for a probationary salesman. 
	 * It tests a unique value between $2000 and $50000, the value $49999, the value $50000, and
	 * the value $50001 to see what the commission and bonus commission should be.
	 * @author Alex Spradlin */
	@Test 
	public void testUpperBound() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.PROBATIONARY);

		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 9999); //2% rate for 9999

		//this is a unique middle value
		assertEquals(159.98, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 40000); //2% rate for 49999

		//this is the upper minus 1
		assertEquals(959.98, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 1); //2% rate for 50000

		//this is the upper
		assertEquals(960.0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 1); //2% rate for 50001

		//this is 1 over the upper
		assertEquals(960.02, calculator.calculateCommission(), 0);
		assertEquals(0.005, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 9); //2% rate for 50010

		//this is unique upper 
		assertEquals(960.20, calculator.calculateCommission(), 0.005);
		assertEquals(0.05, calculator.calculateBonusCommission(), 0.005);
	}


	/** This method tests the creation of a CommissionCalculator with parameters
	 * for an experienced salesman. It also tests setting the employee experience to
	 * experience and checks that the minimum sales required of an experienced salesman 
	 * before earning commission matches with that stated in the assignment.
	 * @author Alex Spradlin */
	@Test 
	public void testExperienced() {

		calculator = new CommissionCalculator("Betty", iCommissionCalculator.EXPERIENCED);

		//test setExperience()
		calculator.setEmployeeExperience(iCommissionCalculator.EXPERIENCED);

		//test getMinimumSales()
		assertEquals(5000, calculator.getMinimumSales(), 0);


		//boundaries are 500, 4999, 5000, 5001, 25000, 99999, 100000, 100001, 200000 
	}


	/** This method...
	 * @author */
	@Test 
	public void testExpLowerBound() {

	}


	/** This method...
	 * @author */
	@Test 
	public void testExpUpperBound() {

	}


	/** This method will test a missing branch in SalesTransaction
	 * regarding the replacement item property with an invalid
	 * transaction type
	 * 
	 * @TODO - it is not hitting the code in the right place, but it
	 * is covering something else that I do not know about
	 * @author Chris Silvano */
	@Test //(expected=Exception.class)
	public void calculatorException(){

		//assign values to a commission calculator
		calculator = new CommissionCalculator("Bob", 2);

		//try replacement type when adding sale to hit missing branch
		calculator.addSale(iCommissionCalculator.REPLACEMNET_ITEM, 100);
	}
}
