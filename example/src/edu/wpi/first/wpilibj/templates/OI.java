
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.AnalogIOButton;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    //The OI has Joysticks
    //(we keep them private, and use get methods to give them out)
    private Joystick driveStick = new Joystick(2);
    private Joystick armStick = new Joystick(1);;
    
    //The armStick buttons are used for things
    private JoystickButton dropButton = new JoystickButton(armStick,5);
    private JoystickButton grabWhiteButton = new JoystickButton(armStick,2);
    private JoystickButton grabBlueButton = new JoystickButton(armStick,3);
    private JoystickButton grabRedButton = new JoystickButton(armStick,4);
    
    //PEEF has buttons
    //(Again, we keep the private, and use get methods to give them out)
    private DigitalIOButton peef1, peef2, peef3, peef4, peef5, peef6, peef7, peef8;
    private AnalogIOButton peef9;
    
    /**A method to get the driveStick, in case other classes want it**/
    public Joystick getDriveStick(){
        return driveStick;
    }
    
    /**A method to get the driveStick, in case other classes want it**/
    public Joystick getArmStick(){
        return armStick;
    }
}

