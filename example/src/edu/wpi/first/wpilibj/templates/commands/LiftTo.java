package edu.wpi.first.wpilibj.templates.commands;


/**A command to move the lift to a height, specified in inches.
 *
 * @author Edward
 */
public class LiftTo  extends CommandBase {
    //A variable to store the desired height in
    private double desiredHeight;
    
    /** Constructor is mainly used for setting subsystem requirements.**/
    public LiftTo(double height) {
        //This command requires the lift subsystem
        requires(lift);
        desiredHeight = height;
    }

    /*Sets the lift setpoint to desiredHeight
     * 
     */
    protected void initialize() {
        lift.setSetpoint(desiredHeight);
    }

    /**Called repeatedly while the command is running. This function does 
     * nothing. The PID controller is doing all the work, and the command
     * is just waiting for it to finish.
     */
    protected void execute() {
    }

    /**Returns true (which tells the command to end) when we're at the setpoint.
     * 
     */
    protected boolean isFinished() {
        return lift.atSetpoint();
    }

    /**Called at the end of the command. Since the PID controller is doing all of
     * the work (including stopping the motor when we get there), this does 
     * nothing.
     */
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //To abort the command if it's interrupted, just set the setpoint to the 
        //current position
        lift.setSetpoint(lift.getPosition());
    }
}
