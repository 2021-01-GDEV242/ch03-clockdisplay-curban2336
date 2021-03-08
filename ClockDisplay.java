
/**
 * The ClockDisplay class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 AM (midnight) to 11:59 PM(one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @modified by Christopher Urban
 * @version 2020.05.02
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String meridian;
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00 AM.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        setTime(12, 00, "AM");
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String newMeridian)
    {
        hours = new NumberDisplay(13);
        minutes = new NumberDisplay(60);
        if(hour>0 && hour<=12)
        {
             hours.setValue(hour);
             minutes.setValue(minute);
             meridian = newMeridian;
             updateDisplay();
        }
        else{
             System.out.println("Hour value invalid. Please use a number between and including 1 to 12.");
        }
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
        if(hours.getValue() == 12){
            if(meridian.equalsIgnoreCase("AM")){
                meridian = "PM";
            }
            else{
                meridian = "AM";
            }
        }
        if(hours.getValue() == 0){
            hours.setValue(1);
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String newMeridian)
    {
        if(hour>0 && hour<=12)
        {
            if(newMeridian.equalsIgnoreCase("AM") || newMeridian.equalsIgnoreCase("PM"))
            {
                hours.setValue(hour);
                minutes.setValue(minute);
                meridian = newMeridian;
                updateDisplay();
            }
            else{
                System.out.println("Meridian value invalid. Please use am or pm.");
            }
        }
        else{
             System.out.println("Hour value invalid. Please use a number between and including 1 to 12.");
        }
    }

    /**
     * Return the current time of this display in the format HH:MM AM/PM.
     */
    public String get12HourInternalDisplay()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " " + meridian.toUpperCase();
    }
}
