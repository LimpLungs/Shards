package limplungs.shards;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class ShardsGame extends JFrame 
{
	private static final long serialVersionUID = 1L;

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
            
        while(EngineDeclarations.isRunning) 
        {
        	long time = System.currentTimeMillis(); 
            
            update(); 
            draw(); 
            
            //  delay for each frame  -   time it took for one frame 
            time = (1000 / Settings.FPS) - (System.currentTimeMillis() - time); 
            
            if (time > 0.0) 
            { 
            	EngineFunctions.sleep(time, EngineDeclarations.time);
            }
        }
    } 
    
    
    
    void initialize()
    {
    	Settings.initVariables();
    	
    	this.setLayout(null);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setSize(Settings.WIDTH, Settings.HEIGHT);
		this.getContentPane().setBackground(Color.BLACK);
		this.setVisible(true);
		
		Settings.CONTROLS = new Controls(this);
		
		
		
		// Set up first game space
    	if (EngineDeclarations.master.find(0, 0) == null)
    	{
    		EngineDeclarations.master.insert(new Gamespace(0, 0));
    		
    		this.add(EngineDeclarations.master.find(0, 0).visual);
    		
	  		EngineDeclarations.master.find(0, 0).visual.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));	
    	}
    	
    	
    	
    	EngineDeclarations.isRunning = true;
    }
    
    
    
    void update()
    {
    	EngineDeclarations.master.updateVisuals();
    	
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