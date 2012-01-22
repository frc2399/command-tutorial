package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //Example variable:
    //public static final int variable;
    //public means code outside of this class has access to it
    //static means you can access it without making a new Robotmap. You can just 
    //  do RobotMap.variable
    //final means it's a constant. The code can't change the value. Only we can.
    //int means it's an integer
    //variable is the name
    
    /*Drivetrain Motor Ports*/
    public static final int dtFrontLeftMotor = 1;   //Port number of the FL motor
    public static final int dtFrontRightMotor = 8;  //Port number of the FR motor
    public static final int dtBackLeftMotor = 4;    //Port number of the BL motor
    public static final int dtBackRightMotor = 6;   //Port number of the BR motor
    
    /*Lift Motor Port*/
    public static final int liftMotor = 5;
    
    /*Lift Encoder Port (Optical encoders have 2 inputs, A and B)*/
    public static final int liftEncoderA = 1;
    public static final int liftEncoderB = 2;
    
    /*Lift Limit Switch*/
    public static final int liftLimitSwitch = 14;
    
    /*Grabber Motor Port*/
    public static final int grabberMotor = 2;
    
    /*Lift Encoder Port (Magnetic Encoders have 1 input)*/
    public static final int grabberEncoder = 1;
    
    /*Line Sensor Ports*/
    public static final int lineSensorLeft = 3;
    public static final int lineSensorCenter = 4;
    public static final int lineSensorRight = 5;
}
