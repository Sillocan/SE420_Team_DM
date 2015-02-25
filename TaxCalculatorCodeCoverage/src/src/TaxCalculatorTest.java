package src;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.TaxCalculatorInterface;
import application.TaxCalculator;

public class TaxCalculatorTest {
	TaxCalculatorInterface t;

	public void setUp() throws Exception {
		t = new TaxCalculator("John Smith",
				TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 40, 42);
	}

	public void tearDown() {

	}

	@Test
	public void testTaxCalculationMarriedFilingSeparately() throws Exception {
		TaxCalculatorInterface t1;
		TaxCalculatorInterface t2;

		t1 = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_SEPARATELY, 31, 25);
		t2 = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_SEPARATELY, 65, 25);
		t1.setGrossIncome(5450);
		t2.setGrossIncome(6500);
		assertEquals(0, t1.getTaxDue(), 0.01);
		assertEquals(0, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(13476);
		t2.setGrossIncome(14526);
		assertEquals(802.65, t1.getTaxDue(), 0.01);
		assertEquals(802.65, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(37999);
		t2.setGrossIncome(39049);
		assertEquals(4481.1, t1.getTaxDue(), 0.01);
		assertEquals(4481.1, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(105600);
		t2.setGrossIncome(106650);
		assertEquals(22414, t1.getTaxDue(), 0.01);
		assertEquals(22414, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(105601);
		t2.setGrossIncome(106651);
		assertEquals(22414.33, t1.getTaxDue(), 0.01);
		assertEquals(22414.33, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(184299);
		t2.setGrossIncome(185349);
		assertEquals(48384.67, t1.getTaxDue(), 0.01);
		assertEquals(48384.67, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(184300);
		t2.setGrossIncome(185350);
		assertEquals(48385, t1.getTaxDue(), 0.01);
		assertEquals(48385, t2.getTaxDue(), 0.01);
	
	}
	
	@Test
	public void testTaxCalculationHeadOfHousehold() throws Exception {
		TaxCalculatorInterface t1;
		TaxCalculatorInterface t2;

		t1 = new TaxCalculator("John Adams",
				TaxCalculatorInterface.HEAD_OF_HOUSEHOLD, 31);
		t2 = new TaxCalculator("John Adams",
				TaxCalculatorInterface.HEAD_OF_HOUSEHOLD, 65);
		
		t1.setGrossIncome(120651);
		t2.setGrossIncome(121701);
		assertEquals(23225.28, t1.getTaxDue(), 0.01);
		assertEquals(23225.28, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(190399);
		t2.setGrossIncome(191449);
		assertEquals(42754.72, t1.getTaxDue(), 0.01);
		assertEquals(42754.72, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(190400);
		t2.setGrossIncome(191450);
		assertEquals(42755, t1.getTaxDue(), 0.01);
		assertEquals(42755, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(190401);
		t2.setGrossIncome(191451);
		assertEquals(42755.33, t1.getTaxDue(), 0.01);
		assertEquals(42755.33, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(365699);
		t2.setGrossIncome(366749);
		assertEquals(100603.67, t1.getTaxDue(), 0.01);
		assertEquals(100603.67, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(365700);
		t2.setGrossIncome(366750);
		assertEquals(100604, t1.getTaxDue(), 0.01);
		assertEquals(100604, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(365701);
		t2.setGrossIncome(366751);
		assertEquals(100604.35, t1.getTaxDue(), 0.01);
		assertEquals(100604.35, t2.getTaxDue(), 0.01);

	}
	
	@Test
	public void testTaxCalculationMarriedFilingJointly() throws Exception {
		TaxCalculatorInterface t1;
		TaxCalculatorInterface t2;
		TaxCalculatorInterface t3;
		TaxCalculatorInterface t4;

		t1 = new TaxCalculator("John Adams",
				TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 31, 31);
		t2 = new TaxCalculator("John Adams",
				TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 65, 31);
		t3 = new TaxCalculator("John Adams",
				TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 31, 65);
		t4 = new TaxCalculator("John Adams",
				TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 65, 65);
		
		t1.setGrossIncome(76000);
		t2.setGrossIncome(77050);
		t3.setGrossIncome(77050);
		t4.setGrossIncome(78100);
		assertEquals(8962.5, t1.getTaxDue(), 0.01);
		assertEquals(8962.5, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(76001);
		t2.setGrossIncome(77051);
		t3.setGrossIncome(77051);
		t4.setGrossIncome(78101);
		assertEquals(8962.75, t1.getTaxDue(), 0.01);
		assertEquals(8962.75, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(142349);
		t2.setGrossIncome(143399);
		t3.setGrossIncome(143399);
		t4.setGrossIncome(144449);
		assertEquals(25549.75, t1.getTaxDue(), 0.01);
		assertEquals(25549.75, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(142350);
		t2.setGrossIncome(143400);
		t3.setGrossIncome(143400);
		t4.setGrossIncome(144450);
		assertEquals(25550, t1.getTaxDue(), 0.01);
		assertEquals(25550, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(142351);
		t2.setGrossIncome(143401);
		t3.setGrossIncome(143401);
		t4.setGrossIncome(144451);
		assertEquals(25550.28, t1.getTaxDue(), 0.01);
		assertEquals(25550.28, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(211199);
		t2.setGrossIncome(212249);
		t3.setGrossIncome(212249);
		t4.setGrossIncome(213299);
		assertEquals(44827.72, t1.getTaxDue(), 0.01);
		assertEquals(44827.72, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(211200);
		t2.setGrossIncome(212250);
		t3.setGrossIncome(212250);
		t4.setGrossIncome(213300);
		assertEquals(44828, t1.getTaxDue(), 0.01);
		assertEquals(44828, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(211201);
		t2.setGrossIncome(212251);
		t3.setGrossIncome(212251);
		t4.setGrossIncome(213301);
		assertEquals(44828.33, t1.getTaxDue(), 0.01);
		assertEquals(44828.33, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(410900);
		t2.setGrossIncome(411950);
		t3.setGrossIncome(411950);
		t4.setGrossIncome(413000);
		assertEquals(111575, t1.getTaxDue(), 0.01);
		assertEquals(111575, t2.getTaxDue(), 0.01);

	}
	
	@Test
	public void testTaxCalculationSingle() throws Exception {
		TaxCalculatorInterface t1;
		TaxCalculatorInterface t2;

		t1 = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 31);
		t2 = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 65);
		t1.setGrossIncome(5450);
		t2.setGrossIncome(6500);
		assertEquals(0, t1.getTaxDue(), 0.01);
		assertEquals(0, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(13474);
		t2.setGrossIncome(14524);
		assertEquals(802.4, t1.getTaxDue(), 0.01);
		assertEquals(802.4, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(84300);
		t2.setGrossIncome(85350);
		assertEquals(16056.25, t1.getTaxDue(), 0.01);
		assertEquals(16056.25, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(84301);
		t2.setGrossIncome(85351);
		assertEquals(16056.53, t1.getTaxDue(), 0.01);
		assertEquals(16056.53, t2.getTaxDue(), 0.01);
		t1.setGrossIncome(169999);
		t2.setGrossIncome(171049);
		assertEquals(40051.97, t1.getTaxDue(), 0.01);
		assertEquals(40051.97, t2.getTaxDue(), 0.01);

	}

	/**
	 * This test will verify that the short form of the constructor works
	 * properly. This includes all types of single filing where there is not a
	 * spouse or a spouse's age.
	 * 
	 * @throws Exception
	 *             An exception will be thrown if the main program throws the
	 *             exception.
	 */
	@Test
	public void testShortConstructor() throws Exception {
		/* Test the creation of a class of a single. */
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 31);
		assertEquals(31, t.getAge());
		assertEquals(0, t.getSpouseAge());
		assertEquals(0.0, t.getGrossIncome());
		assertEquals(TaxCalculatorInterface.SINGLE, t.getFilingStatus());

	   try {
			t = new TaxCalculator("John Adams",
					TaxCalculatorInterface.QUALIFYING_WIDOWER, -1);
			fail();
		} catch (Exception ex) {// Exception should occur here because we are
			// passing an invalid age.
		}

		try {
				t = new TaxCalculator("John Adams",
						TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 31);
				fail("You should not be able to create a class without providing spouse's age.");
			} catch (Exception e) {
				// Exception should be generated here.
			}
		
	}

	/**
	 * This test will verify that the long form of the constructor works
	 * properly. This includes all types of single filing where there is not a
	 * spouse or a spouse's age.
	 * 
	 * @throws Exception
	 *             An exception will be thrown if the main program throws the
	 *             exception.
	 */
	@Test
	public void testLongConstructor() throws Exception {
		/* Test the creation of a class of a single. */
		try {
			t = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE,
					31, 23);
			fail();
		} catch (Exception e) {
			// This exception should occur because a single person should have
			// no spouse.
		}

		
		try {
			t = new TaxCalculator("John Adams",
					TaxCalculatorInterface.MARRIED_FILING_JOINTLY, -1, 21);
			fail();
		} catch (Exception ex) {
		}

	}

	/**
	 * This method will test the set income method to make certain it is
	 * functioning properly.
	 */
	@Test
	public void testSetIncome() {
		
		//Warning --- be careful here! where is t pointing at??
		t.setGrossIncome(-1);
		assertEquals(0, t.getGrossIncome(), 0.01);
	}
	
	/**
	 * This method will verify that the getNetTaxRate calculation works properly for the module.
	 * @throws Exception
	 */
	@Test
	public void testGetNetTaxRate() throws Exception {
		TaxCalculatorInterface t1;
		TaxCalculatorInterface t2;

		t1 = new TaxCalculator("John Adams", TaxCalculator.SINGLE, 31);
		t2 = new TaxCalculator("John Adams", TaxCalculator.SINGLE, 65);
		t1.setGrossIncome(5450);
		t2.setGrossIncome(6500);
		assertEquals(0, t1.getNetTaxRate(), 0.001);
		assertEquals(0, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(13474);
		t2.setGrossIncome(14524);
		assertEquals(5.95517292563456, t1.getNetTaxRate(), 0.001);
		assertEquals(5.52464885706417, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(13475);
		t2.setGrossIncome(14525);
		assertEquals(5.95547309833024, t1.getNetTaxRate(), 0.001);
		assertEquals(5.5249569707401, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(13476);
		t2.setGrossIncome(14526);
		assertEquals(5.95614425645592, t1.getNetTaxRate(), 0.001);
		assertEquals(5.52560925237505, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(37999);
		t2.setGrossIncome(39049);
		assertEquals(11.7926787547041, t1.getNetTaxRate(), 0.001);
		assertEquals(11.4755819611258, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(38000);
		t2.setGrossIncome(39050);
		assertEquals(11.7927631578947, t1.getNetTaxRate(), 0.001);
		assertEquals(11.4756722151088, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(38001);
		t2.setGrossIncome(39051);
		assertEquals(11.793110707613, t1.getNetTaxRate(), 0.001);
		assertEquals(11.4760185398581, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(84299);
		t2.setGrossIncome(85349);
		assertEquals(19.0464892821979, t1.getNetTaxRate(), 0.001);
		assertEquals(18.8121712029432, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(84300);
		t2.setGrossIncome(85350);
		assertEquals(19.0465599051008, t1.getNetTaxRate(), 0.001);
		assertEquals(18.8122437024019, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(84301);
		t2.setGrossIncome(85351);
		assertEquals(19.0466661130947, t1.getNetTaxRate(), 0.001);
		assertEquals(18.8123513491348, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(169999);
		t2.setGrossIncome(171049);
		assertEquals(23.5601209418879, t1.getNetTaxRate(), 0.001);
		assertEquals(23.4154949751241, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(170000);
		t2.setGrossIncome(171050);
		assertEquals(23.5601470588235, t1.getNetTaxRate(), 0.001);
		assertEquals(23.4155217772581, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(170001);
		t2.setGrossIncome(171051);
		assertEquals(23.5602025870436, t1.getNetTaxRate(), 0.001);
		assertEquals(23.4155778101268, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(363149);
		t2.setGrossIncome(364199);
		assertEquals(28.580946113028, t1.getNetTaxRate(), 0.001);
		assertEquals(28.4985461245089, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(363150);
		t2.setGrossIncome(364200);
		assertEquals(28.5809582817018, t1.getNetTaxRate(), 0.001);
		assertEquals(28.4985584843493, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(363151);
		t2.setGrossIncome(364201);
		assertEquals(28.5809759576595, t1.getNetTaxRate(), 0.001);
		assertEquals(28.4985763355949, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(405449);
		t2.setGrossIncome(406499);
		assertEquals(29.2506332485713, t1.getNetTaxRate(), 0.001);
		assertEquals(29.1750779214709, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(405450);
		t2.setGrossIncome(406500);
		assertEquals(29.2506474287828, t1.getNetTaxRate(), 0.001);
		assertEquals(29.1750922509225, t2.getNetTaxRate(), 0.001);

		t1 = new TaxCalculator("John Adams",
				TaxCalculator.MARRIED_FILING_SEPARATELY, 31, 31);
		t2 = new TaxCalculator("John Adams",
				TaxCalculator.MARRIED_FILING_SEPARATELY, 65, 31);
		t1.setGrossIncome(5450);
		t2.setGrossIncome(6500);
		assertEquals(0, t1.getNetTaxRate(), 0.001);
		assertEquals(0, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(13474);
		t2.setGrossIncome(14524);
		assertEquals(5.95517292563456, t1.getNetTaxRate(), 0.001);
		assertEquals(5.52464885706417, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(13475);
		t2.setGrossIncome(14525);
		assertEquals(5.95547309833024, t1.getNetTaxRate(), 0.001);
		assertEquals(5.5249569707401, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(13476);
		t2.setGrossIncome(14526);
		assertEquals(5.95614425645592, t1.getNetTaxRate(), 0.001);
		assertEquals(5.52560925237505, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(37999);
		t2.setGrossIncome(39049);
		assertEquals(11.7926787547041, t1.getNetTaxRate(), 0.001);
		assertEquals(11.4755819611258, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(38000);
		t2.setGrossIncome(39050);
		assertEquals(11.7927631578947, t1.getNetTaxRate(), 0.001);
		assertEquals(11.4756722151088, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(38001);
		t2.setGrossIncome(39051);
		assertEquals(11.793110707613, t1.getNetTaxRate(), 0.001);
		assertEquals(11.4760185398581, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(71174);
		t2.setGrossIncome(72224);
		assertEquals(17.9486188776801, t1.getNetTaxRate(), 0.001);
		assertEquals(17.6876799955693, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(71175);
		t2.setGrossIncome(72225);
		assertEquals(17.9487179487179, t1.getNetTaxRate(), 0.001);
		assertEquals(17.6877812391831, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(71176);
		t2.setGrossIncome(72226);
		assertEquals(17.948859166011, t1.getNetTaxRate(), 0.001);
		assertEquals(17.6879240162822, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(105599);
		t2.setGrossIncome(106649);
		assertEquals(21.2253146336613, t1.getNetTaxRate(), 0.001);
		assertEquals(21.0163433318643, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(105600);
		t2.setGrossIncome(106650);
		assertEquals(21.2253787878788, t1.getNetTaxRate(), 0.001);
		assertEquals(21.0164088138772, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(105601);
		t2.setGrossIncome(106651);
		assertEquals(21.2254902889177, t1.getNetTaxRate(), 0.001);
		assertEquals(21.0165211765478, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(184299);
		t2.setGrossIncome(185349);
		assertEquals(26.2533546031178, t1.getNetTaxRate(), 0.001);
		assertEquals(26.1046296446164, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(184300);
		t2.setGrossIncome(185350);
		assertEquals(26.2533912099837, t1.getNetTaxRate(), 0.001);
		assertEquals(26.1046668465066, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(184301);
		t2.setGrossIncome(185351);
		assertEquals(26.2534386682655, t1.getNetTaxRate(), 0.001);
		assertEquals(26.1047148383338, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(205449);
		t2.setGrossIncome(206499);
		assertEquals(27.1537705221247, t1.getNetTaxRate(), 0.001);
		assertEquals(27.0156998338975, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(205450);
		t2.setGrossIncome(206500);
		assertEquals(27.1538087125821, t1.getNetTaxRate(), 0.001);
		assertEquals(27.0157384987894, t2.getNetTaxRate(), 0.001);

		t1 = new TaxCalculator("John Adams", TaxCalculator.HEAD_OF_HOUSEHOLD,
				31);
		t2 = new TaxCalculator("John Adams", TaxCalculator.HEAD_OF_HOUSEHOLD,
				65);
		t1.setGrossIncome(8000);
		t2.setGrossIncome(9050);
		assertEquals(0, t1.getNetTaxRate(), 0.001);
		assertEquals(0, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(19449);
		t2.setGrossIncome(20499);
		assertEquals(5.88667797830223, t1.getNetTaxRate(), 0.001);
		assertEquals(5.58515049514611, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(19450);
		t2.setGrossIncome(20500);
		assertEquals(5.88688946015424, t1.getNetTaxRate(), 0.001);
		assertEquals(5.58536585365854, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(19451);
		t2.setGrossIncome(20501);
		assertEquals(5.88735797645365, t1.getNetTaxRate(), 0.001);
		assertEquals(5.58582508170333, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(51649);
		t2.setGrossIncome(52699);
		assertEquals(11.5681813781487, t1.getNetTaxRate(), 0.001);
		assertEquals(11.3376914172944, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(51650);
		t2.setGrossIncome(52700);
		assertEquals(11.568247821878, t1.getNetTaxRate(), 0.001);
		assertEquals(11.3377609108159, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(51651);
		t2.setGrossIncome(52701);
		assertEquals(11.5685078701284, t1.getNetTaxRate(), 0.001);
		assertEquals(11.3380201514203, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(120649);
		t2.setGrossIncome(121699);
		assertEquals(19.2498487347595, t1.getNetTaxRate(), 0.001);
		assertEquals(19.0837640407892, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(120650);
		t2.setGrossIncome(121700);
		assertEquals(19.2498963945296, t1.getNetTaxRate(), 0.001);
		assertEquals(19.0838126540674, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(120651);
		t2.setGrossIncome(121701);
		assertEquals(19.2499689186165, t1.getNetTaxRate(), 0.001);
		assertEquals(19.0838859171248, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(190399);
		t2.setGrossIncome(191449);
		assertEquals(22.4553280216808, t1.getNetTaxRate(), 0.001);
		assertEquals(22.3321720144791, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(190400);
		t2.setGrossIncome(191450);
		assertEquals(22.4553571428571, t1.getNetTaxRate(), 0.001);
		assertEquals(22.3322016192217, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(190401);
		t2.setGrossIncome(191451);
		assertEquals(22.4554125240939, t1.getNetTaxRate(), 0.001);
		assertEquals(22.3322573399982, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(365699);
		t2.setGrossIncome(366749);
		assertEquals(27.5099658462287, t1.getNetTaxRate(), 0.001);
		assertEquals(27.4312049930607, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(365700);
		t2.setGrossIncome(366750);
		assertEquals(27.5099808586273, t1.getNetTaxRate(), 0.001);
		assertEquals(27.4312201772324, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(365701);
		t2.setGrossIncome(366751);
		assertEquals(27.5100013398924, t1.getNetTaxRate(), 0.001);
		assertEquals(27.4312408146126, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(407999);
		t2.setGrossIncome(409049);
		assertEquals(28.286503153194, t1.getNetTaxRate(), 0.001);
		assertEquals(28.213893689998, t2.getNetTaxRate(), 0.001);
		t1.setGrossIncome(408000);
		t2.setGrossIncome(409050);
		assertEquals(28.2865196078431, t1.getNetTaxRate(), 0.001);
		assertEquals(28.2139102799169, t2.getNetTaxRate(), 0.001);
	}
	
	@Test
	public void testGetTaxableIncome() throws Exception {
		TaxCalculatorInterface t1;
		TaxCalculatorInterface t2;

		t1 = new TaxCalculator("John Adams", TaxCalculator.SINGLE, 31);
		t2 = new TaxCalculator("John Adams", TaxCalculator.SINGLE, 65);

		t1.setGrossIncome(405450);
		t2.setGrossIncome(406500);
		assertEquals(400000, t1.getTaxableIncome(), 0.01);
		assertEquals(400000, t2.getTaxableIncome(), 0.01);

		t1 = new TaxCalculator("John Adams", TaxCalculator.HEAD_OF_HOUSEHOLD,
				31);
		t2 = new TaxCalculator("John Adams", TaxCalculator.HEAD_OF_HOUSEHOLD,
				65);
		t1.setGrossIncome(8000);
		t2.setGrossIncome(9050);
		assertEquals(0, t1.getTaxableIncome(), 0.01);
		assertEquals(0, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(19449);
		t2.setGrossIncome(20499);
		assertEquals(11449, t1.getTaxableIncome(), 0.01);
		assertEquals(11449, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(19450);
		t2.setGrossIncome(20500);
		assertEquals(11450, t1.getTaxableIncome(), 0.01);
		assertEquals(11450, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(19451);
		t2.setGrossIncome(20501);
		assertEquals(11451, t1.getTaxableIncome(), 0.01);
		assertEquals(11451, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(51649);
		t2.setGrossIncome(52699);
		assertEquals(43649, t1.getTaxableIncome(), 0.01);
		assertEquals(43649, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(51650);
		t2.setGrossIncome(52700);
		assertEquals(43650, t1.getTaxableIncome(), 0.01);
		assertEquals(43650, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(51651);
		t2.setGrossIncome(52701);
		assertEquals(43651, t1.getTaxableIncome(), 0.01);
		assertEquals(43651, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(120649);
		t2.setGrossIncome(121699);
		assertEquals(112649, t1.getTaxableIncome(), 0.01);
		assertEquals(112649, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(120650);
		t2.setGrossIncome(121700);
		assertEquals(112650, t1.getTaxableIncome(), 0.01);
		assertEquals(112650, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(120651);
		t2.setGrossIncome(121701);
		assertEquals(112651, t1.getTaxableIncome(), 0.01);
		assertEquals(112651, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(190399);
		t2.setGrossIncome(191449);
		assertEquals(182399, t1.getTaxableIncome(), 0.01);
		assertEquals(182399, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(190400);
		t2.setGrossIncome(191450);
		assertEquals(182400, t1.getTaxableIncome(), 0.01);
		assertEquals(182400, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(190401);
		t2.setGrossIncome(191451);
		assertEquals(182401, t1.getTaxableIncome(), 0.01);
		assertEquals(182401, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(365699);
		t2.setGrossIncome(366749);
		assertEquals(357699, t1.getTaxableIncome(), 0.01);
		assertEquals(357699, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(365700);
		t2.setGrossIncome(366750);
		assertEquals(357700, t1.getTaxableIncome(), 0.01);
		assertEquals(357700, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(365701);
		t2.setGrossIncome(366751);
		assertEquals(357701, t1.getTaxableIncome(), 0.01);
		assertEquals(357701, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(407999);
		t2.setGrossIncome(409049);
		assertEquals(399999, t1.getTaxableIncome(), 0.01);
		assertEquals(399999, t2.getTaxableIncome(), 0.01);
		t1.setGrossIncome(408000);
		t2.setGrossIncome(409050);
		assertEquals(400000, t1.getTaxableIncome(), 0.01);
		assertEquals(400000, t2.getTaxableIncome(), 0.01);
	}
	@Test
	public void testStandardDeduction() throws Exception {
		// Set up to test single.
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 31);
		assertEquals(5450, t.getStandardDeduction(), 0.01);

		t = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 65);
		assertEquals(5450 + 1050, t.getStandardDeduction(), 0.01);

		// Set up to test married filing separately.
		t = new TaxCalculator("John Adams",
				TaxCalculatorInterface.MARRIED_FILING_SEPARATELY, 31, 31);
		assertEquals(5450, t.getStandardDeduction(), 0.01);

		t = new TaxCalculator("John Adams",
				TaxCalculatorInterface.MARRIED_FILING_SEPARATELY, 65, 66);
		assertEquals(5450 + 1050, t.getStandardDeduction(), 0.01);

		// Set up to test head of household.
		t = new TaxCalculator("John Adams",
				TaxCalculatorInterface.HEAD_OF_HOUSEHOLD, 31);
		assertEquals(8000, t.getStandardDeduction(), 0.01);


	}
	
	@Test
	public void testReturnRequired() throws Exception {
		// Set up to test single.
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 31);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());

		t.setGrossIncome(8950.00);
		assertEquals(true, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.HEAD_OF_HOUSEHOLD, 31);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 31, 32);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_SEPARATELY, 31, 32);
		t.setGrossIncome(8949.00);
		assertEquals(true, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.QUALIFYING_WIDOWER, 31);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		//TODO can't figure out default case
//		t = new TaxCalculator("John Adams", -5, 31);
//		t.setGrossIncome(8949.00);
//		assertEquals(true, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.QUALIFYING_WIDOWER, 66);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.HEAD_OF_HOUSEHOLD, 66);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 66, 66);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_SEPARATELY, 66, 66);
		t.setGrossIncome(8949.00);
		assertEquals(true, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.SINGLE, 66);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		//TODO can't figure out default case
//		t = new TaxCalculator("John Adams", -5, 66);
//		t.setGrossIncome(8949.00);
//		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 66, 33);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
		
		t = new TaxCalculator("John Adams", TaxCalculatorInterface.MARRIED_FILING_JOINTLY, 33, 66);
		t.setGrossIncome(8949.00);
		assertEquals(false, t.isReturnRequired());
	}
}
