package limplungs.shards;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JWindow;

public class ShardsGame
{
	// Set up screen
	public static int width = 0;
	public static int height = 0;
	public static int posX = 0;
	public static int posY = 0;
	public static Dimension screen = new Dimension(0, 0);
	public static GamespaceList master = new GamespaceList();
	public static JWindow game = new JWindow();
	public static GamePanel instance = new GamePanel();
	public static Container container = new Container();

	public static void main(String[] args)
	{
		
		// GameTime thread
		Thread time = new Thread();
		time.setName("GameTime");
		
		
		// If toolkit gets screen size properly, reset window variables
		if (Toolkit.getDefaultToolkit().getScreenSize() != null)
		{
			screen = Toolkit.getDefaultToolkit().getScreenSize();
			width = screen.width;
			height = screen.height;
		}
		
		// Set up window
		game.setVisible(true);
		game.setAlwaysOnTop(false);
		game.setSize(width, height);

		// set up content pane
		game.add(instance);
		
		// Set up instance
		instance.setBackground(Color.BLACK);
		instance.requestFocusInWindow();

		// Game Creation Stage
		QuadLinkedGamespace origin = new QuadLinkedGamespace();
		
		master.insert(origin);	
		
		origin.visual.setLocation(((ShardsGame.width / 2) - 20), ((ShardsGame.height / 2) - 20) + (0 * 40));
		instance.add(origin.visual);
		instance.updateGamespaces();
		container.repaint();
	}
	
}

// Sleeps the thread for parameter int.
class Sleep
{
	@SuppressWarnings("static-access")
	public Sleep(int num, Thread thread)
	{
		try
		{
			thread.sleep(num);
		}
		catch (InterruptedException e)
		{
			System.out.print("Exited sleep erroneously for thread: " + thread.getName());
			System.exit(-1);
		}
	}
}