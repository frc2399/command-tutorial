package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Edward
 */
public class LiftWithStick  extends CommandBase {
    
    /** Constructor is mainly used for setting subsystem requirements.**/
    public LiftWithStick() {
        //This command requires the lift subsystem
        requires(lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**Called repeatedly while the command is running. This function gets the
     * stick values from the OI and sends them to the driveTrain subsystem's
     * drive() method.
     */
    protected void execute() {
        //Get the values of the armStick from the OI
        double value = oi.getArmStick().getRawAxis(2);
        
        //Since the arm uses a PIDSubsystem, we can't just set its speed; we 
        //have to set its position. What we can do is set its desired position 
        //relative to where it is now.
        
        //Tell the lift to move up/down  by .5 inch * the joystick value
        //Full joystick value is 1.0 * .5 inch = .5 inches per execute
        //This function runs 50 times/sec, so this means the arm will max out at
        //25 inches/sec (if the motor can go that fast)
        lift.setSetpointRelative(.5 * value);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
