package edu.wpi.first.wpilibj.templates.commands;


/**A command to move the drivetrain along a line
 *
 * @author Edward
 */
public class FollowLine  extends CommandBase {
    
    /** Constructor is mainly used for setting subsystem requirements.**/
    public FollowLine() {
        //This command requires the driveTrain subsystem
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**Called repeatedly while the command is running. This function checks the
     * line sensors and decides which way to drive.
     * @todo Write this function
     */
    protected void execute() {
        //Put commands here to tell the robot which way to drive based on the line
        //sensors
    }

    /**
     * Returns whether this command is finished. This command finished when we
     * reach a T in the line.
     * @return True when the line sensors are all detecting a line (meaning we're at a T)
     */
    protected boolean isFinished() {
        return driveTrain.getLinePosition() == 7;
    }

    /** Called once after isFinished returns true. Stops the drivetrain.
     */
    protected void end() {
        driveTrain.drive(0.0, 0.0, 0.0);
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
