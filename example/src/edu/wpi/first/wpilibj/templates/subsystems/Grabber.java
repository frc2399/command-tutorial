package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.templates.RobotMap;

/** Subsystem class for the tube grabber on FRC2399's 2011 robot, PIMP.
 *
 */
public class Grabber extends PIDSubsystem {
    
    //Set positions for the lift. Units are degrees relative to the floor(and I made them up)
    public static final double UPPER_BOUND = 30; //Max height
    public static final double GRAB_WHITE = 15;     //Top scoring height
    public static final double GRAB_BLUE = 15;  //Middle scoring height
    public static final double GRAB_RED = 15; //Bottom scoring height
    public static final double OPEN = -90;
    public static final double LOWER_BOUND = OPEN; //Min height
    
    //This is the angular measurement of the 0.0Volt point on the sensor (I made it up)
    public static final double OFFSET_ANGLE = -35;
    
    //This is the number of degrees that each volt on the sensor equals
    public static final double DEG_PER_VOLT = 0.0139;
    
    private final Jaguar motor = new Jaguar(RobotMap.grabberMotor);
    private final AnalogChannel encoder = new AnalogChannel(RobotMap.grabberEncoder);
    
    
    public Grabber() {
        //Set PID Constants with the parent class's constructor (called with super())
        super(0.01, 0.0, 0.0);
        
        //Set limits
        setSetpointRange(UPPER_BOUND, LOWER_BOUND);
        
        //Set the default position to GRAB_RED
        setSetpoint(GRAB_RED);
        
        //Enable the PID controller.
        enable();
    }
    
    public void initDefaultCommand() {
        //The grabber has no default command
    }
    
    /**This function sends the grabber angle to the PID controller.
     * In order to calculate the grabber angle, it has to take in the voltage
     * from the magnetic encoder, convert it to an angle, and then send it to
     * the PID controller.
     * @return Grabber angle
     */
    protected double returnPIDInput() {
        double voltage = encoder.getVoltage();
        double angle = (voltage * DEG_PER_VOLT) + OFFSET_ANGLE;
        return angle;
    }
    
    protected void usePIDOutput(double output) {
        motor.set(output);
    }
    
    /**This function tells us if we're at the setpoint (useful for knowing if a
     * command has finished). It returns true if we're within an inch of the 
     * setpoint.
     * @return atSetpoint? (True if less than 1 inch from setpoint)
     */
    public boolean atSetpoint(){
        return Math.abs(getPosition() - getSetpoint()) < 1;
    }
}