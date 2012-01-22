package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/*Import all the things the drivetrain will need*/
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.DriveWithStick;

/** Subsystem class for the drivetrain on FRC2399's 2011 robot, PIMP.
 *
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    RobotDrive drive;
    
    /** Constructor sets up all of the properties of the subsystem, including 
     * the RobotDrive object.
     */
    public void DriveTrain(){
        //Use the RobotMap to find our motors
        drive = new RobotDrive(RobotMap.dtFrontLeftMotor, 
                RobotMap.dtBackLeftMotor,
                RobotMap.dtFrontRightMotor,
                RobotMap.dtBackRightMotor);
    }
    
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
}
