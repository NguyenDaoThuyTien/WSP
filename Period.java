package WSP;

public class Period {
	private final int periodId;
	private final int fromTime;
	private final int toTime;
	private final int numStaff;

	/**
	 * Initialize new Room
	 * 
	 * @param roomId
	 *            The ID for this classroom
	 * @param roomNumber
	 *            The room number
	 * @param capacity
	 *            The room capacity
	 */
	public Period(int periodId, int fromTime, int toTime,int numStaff) {
		this.periodId = periodId;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.numStaff = numStaff;
	}

	/**
	 * Return roomId
	 * 
	 * @return roomId
	 */
	public int getPeriodId() {
		return this.periodId;
	}

	
	public int getFromTime() {
		return this.fromTime;
	}
	
	public int getToTime() {
		return this.toTime;
	}
	/**
	 * Return room number
	 * 
	 * @return roomNumber
	 */
	public int getStaffNumber() {
		return this.numStaff;
	}

}