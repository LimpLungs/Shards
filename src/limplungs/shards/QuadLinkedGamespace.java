package limplungs.shards;

import java.awt.Point;

public class QuadLinkedGamespace
{
	private QuadLinkedGamespace up;
	private QuadLinkedGamespace down;
	private QuadLinkedGamespace left;
	private QuadLinkedGamespace right;
	private Point location;
	
	public QuadLinkedGamespace()
	{
		up = null;
		down = null;
		left = null;
		right = null;
		location = new Point(0,0);
	}
	
	public Point getLocation()
	{
		return location;
	}
	
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
	
	protected void createUp()
	{
		QuadLinkedGamespace temp = new QuadLinkedGamespace();
		QuadLinkedGamespace link = null;
		
		// Links current and next space.
		if (up == null)
		{
			temp.setLocation(this.location.x, this.location.y + 1);
			
			temp.down = this;
			
			// temp.up
			link = ShardsGame.master.find(temp.getLocation().x, temp.getLocation().y + 1);
			
			if (link != null)
			{
				temp.setLink("up", link);
				link.setLink("down", temp);
			}
			
			// temp.left
			link = ShardsGame.master.find(temp.getLocation().x - 1, temp.getLocation().y);
			
			if (link != null)
			{
				temp.setLink("left", link);
				link.setLink("right", temp);
			}
			
			// temp.right
			link = ShardsGame.master.find(temp.getLocation().x + 1, temp.getLocation().y);
			
			if (link != null)
			{
				temp.setLink("right", link);
				link.setLink("left", temp);
			}
			
			up = temp;
			
			ShardsGame.master.insert(up);
		}
	}
	
	protected void createDown()
	{
		QuadLinkedGamespace temp = new QuadLinkedGamespace();
		QuadLinkedGamespace link = null;

		// Links current and next space.
		if (down == null)
		{
			temp.setLocation(this.location.x, this.location.y - 1);
			
			temp.up = this;
			
			// temp.down
			link = ShardsGame.master.find(temp.getLocation().x, temp.getLocation().y - 1);
			
			if (link != null)
			{
				temp.setLink("down", link);
				link.setLink("up", temp);
			}
			
			// temp.left
			link = ShardsGame.master.find(temp.getLocation().x - 1, temp.getLocation().y);

			if (link != null)
			{
				temp.setLink("left", link);
				link.setLink("right", temp);
			}
			
			// temp.right
			link = ShardsGame.master.find(temp.getLocation().x + 1, temp.getLocation().y);
			
			if (link != null)
			{
				temp.setLink("right", link);
				link.setLink("left", temp);
			}
			
			down = temp;
			
			ShardsGame.master.insert(down);
		}

	}
	
	protected void createLeft()
	{
		QuadLinkedGamespace temp = new QuadLinkedGamespace();
		QuadLinkedGamespace link = null;

		// Links current and next space.
		if (left == null)
		{
			temp.setLocation(this.location.x - 1, this.location.y);
			
			temp.right = this;
			
			// temp.up
			link = ShardsGame.master.find(temp.getLocation().x, temp.getLocation().y + 1);
			
			if (link != null)
			{
				temp.setLink("up", link);
				link.setLink("down", temp);
			}
			
			// temp.down
			link = ShardsGame.master.find(temp.getLocation().x, temp.getLocation().y - 1);
			
			if (link != null)
			{
				temp.setLink("down", link);
				link.setLink("up", temp);
			}
			
			// temp.left
			link = ShardsGame.master.find(temp.getLocation().x - 1, temp.getLocation().y);
			
			if (link != null)
			{
				temp.setLink("left", link);
				link.setLink("right", temp);
			}
			
			left = temp;
			
			ShardsGame.master.insert(left);
		}
		
	}
	
	protected void createRight()
	{
		QuadLinkedGamespace temp = new QuadLinkedGamespace();
		QuadLinkedGamespace link = null;

		// Links current and next space.
		if (right == null)
		{
			temp.setLocation(this.location.x + 1, this.location.y);
			
			temp.left = this;
			
			// temp.up
			link = ShardsGame.master.find(temp.getLocation().x, temp.getLocation().y + 1);
			
			if (link != null)
			{
				temp.setLink("up", link);
				link.setLink("down", temp);
			}
			
			// temp.down
			link = ShardsGame.master.find(temp.getLocation().x, temp.getLocation().y - 1);
			
			if (link != null)
			{
				temp.setLink("down", link);
				link.setLink("up", temp);
			}
			
			// temp.right
			link = ShardsGame.master.find(temp.getLocation().x + 1, temp.getLocation().y);
			
			if (link != null)
			{
				temp.setLink("right", link);
				link.setLink("left", temp);
			}
			
			right = temp;

			ShardsGame.master.insert(right);
		}
		
	}
}
