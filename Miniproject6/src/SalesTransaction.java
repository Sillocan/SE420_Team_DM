

/**
 * This class holds information about the amount of a transaction and the type
 * of the transaction.
 * 
 * 
 */
public class SalesTransaction {
	/**
	 * This attribute is the type of the transaction. Must be one of the types
	 * defined in the iCommissionCalculator.
	 */
	private int transactionType;

	/**
	 * This is the amount of the transaction, in dollars and cents.
	 */
	private double transactionAmount;

	/**
	 * This constructor will instantiate a new instance of a transaction type.
	 * 
	 * @param transactionType
	 *            This is the type of the transaction. It must be one of the
	 *            ones defined in the iCommissionCalculator.
	 * @param transactionAmount
	 *            This si the dollar amount of the transaction. It must be
	 *            positive.
	 * @throws Exception
	 *             an Exception will be thrown if the amount is negative or the
	 *             transaction type is invalid.
	 */
	public SalesTransaction(int transactionType, double transactionAmount)
			throws Exception {
		super();

		if ((transactionType != iCommissionCalculator.BASIC_ITEM)
				&& (transactionType != iCommissionCalculator.CONSULTING_ITEM)
				&& (transactionType != iCommissionCalculator.MAINTENANCE_ITEM)
				&& (transactionType != iCommissionCalculator.REPLACEMNET_ITEM)) {
			throw new Exception("Invalid transaction type.");
		}

		if ((transactionAmount < 0)) {
			throw new Exception("Invalid transaction amount.");
		}
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}

	/**
	 * @return the transactionType The transaction type is defined in the
	 *         iCommissionCalculator.
	 */
	public int getTransactionType() {
		return transactionType;
	}

	/**
	 * This method will obtain the dollar amount for the transaction.
	 * 
	 * @return the transactionAmount This si the dollar amount of the
	 *         transaction.
	 */
	public double getTransactionAmount() {
		return transactionAmount;
	}
}
