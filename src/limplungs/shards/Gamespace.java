package limplungs.shards;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;

public class Gamespace
{
	private Point location;
	public JPanel visual;
	
	public Gamespace(int x, int y)
	{
		location = new Point(x, y);
		
		visual = new JPanel();
		visual.setSize(Settings.SIZE_X, Settings.SIZE_Y);
		visual.setBackground(new Color( new Random().nextInt(225) + 25, new Random().nextInt(225) + 25, new Random().nextInt(225) + 25 ) );
		visual.setLocation(-Settings.SIZE_X, -Settings.SIZE_Y); // Hide off the screen until moved.
		visual.setVisible(true);
	}
	
	
	
	public Point getLocation()
	{
		return location;
	}
	
	// Shouldn't need to be used.
	@Deprecated
	public void setLocation(int x, int y)
	{
		location.x = x;
		location.y = y;
	}
}
