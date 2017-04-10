package limplungs.shards;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Settings
{
	public static int FPS = 60;
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	public static int SIZE_X = 0;
	public static int SIZE_Y = 0;
	
	public static Double SCALE = 1.0;

	public static int ASPECT_X = 16;
	public static int ASPECT_Y = 9;
	
	public static Controls CONTROLS;

	public static void initVariables()
	{
		// If toolkit gets screen size properly, reset window variables
		if (Toolkit.getDefaultToolkit().getScreenSize() != null)
		{
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			
			WIDTH  = screen.width;
			HEIGHT = screen.height;
		}
		
		SIZE_X = (int) (WIDTH  / ASPECT_X * SCALE);
	    SIZE_Y = (int) (HEIGHT / ASPECT_Y * SCALE);
	}
}
