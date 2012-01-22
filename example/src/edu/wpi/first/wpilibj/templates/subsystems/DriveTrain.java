package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/*Import all the things the drivetrain will need*/
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithStick;

/** Subsystem class for the drivetrain on FRC2399's 2011 robot, PIMP.
 *
 */
public class DriveTrain extends Subsystem {
    //The RobotDrive object drive is a property of the drivetrain. It's private,
    //  meaning only the drivetrain can access it, and final, meaning we can't 
    //overwrite it
    //Use the RobotMap to find our motors
    private final RobotDrive drive = new RobotDrive(RobotMap.dtFrontLeftMotor, 
                RobotMap.dtBackLeftMotor,
                RobotMap.dtFrontRightMotor,
                RobotMap.dtBackRightMotor);
    
    //The line sensors are part of the drivetrain if you think about it
    private final DigitalInput lineSensorLeft = new DigitalInput(RobotMap.lineSensorLeft);
    private final DigitalInput lineSensorCenter = new DigitalInput(RobotMap.lineSensorCenter);
    private final DigitalInput lineSensorRight = new DigitalInput(RobotMap.lineSensorRight);
    
    /** This method is just a wrapper for the mecanumDriveCartesion method of 
     * RobotDrive.
     * 
     * @param x - Speed to move in the x (L/R) direction
     * @param y - Speed to move in the y (F/B) direction
     * @param rotation - Speed to rotate
     */
    public void drive(double x, double y, double rotation){
        drive.mecanumDrive_Cartesian(x, y, rotation, 0); //The last 0 is because we have no gyro
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithStick());
    }
    
    /** This method returns the current position of the line, according to the
     * line sensors. I didn't fill in the bits. This is an example of a stub 
     * function. I can use it to write other code, but it doesn't work yet.
     * @todo Write this function
     * 
     * @return linePosition 0 = line is on no sensors
     *      1 = line is on left sensor only
     *      2 = line is on middle sensor only
     *      3 = line is on left AND middle sensor
     *      4 = line is on right sensor only
     *      5 = impossible
     *      6 = line is on middle AND right sensor
     *      7 = line is on all sensors (probably means we're at a T)
     */
    public int getLinePosition(){
        
        return 0; 
    }
}
