package limplungs.shards;

public class GamespaceList
{
	private Node headptr;
	private Node tailptr;
	public int length;
	
	public GamespaceList()
	{
		headptr = new Node();
		tailptr = new Node();
		length = 0;
	}
	
	public void insert(QuadLinkedGamespace space)
	{
		length += 1;
		
		Node temp = new Node();
		temp.space = space;
		temp.next = null;
		temp.prev = null;
		
		// List has 0
		if (headptr.space == null || tailptr.space == null)
		{
			headptr = temp;
			tailptr = temp;
			
			return;
		}
		
		// List has 1+
		tailptr.next = temp;
		temp.prev = tailptr;
		tailptr = temp;
	}
	
	
	
	public QuadLinkedGamespace find(int x, int y)
	{
		Node curr = headptr;
		
		while (curr.space != null && (curr.space.getLocation().x != x || curr.space.getLocation().y != y))
		{
			curr = curr.next;
		}
		
		// Returns space if points match.
		if (curr.space != null && curr.space.getLocation().x == x && curr.space.getLocation().y == y)
			return curr.space;
		
		// Returns null.
		return null;
	}
	
	
	
	public void updateVisuals()
	{
		Node curr = headptr;
		
		while (curr != null)
		{
			curr.space.visual.setLocation(((Settings.WIDTH  / 2) - (Settings.SIZE_X / 2) + (Settings.SIZE_X * curr.space.getLocation().x) - (Settings.SIZE_X * ShardsGameData.POSITION_X)), 
			                              ((Settings.HEIGHT / 2) - (Settings.SIZE_Y / 2) + (Settings.SIZE_Y * curr.space.getLocation().y) - (Settings.SIZE_Y * ShardsGameData.POSITION_Y)));
			
			curr = curr.next;
		}
	}
}

class Node
{
	QuadLinkedGamespace space = null;
	Node next = null;
	Node prev = null;
}