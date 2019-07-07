package controller;

public class Equipment {

	private String name;

	private String description;

	private int maxQuantity;

	private int actualQuantity;

	/**
	 * 
	 * @param name
	 * @param maxQuantity
	 * @param actualQuantity
	 */
	public Equipment(String name, int maxQuantity, int actualQuantity) {
		this(name, "", maxQuantity, actualQuantity);
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param maxQuantity
	 * @param actualQuantity
	 */
	public Equipment(String name, String description, int maxQuantity, int actualQuantity) {
		super();
		this.name = name;
		this.description = description;
		this.setMaxQuantity(maxQuantity);
		this.setActualQuantity(actualQuantity);
	}

	/**
	 * 
	 * @return equipment's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return equipment's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return the max quantity in the storage
	 */
	public int getMaxQuantity() {
		return maxQuantity;
	}

	/**
	 * The max quantity cannot lesser than 1
	 * 
	 * @param maxQuantity
	 */
	public void setMaxQuantity(int maxQuantity) {
		if (maxQuantity > 0)
			this.maxQuantity = maxQuantity;
	}

	/**
	 * 
	 * @return actual quantity in the storage
	 */
	public int getActualQuantity() {
		return actualQuantity;
	}

	/**
	 * The actual quantity cannot be lesser than 0 and greater than maxQuantity
	 * 
	 * @param actualQuantity
	 */
	public void setActualQuantity(int actualQuantity) {
		if (actualQuantity >= 0 && actualQuantity <= maxQuantity)
			this.actualQuantity = actualQuantity;
	}

}
