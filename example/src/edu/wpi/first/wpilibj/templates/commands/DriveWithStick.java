package edu.wpi.first.wpilibj.templates.commands;


/**A command to move the drivetrain with a joystick (Mecanum drive).
 *
 * @author Edward
 */
public class DriveWithStick  extends CommandBase {
    
    /** Constructor is mainly used for setting subsystem requirements.**/
    public DriveWithStick() {
        //This command requires the driveTrain subsystem
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    /**Called repeatedly while the command is running. This function gets the
     * stick values from the OI and sends them to the driveTrain subsystem's
     * drive() method.
     */
    protected void execute() {
        //Get the values of the driveStick from the OI
        double x = oi.getDriveStick().getRawAxis(1);
        double y = oi.getDriveStick().getRawAxis(2);
        double twist = oi.getDriveStick().getRawAxis(3);
        
        //Tell the driveTrain subsystem to drive
        driveTrain.drive(x, y, twist);
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
