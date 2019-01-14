package WSP;

public class Period {
	private final int periodId;
	private final int fromTime;
	private final int toTime;
	private final int numStaff;

	/**
	 * Initialize new Period
	 */
	public Period(int periodId, int fromTime, int toTime,int numStaff) {
		this.periodId = periodId;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.numStaff = numStaff;
	}

	
	public int getPeriodId() {
		return this.periodId;
	}

	
	public int getFromTime() {
		return this.fromTime;
	}
	
	public int getToTime() {
		return this.toTime;
	}
	
	public int getStaffNumber() {
		return this.numStaff;
	}

}