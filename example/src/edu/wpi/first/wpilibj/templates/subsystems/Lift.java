
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.LiftWithStick;

/**
 *
 */
public class Lift extends PIDSubsystem {
    
    //Set positions for the lift. Units are inches (and I made them up)
    public static final int UPPER_BOUND = 120; //Max height
    public static final int TOP_PEG = 100;     //Top scoring height
    public static final int MIDDLE_PEG = 70;  //Middle scoring height
    public static final double LOWER_PEG = 40; //Bottom scoring height
    public static final double LOWER_BOUND = 0; //Min height
    
    
    private final Jaguar motor = new Jaguar(RobotMap.liftMotor);
    private final Encoder encoder = new Encoder(RobotMap.liftEncoderA,RobotMap.liftEncoderB);
    private final DigitalInput limitSwitch = new DigitalInput(RobotMap.liftLimitSwitch);
    
    
    public Lift() {
        //Set PID Constants with the parent class's constructor (called with super())
        super(0.01, 0.0, 0.0);
        
        //Distance in inches per encoder pulse (I made it up)
        double distancePerPulse = .125;
        
        //Set up encoder to convert to inches
        encoder.setDistancePerPulse(distancePerPulse);
        
        //Set limits
        setSetpointRange(UPPER_BOUND, LOWER_BOUND);
        
        //Set the default position to down
        setSetpoint(LOWER_BOUND);
        
        //Enable the PID controller.
        enable();
    }
    
    public void initDefaultCommand() {
        //The default for the lift is to drive it with the joystick
        setDefaultCommand(new LiftWithStick());
    }
    
    /**This function sends the position value to the PID controller.
     * 
     * @return Position value (the value from the sensor)
     */
    protected double returnPIDInput() {
        //We want to use the encoder value for out position, but we also want 
        //to reset it when we hit the limit switch
        
        
        if(limitSwitch.get()){
            //If we hit the limit switch, reset the encoder to 0 and send the
            //encoder value to the PID controller
            encoder.reset();
            return encoder.getDistance();
        }
        else if(getSetpoint()==LOWER_BOUND && encoder.getDistance()<=0){
            //If the arm is going to the bottom, and the encoder goes to 0 
            //or below), set the position value to 1. (That way the arm will 
            //keep going until we hit the switch and reset.)
            //(We're lying to the PID controller here.)
            return 1;
        }
        else{
           //Tell the truth
            return encoder.getDistance();
        }
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

