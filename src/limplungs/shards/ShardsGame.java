package limplungs.shards;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class ShardsGame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	Thread time = new Thread();
	boolean isRunning = false;
	
	public GamespaceList master = new GamespaceList();

	public static void main(String[] args)
	{
		ShardsGame game = new ShardsGame();
		
		game.run();

		System.out.println("Exit 0: Game Loop Ended");
		System.exit(0);
	}
	
	
	
    public void run()
    { 
    	initialize();
            
        while(isRunning) 
        {
        	long time = System.currentTimeMillis(); 
            
            update(); 
            draw(); 
            
            //  delay for each frame  -   time it took for one frame 
            time = (1000 / Settings.FPS) - (System.currentTimeMillis() - time); 
            
            if (time > 0.0) 
            { 
            	SleepFunctions.sleep(time, this.time);
            }
        }
    } 
    
    
    
    void initialize()
    {
    	Settings.initVariables();
    	
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		
		this.setSize(Settings.WIDTH, Settings.HEIGHT);
		
		this.setBackground(Color.BLACK);
		
		this.setVisible(true);
		
		Settings.CONTROLS = new Controls(this);
		
		
		// Set up first game space
    	if (this.master.find(0, 0) == null)
    	{
    		this.master.insert(new QuadLinkedGamespace(0, 0));
    		
    		this.add(this.master.find(0, 0).visual);
    	}
		
    	
    	
		this.isRunning = true;
    }
    
    
    
    void update()
    {
    	this.master.updateVisuals();
    	
    	this.repaint();
    	
    	for (int i = 0; i < this.getComponentCount(); i++)
    	{
    		this.getComponent(i).repaint();
    	}
    }
    
    
    
    void draw()
    {
    	
    }
    
    
    
    void save()
    {
    	
    }
    
    
    
    void load()
    {
    	
    }
}



class Controls implements KeyListener
{
	public Controls(ShardsGame game)
	{
		game.addKeyListener(this);
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent key)
	{
		
	}

	
	
	@Override
	public void keyTyped(KeyEvent key)
	{
		
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent key)
	{
		if (key.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			System.out.println("Exit 1: Pressed Escape");
			System.exit(1);
		}
		
		if (key.getKeyCode() == KeyEvent.VK_UP)
		{
			ShardsGameData.POSITION_Y -= 1;
		}
		
		if (key.getKeyCode() == KeyEvent.VK_DOWN)
		{
			ShardsGameData.POSITION_Y += 1;
		}
		
		if (key.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			ShardsGameData.POSITION_X += 1;
		}
		
		if (key.getKeyCode() == KeyEvent.VK_LEFT)
		{
			ShardsGameData.POSITION_X -= 1;
		}
	}
}



class SleepFunctions
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
}