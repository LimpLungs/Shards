package limplungs.shards;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;

public class QuadLinkedGamespace
{
	private QuadLinkedGamespace up;
	private QuadLinkedGamespace down;
	private QuadLinkedGamespace left;
	private QuadLinkedGamespace right;
	private Point location;
	public JPanel visual;
	
	public QuadLinkedGamespace(int x, int y)
	{
		up = null;
		down = null;
		left = null;
		right = null;
		location = new Point(x, y);
		
		visual = new JPanel();
		visual.setSize(Settings.SIZE_X, Settings.SIZE_Y);
		visual.setBackground(new Color( new Random().nextInt(225) + 25, new Random().nextInt(225) + 25, new Random().nextInt(225) + 25 ) );
		
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
	
	
	
	public void setLink(String direction, QuadLinkedGamespace link)
	{
		 if (direction.equals("up"))
			this.up = link;
		 else if (direction.equals("down"))
			this.down = link;
		 else if (direction.equals("left"))
			this.left = link;
		 else if (direction.equals("right"))
			this.right = link;
	}
	
	
	
	public QuadLinkedGamespace getLink(String direction)
	{
		if (direction.equals("up"))
			return this.up;
		else if (direction.equals("down"))
			return this.down;
		else if (direction.equals("left"))
			return this.left;
		else if (direction.equals("right"))
			return this.right;
		else
			return null;
	}
}
