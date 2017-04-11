package limplungs.shards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import limplungs.shards.EngineDeclarations.EnumDirection;

public class EngineFunctions
{
	@SuppressWarnings("static-access")
	public static void sleep(long time, Thread thread)
	{
		try
		{
			thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			System.out.print("Exited sleep erroneously for thread: " + thread.getName());
			
			System.exit(-1);
		}
	}
	
	
	
	public static void moveDirection(final ShardsGame shards, final EnumDirection direction)
	{
		Timer timer = new Timer(EngineDeclarations.CAMERA_MOVE_SPEED, new ActionListener()
		{
			double count = 0.0;

		  	@Override
		  	public void actionPerformed(ActionEvent activator)
		  	{
		  	    count += EngineDeclarations.CAMERA_SMOOTHNESS;
		  	    
		  	    
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
		  	    	
		  	    	if (EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y) == null)
		  	    	{
		  	    		EngineDeclarations.master.insert(new Gamespace((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y));
		  	    		
		  	    		shards.add(EngineDeclarations.master.find((int)EngineDeclarations.POSITION_X, (int)EngineDeclarations.POSITION_Y).visual);
		  	    	}
		  	    }
		  	}
		});
		
		timer.start();
	}
}