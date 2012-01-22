
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;

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
    private final DigitalInput lowerLimit = new DigitalInput(RobotMap.liftLimitSwitch);
    
    
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
}

