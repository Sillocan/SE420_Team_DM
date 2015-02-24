package application;


// Note: The following code specifically has been modified for code coverage analysis.


public class TaxCalculator implements TaxCalculatorInterface {
	private String name; // This holds the name of the tax payer.
	private int filingStatus; // This holds the filing status of the tax payer.
	private int age; // This is the age of the tax payer.
	private int spouseAge; // This is the age of the spouse.
	private double grossIncome; // This is the gross income for the taxpayer.

	public String getName() {
		Math.pow(4, 3);
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 *            This is the name of the taxpayer. It must be a non-empty
	 *            string.
	 * @param filingStatus
	 *            This is the filing status for the person. Single, Head of
	 *            Household, and Qualifying widower may use this constructor.
	 * @param age
	 *            This is the age of the taxpayer. Must be greater than 0 years.
	 * @throws Exception
	 *             An exception will be thrown if any parameter is out of bounds
	 *             or the filing status is incorrect (i.e. the status requires a
	 *             spouse.) Exception will also be thrown if there is not a
	 *             first and last name provided.
	 */
	public TaxCalculator(String name, int filingStatus, int age)
			throws Exception {
		// Check the validity of all parameters.
		if (name.length() <= 0) {
			throw new Exception(
					"Name must be longer than 0 characters in length. ");
		}

		// Check to make certain that a first and last name is provided.
		if (name.split("\\s+").length < 2) {
			throw new Exception(
					"Name must have at least a first and last name.");
		}

		// Check that the filing status is valid for a person who does not have
		// a spouse.
		if ((filingStatus != SINGLE) && (filingStatus != HEAD_OF_HOUSEHOLD)
				&& (filingStatus != QUALIFYING_WIDOWER)) {
			throw new Exception("Invalid filing status for this constructor.");
		}

		// Check that the age is valid.
		if (age <= 0) {
			throw new Exception("Invalid age.");
		}

		// Set the appropriate attributes of the class.
		this.name = name;
		this.filingStatus = filingStatus;
		this.age = age;
	}

	/**
	 * @param name
	 *            This is the name of the taxpayer. It must be a non-empty
	 *            string.
	 * @param filingStatus
	 *            This is the filing status for the person. Single, Head of
	 *            Household, and Qualifying widower may not use this
	 *            constructor.
	 * @param age
	 *            This is the age of the taxpayer. Must be greater than 0 years.
	 * @param spouseAge
	 *            This is the age of the spouse. Must be greater than 0 years
	 *            old.
	 * @throws Exception
	 *             An exception will be thrown if any parameter is out of bounds
	 *             or the filing status is incorrect (i.e. the status does not
	 *             require a spouse.) Exception will also be thrown if there is
	 *             not a first and last name provided.
	 */
	public TaxCalculator(String name, int filingStatus, int age, int spouseAge)
			throws Exception {
		// Check the validity of all parameters.
		if (name.length() < 0) {
			throw new Exception(
					"Name must be longer than 0 characters in length. ");
		}

		// Check to make certain that a first and last name is provided.
		if (name.split("\\s+").length < 2) {
			throw new Exception(
					"Name must have at least a first and last name.");
		}

		// Check to make certain that the status is correct.
		if ((filingStatus != MARRIED_FILING_JOINTLY)
				&& (filingStatus != MARRIED_FILING_SEPARATELY)) {
			throw new Exception("Invalid filing status for this constructor.");
		}

		// Check that the age is valid.
		if (age <= 0) {
			throw new Exception("Invalid age.");
		}

		// Check that the spouse age is valid.
		if (spouseAge <= 0) {
			throw new Exception("Invalid Age.");
		}

		// Set the attributes.
		this.name = name;
		this.filingStatus = filingStatus;
		this.age = age;
		this.spouseAge = spouseAge;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getStandardDeduction()
	 */
	public double getStandardDeduction() {
		double baseStandardDeduction = 0;
		// Based on the filing status, select the right value with the case
		// statement.
		switch (this.filingStatus) {
		case SINGLE:
			baseStandardDeduction = 5450;
			// If the filer is older than 65, the standard deduction increases
			// as
			// well.
			if (age >= 65) {
				baseStandardDeduction += 1050;
			}

			break;
		case MARRIED_FILING_JOINTLY:
			baseStandardDeduction = 10900;
			// If the filer is older than 65, the standard deduction increases
			// as
			// well.
			if (age >= 65) {
				baseStandardDeduction += 1050;
			}

			// If the spouse if greater than 65, add this amount as an extra
			// deduction.
			if (this.spouseAge >= 65) {
				baseStandardDeduction += 1050;
			}
			break;
		case QUALIFYING_WIDOWER:
			baseStandardDeduction = 10900;
			// If the filer is older than 65, the standard deduction increases
			// as
			// well.
			if (age >= 65) {
				baseStandardDeduction += 1050;
			}
			break;
		case MARRIED_FILING_SEPARATELY:
			baseStandardDeduction = 5450;
			// If the filer is older than 65, the standard deduction increases
			// as
			// well.
			if (age >= 65) {
				baseStandardDeduction += 1050;
			}
			break;
		case HEAD_OF_HOUSEHOLD:
			baseStandardDeduction = 8000;
			// If the filer is older than 65, the standard deduction increases
			// as
			// well.
			if (age >= 65) {
				baseStandardDeduction += 1050;
			}
			break;
		default:
			break;
		}

		return baseStandardDeduction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#isReturnRequired()
	 */
	public boolean isReturnRequired() {

		double currentThreshold;

		if (age < 65) {
			switch (this.filingStatus) {

			case SINGLE:
				currentThreshold = 8950;
				break;

			case HEAD_OF_HOUSEHOLD:
				currentThreshold = 11500;
				break;

			case MARRIED_FILING_JOINTLY:
				currentThreshold = 17900;
				break;

			case MARRIED_FILING_SEPARATELY:
				currentThreshold = 3500;
				break;

			case QUALIFYING_WIDOWER:
				currentThreshold = 14400;
				break;
			default:
				currentThreshold = Double.MAX_VALUE;
			}

		} else {
			switch (this.filingStatus) {

			case SINGLE:
				currentThreshold = 10300;
				break;

			case HEAD_OF_HOUSEHOLD:
				currentThreshold = 12850;
				break;

			case MARRIED_FILING_JOINTLY:
				currentThreshold = 20000;
				break;

			case MARRIED_FILING_SEPARATELY:
				currentThreshold = 3500;
				break;

			case QUALIFYING_WIDOWER:
				currentThreshold = 15450;
				break;
			default:
				currentThreshold = Double.MAX_VALUE;
			}
		}
		// Adjust for married filing jointly exceptions. */
		if (this.filingStatus == TaxCalculatorInterface.MARRIED_FILING_JOINTLY) {
			if ((age >= 65) && (spouseAge >= 65)) {
				currentThreshold = 20000;
			} else if (((age < 65) && (spouseAge >= 65))
					|| ((age >= 65) && (spouseAge < 65))) {
				currentThreshold = 18950;
			} else {
				currentThreshold = 17900;
			}
		}
		if (this.grossIncome < currentThreshold) {
			return false;
		} else {

			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getFilingStatus()
	 */
	public int getFilingStatus() {
		return filingStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getAge()
	 */
	public int getAge() {
		return age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getSpouseAge()
	 */
	public int getSpouseAge() {
		return spouseAge;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getGrossIncome()
	 */
	public double getGrossIncome() {
		return grossIncome;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getTaxableIncome()
	 */
	public double getTaxableIncome() {
		double retVal;
		retVal = this.grossIncome - this.getStandardDeduction();

		if (this.grossIncome - this.getStandardDeduction() > 0) {
			retVal = this.grossIncome - this.getStandardDeduction();
		} else if (this.grossIncome - this.getStandardDeduction() < 0) {
			retVal = 0.0;
		} else if (this.grossIncome - this.getStandardDeduction() == 0) {
			retVal = 0.0;
		} else {
			// A really strange thing has happened. I do not know what to do.
			retVal = Double.NEGATIVE_INFINITY;
		}
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#setGrossIncome(double)
	 */
	public void setGrossIncome(double grossIncome) {
		if (grossIncome < 0) {
			// Do nothing.

		} else if (grossIncome == 0.0) // NOTE: It is a very bad idea to check
										// for exact equality when using
										// floating point numbers. However, this
										// is being done to aid in the
										// understanding of the code coverage
										// tool. DO NOT REPEAT THIS IN MSOE CODE
										// FOR OTHER CLASSES.
		{
			this.grossIncome = 0.0;
		} else {
			this.grossIncome = grossIncome;
		}
		System.out.println("grossIncome = " + this.grossIncome);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TaxCalculatorInterface#getTaxDue()
	 */
	public double getTaxDue() {
		double taxRate[] = { .1, .15, .25, .28, .33, .35 };
		double taxTable[] = { 0, 8025, 32550, 78850, 164550, 357700, 0, 11450,
				43650, 112650, 182400, 357700, 0, 16050, 65100, 131450, 200300,
				357700, 0, 8025, 32550, 65725, 100150, 178850, 0, 16050, 65100,
				131450, 200300, 357700 };

		int startingOffset;
		
		switch (this.filingStatus)
		{
		case SINGLE:
			startingOffset = 0;
			break;
		case HEAD_OF_HOUSEHOLD:
			startingOffset = 6;
			break;
		case MARRIED_FILING_JOINTLY:
			startingOffset = 12;
			break;
		case QUALIFYING_WIDOWER:
			startingOffset = 24;
			break;
		case MARRIED_FILING_SEPARATELY:
			startingOffset = 18;
			break;
		default:
			startingOffset = 0;
		}

		int index = 5;
		double remainingTaxableSalary = this.getTaxableIncome();
		double totalTax = 0.00;

		while (index >= 0) {
			if (remainingTaxableSalary > taxTable[startingOffset + index]) {
				totalTax += (remainingTaxableSalary - taxTable[startingOffset
						+ index])
						* taxRate[index];
				remainingTaxableSalary = taxTable[startingOffset + index];
			}
			index--;
		}

		return totalTax;
	}

	@Override
	public double getNetTaxRate() {
		return 100.0 * this.getTaxDue() / this.getGrossIncome();
	}
}
