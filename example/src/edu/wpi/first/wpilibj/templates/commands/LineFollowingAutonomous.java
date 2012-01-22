
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

//Import all commands used
import edu.wpi.first.wpilibj.templates.commands.LiftTo;
import edu.wpi.first.wpilibj.templates.commands.FollowLine;
import edu.wpi.first.wpilibj.templates.commands.DropTube;

//Import Lift so we can use its static properties
import edu.wpi.first.wpilibj.templates.subsystems.Lift;

/**
 *
 * @author Ed Venator
 */
public class LineFollowingAutonomous extends CommandGroup {
    
    /**
     * Constructor sets what commands are in this group
     */
    public LineFollowingAutonomous(){
        
        //First lift and drive at the same time
        addParallel(new LiftTo(Lift.TOP_PEG));
        addParallel(new FollowLine());
        //Then drop the tube
        addSequential(new DropTube());
    }
}