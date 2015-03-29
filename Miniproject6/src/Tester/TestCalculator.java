package Tester;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import application.*;

/** This class will... 
 * @author Chris Silvano, Alex Spradlin, Casey Layne
 * */
public class TestCalculator {

	iCommissionCalculator calculator;

	/** This method tests an employee with no commission
	 *  - author Alex Spradlin */
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

	/** This method tests the lower commission bound for probation 
	 * - author Alex Spradlin and Chris Silvano */
	@Test 
	public void testProbationaryLowerBound() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.PROBATIONARY);

		calculator.addSale(iCommissionCalculator.CONSULTING_ITEM, 500); //3% for 500

		//unique lower value for probation with basic rate
		//no commission
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 1499); //1999

		//the minimum minus 1 for probation with basic rate
		//no commission
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.REPLACEMNET_ITEM, 1); //2000

		//the minimum for probation with basic rate
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		calculator.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 1); //2001
		
		//one over the minimum for probation with basic rate
		assertEquals(0.03, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		assertEquals(2001, calculator.getTotalSales(), 0);
	}
	
	/** This method tests the middle commission value for probation
	 *  - author Alex Spradlin and Chris Silvano */
	@Test 
	public void testProbationaryMiddle() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.PROBATIONARY);

		//test setExperience()
		calculator.setEmployeeExperience(iCommissionCalculator.PROBATIONARY);

		//test getName()
		assertEquals("Bob", calculator.getName());

		//test getMinimumSales()
		assertEquals(2000, calculator.getMinimumSales(), 0);
		
		//add a sale of $25000 for a middle value
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 25000);
		
		//test the probation commission and bonus commission
		assertEquals(460.0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
	}

	/** This method tests the upper commission bound for probation 
	 * - author Alex Spradlin and Chris Silvano */
	@Test 
	public void testProbationaryUpperBound() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.PROBATIONARY);
		
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 9999); //2% rate for 9999
		
		//this is a unique middle value for probation with basic rate
		assertEquals(159.98, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 40000); //2% rate for 49999
		
		//this is the upper minus 1 for probation with basic rate
		assertEquals(959.98, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 1); //2% rate for 50000
		
		//this is the upper bound for probation with basic rate
		assertEquals(960.0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 1); //2% rate for 50001

		//this is 1 over the upper for probation with basic rate
		//bonus commission applies
		assertEquals(960.02, calculator.calculateCommission(), 0);
		assertEquals(0.005, calculator.calculateBonusCommission(), 0);
		
		calculator.addSale(iCommissionCalculator.BASIC_ITEM, 9); //2% rate for 50010

		//this is unique upper probation with basic rate
		//bonus commission applies
		assertEquals(960.20, calculator.calculateCommission(), 0.005);
		assertEquals(0.05, calculator.calculateBonusCommission(), 0.005);
	}

	/** This method tests the lower commission bound for experienced 
	 * - author Chris Silvano */
	@Test 
	public void testExpLowerBound() {

		calculator = new CommissionCalculator("Bob", iCommissionCalculator.EXPERIENCED);

		calculator.addSale(iCommissionCalculator.CONSULTING_ITEM, 500); //3% for 500

		//unique lower value for experienced with basic rate
		//no commission
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 4499); //4999

		//the minimum minus 1 for experienced with basic rate
		//no commission
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);

		calculator.addSale(iCommissionCalculator.REPLACEMNET_ITEM, 1); //5000

		//the minimum for experienced with basic rate
		assertEquals(0, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		calculator.addSale(iCommissionCalculator.MAINTENANCE_ITEM, 1); //5001
		
		//one over the minimum for experienced with basic rate
		assertEquals(0.06, calculator.calculateCommission(), 0);
		assertEquals(0, calculator.calculateBonusCommission(), 0);
		
		assertEquals(5001, calculator.getTotalSales(), 0);
	}
	
	/** This method...
	 * @author  */
	@Test 
	public void testExpMiddle() {
		//boundaries are 25000,
	}

	/** This method...
	 * @author  */
	@Test 
	public void testExpUpperBound() {

		//boundaries are 99999, 100000, 100001, 200000 
	}
	
}
