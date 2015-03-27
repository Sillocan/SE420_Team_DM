package Tester;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import application.*;


/** This class will... 
 * @author Chris Silvano, Alex Spradlin, Casey Layne
 * */
public class TestCalculator {

	iCommissionCalculator calculator;


	/** This method...
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


	/** This method...
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


	/** This method tests the...
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



	/** This method...
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


	/** This method...
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
	 * @author  */
	@Test 
	public void testExpLowerBound() {

	}


	/** This method...
	 * @author  */
	@Test 
	public void testExpUpperBound() {

	}
}
