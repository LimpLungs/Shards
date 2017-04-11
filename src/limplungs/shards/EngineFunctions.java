package limplungs.shards;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Timer;
import limplungs.shards.EngineDeclarations.EnumDirection;

public class EngineFunctions
{
	/*
	 * Allows the Engine to request a Thread to sleep.
	 */
	@SuppressWarnings("static-access")
	public static void sleep(long time, Thread thread)
	{
		try
		{
			thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			System.out.print("Exited sleep attempt erroneously for thread: " + thread.getName());
			
			System.exit(-1);
		}
	}

	
	
	/* 
	 * Used to avoid starting a second timer, stacking multiple timers, etc.
	 * Cancels multiple movement calls after the first until the first movement call is finished.
	 * This stops multiple active game space borders from being visible.
	 * This blocks camera from moving diagonally.
	 */ 
	static boolean active = false;
	
	/*
	 * Used to move the camera and update the game location.
	 */
	public static void moveDirection(final ShardsGame shards, final EnumDirection direction)
	{
		// Timer used to move the camera in the direction requested over a period of time, acting as an animation.
		Timer timer = new Timer(EngineDeclarations.CAMERA_MOVE_SPEED, new ActionListener()
		{
			// Used to count until camera should stop moving.
			double count = 0.0;

		  	@Override
		  	public void actionPerformed(ActionEvent activator)
		  	{
		  	    count += EngineDeclarations.CAMERA_SMOOTHNESS;
		  	    
		  	    // Moves the camera in the direction of the request.
		  	    if (direction == EnumDirection.NORTH)
		  	    	EngineDeclarations.POSITION_Y -= EngineDeclarations.CAMERA_SMOOTHNESS;
		  	    
		  	    else if (direction == EnumDirection.EAST)
		  	    	EngineDeclarations.POSITION_X += EngineDeclarations.CAMERA_SMOOTHNESS;
		  	    
		  	    else if (direction == EnumDirection.SOUTH)
		  	    	EngineDeclarations.POSITION_Y += EngineDeclarations.CAMERA_SMOOTHNESS;
		  	    
		  	    else if (direction == EnumDirection.WEST)
		  	    	EngineDeclarations.POSITION_X -= EngineDeclarations.CAMERA_SMOOTHNESS;
		  	    
		  	    shards.update();
		  	    
		  	    // Should always be == 1.0 through design, so long as EngineDeclarations.CAMERA_SMOOTHNESS is a factor of 1.0
		  	    if (count >= 1.0)
		  	    {
		  	    	((Timer)activator.getSource()).stop();
		  	    	active = false;
		  	    	
		  	    	EngineDeclarations.POSITION_X = Math.floor(EngineDeclarations.POSITION_X + .5);
		  	    	EngineDeclarations.POSITION_Y = Math.floor(EngineDeclarations.POSITION_Y + .5);
		  	    	
		  	    	// Creates a new game space if none exist where camera moves to.
		  	    	if (EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y) == null)
		  	    	{
		  	    		EngineDeclarations.master.insert(new Gamespace((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y));
		  	    		
		  	    		shards.add(EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y).visual);
		  	    	}
		  	    	
		  	    	// Attaches the active border to the game space.
		  	    	if (EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y) != null)
		  	    	{
		  		  		EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y).visual.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		  	    	}
		  	    }
		  	}
		});
		
		// Removes the old active border to prepare for movement.
	    if (EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y) != null)
	    {
	  		EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y).visual.setBorder(BorderFactory.createEmptyBorder());	
	    }
		
	    // Makes any active timer finish before starting a new timer.
	    // Stops you from moving diagonally using two timers at once.
	    if (active == false)
	    {
	    	timer.start();
	    	active = true;
	    }
	}
}