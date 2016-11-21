package limplungs.shards;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class ShardsGame
{

	public static int width = 0;
	public static int height = 0;
	public static Dimension screen = new Dimension(0, 0);
	public static GamespaceList master = new GamespaceList();

	public static void main(String[] args)
	{
		JWindow game = new JWindow();
		Container container = new Container();
		
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
		container = game.getContentPane();
		container.setBackground(Color.BLACK);

		// Game Creation Stage
		
		new Sleep(1500, time);
		
		container.setBackground(Color.WHITE);
		
		master.insert(new QuadLinkedGamespace());
		master.find(0,0).createUp();
		master.find(0,0).createLeft();
		master.find(-1,0).createUp();
		
		QuadLinkedGamespace visualSpace = master.find(0, 0);
		
		JPanel first = new JPanel();
		first.setSize(40,40);
		first.setBackground(Color.YELLOW);
		first.setLocation(200 + (visualSpace.getLocation().x * 40), 200 + (visualSpace.getLocation().y * 40));
		first.setVisible(true);
		
		visualSpace = master.find(0, 1);

		JPanel second = new JPanel();
		second.setSize(40,40);
		second.setBackground(Color.PINK);
		second.setLocation(200 + (visualSpace.getLocation().x * 40), 200 + (visualSpace.getLocation().y * 40));
		second.setVisible(true);
		
		visualSpace = master.find(-1, 0);

		JPanel third = new JPanel();
		third.setSize(40,40);
		third.setBackground(Color.BLUE);
		third.setLocation(200 + (visualSpace.getLocation().x * 40), 200 + (visualSpace.getLocation().y * 40));
		third.setVisible(true);
		
		visualSpace = master.find(-1, 1);

		JPanel fourth = new JPanel();
		fourth.setSize(40,40);
		fourth.setBackground(Color.GREEN);
		fourth.setLocation(200 + (visualSpace.getLocation().x * 40), 200 + (visualSpace.getLocation().y * 40));
		fourth.setVisible(true);

		container.add(first);
		container.add(second);
		container.add(third);
		container.add(fourth);
		
		container.repaint();
		
		
		// Game Load Stage
		
		new Sleep(3000, time);
		
		// Game Start Stage
		
		System.exit(0);
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