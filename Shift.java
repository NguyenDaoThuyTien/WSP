package WSP;

public class Shift {
    private final int shiftId;
    private final int time;
    private int numStaff;
    
    /**
     * Initialize new Class
     * 
     * @param classId
     * @param groupId
     * @param moduleId
     */
    public Shift(int shiftId, int time){
        this.shiftId = shiftId;
        this.time = time;
    }
    
    public void setNumStaff(int numStaff){
    		if (numStaff < 0) 
    			this.numStaff = 0;
    		else this.numStaff = numStaff;
    }
    
    /**
     * Get classId
     * 
     * @return classId
     */
    public int getShiftId(){
        return this.shiftId;
    }
    
    /**
     * Get groupId
     * 
     * @return groupId
     */
    public int getTime(){
        return this.time;
    }
    
    /**
     * Get moduleId
     * 
     * @return moduleId
     */
    public int getStaffNumber(){
        return this.numStaff;
    }
}

