package WSP;

public class Shift {
    private final int shiftId;
    private final int time;
    private int numStaff;
    
    /**
     * Initialize new Shift
     * 
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
    
    public int getShiftId(){
        return this.shiftId;
    }
    
    
    public int getTime(){
        return this.time;
    }
    
    
    public int getStaffNumber(){
        return this.numStaff;
    }
}

