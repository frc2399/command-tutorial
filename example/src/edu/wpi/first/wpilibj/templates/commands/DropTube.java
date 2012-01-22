package edu.wpi.first.wpilibj.templates.commands;


/**
 *
 * @author Ed
 */
public class DropTube extends CommandBase{

    public DropTube() {
        requires(grabber);
    }

    /* Tells the grabber to go to the OPEN position
     */ 
    protected void initialize() {
        grabber.setSetpoint(grabber.OPEN);
    }

    /**Called repeatedly while the command is running. This function does 
     * nothing. The PID controller is doing all the work, and the command
     * is just waiting for it to finish.
     */
    protected void execute() {
    }

    /**Returns true (which tells the command to end) when we're at the setpoint.
     */
    protected boolean isFinished() {
        return grabber.atSetpoint();
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
    }
}
