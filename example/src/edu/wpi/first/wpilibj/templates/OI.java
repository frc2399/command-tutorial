package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.AnalogIOButton;
import edu.wpi.first.wpilibj.Joystick;

//Import all the commands we use in teleoperated
import edu.wpi.first.wpilibj.templates.commands.GrabBlueTube;
import edu.wpi.first.wpilibj.templates.commands.GrabRedTube;
import edu.wpi.first.wpilibj.templates.commands.GrabWhiteTube;
import edu.wpi.first.wpilibj.templates.commands.DropTube;
import edu.wpi.first.wpilibj.templates.commands.LiftTo;

//Import the lift so we can use the presets we defined as static variables
import edu.wpi.first.wpilibj.templates.subsystems.Lift;

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
    private final Joystick driveStick = new Joystick(2);
    private final Joystick armStick = new Joystick(1);
    ;
    
    //The armStick buttons are used for things
    private final JoystickButton dropButton = new JoystickButton(armStick, 5);
    private final JoystickButton grabWhiteButton = new JoystickButton(armStick, 2);
    private final JoystickButton grabBlueButton = new JoystickButton(armStick, 3);
    private final JoystickButton grabRedButton = new JoystickButton(armStick, 4);
    //PEEF has buttons
    //(Again, we keep theM private, and use get methods to give them out)
    private final DigitalIOButton peef1 = new DigitalIOButton(1);
    private final DigitalIOButton peef2 = new DigitalIOButton(2);
    private final DigitalIOButton peef3 = new DigitalIOButton(3);
    private final DigitalIOButton peef4 = new DigitalIOButton(4);
    private final DigitalIOButton peef5 = new DigitalIOButton(5);
    private final DigitalIOButton peef6 = new DigitalIOButton(6);
    private final DigitalIOButton peef7 = new DigitalIOButton(7);
    private final DigitalIOButton peef8 = new DigitalIOButton(8);
    private final AnalogIOButton peef9 = new AnalogIOButton(1);

    /** Constructor sets button actions
     * 
     */
    public OI() {
        dropButton.whenPressed(new DropTube());
        grabRedButton.whenPressed(new GrabRedTube());
        grabBlueButton.whenPressed(new GrabBlueTube());
        grabWhiteButton.whenPressed(new GrabWhiteTube());
        peef1.whenPressed(new LiftTo(Lift.TOP_PEG));
        peef4.whenPressed(new LiftTo(Lift.MIDDLE_PEG));
        peef7.whenPressed(new LiftTo(Lift.LOWER_PEG));

    }

    /**A method to get the driveStick, in case other classes want it**/
    public Joystick getDriveStick() {
        return driveStick;
    }

    /**A method to get the driveStick, in case other classes want it**/
    public Joystick getArmStick() {
        return armStick;
    }
}
