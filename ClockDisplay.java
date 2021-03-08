
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @modified by Christopher Urban
 * @version 2016.02.29
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String meridian;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        meridian = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Return the current time of this display in the format HH:MM AM/PM.
     */
    public String get24HourInternalDisplay()
    {
        if(hours.getValue()>=13){
            meridian = "PM";
            updateDisplay();
        }
        else{
            meridian = "AM";
            updateDisplay();
        }
        if(hours.getValue()==0){
            hours.setValue(12);
            updateDisplay();
        }    
        else if(hours.getValue()==13){
            hours.setValue(1);
            updateDisplay();
        } 
        else if(hours.getValue()==14){
            hours.setValue(2);
            updateDisplay();
        } 
        else if(hours.getValue()==15){
            hours.setValue(3);
            updateDisplay();
        } 
        else if(hours.getValue()==16){
            hours.setValue(4);
            updateDisplay();
        } 
        else if(hours.getValue()==17){
            hours.setValue(5);
            updateDisplay();
        } 
        else if(hours.getValue()==18){
            hours.setValue(6);
            updateDisplay();
        } 
        else if(hours.getValue()==19){
            hours.setValue(7);
            updateDisplay();
        } 
        else if(hours.getValue()==20){
            hours.setValue(8);
            updateDisplay();
        }
        else if(hours.getValue()==21){
            hours.setValue(9);
            updateDisplay();
        }
        else if(hours.getValue()==22){
            hours.setValue(10);
            updateDisplay();
        }
        else if(hours.getValue()==23){
            hours.setValue(11);
            updateDisplay();
        }
        return displayString;
    }
    
    
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " " + meridian;
    }
}
