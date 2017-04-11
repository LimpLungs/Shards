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
	
	public void insert(Gamespace space)
	{
		Node temp = new Node();
		temp.space = space;
		temp.next = null;
		temp.prev = null;
		
		// List has 0
		if (headptr.space == null || tailptr.space == null)
		{
			headptr = temp;
			tailptr = temp;
			
			length += 1;
			
			return;
		}
		
		// List has 1+
		tailptr.next = temp;
		temp.prev = tailptr;
		tailptr = temp;
		
		length += 1;
	}
	
	
	
	public Gamespace find(int x, int y)
	{
		Node curr = headptr;
		
		while (curr != null && curr.space != null && (curr.space.getLocation().x != x || curr.space.getLocation().y != y))
		{
			curr = curr.next;
		}
		
		// Returns space if points match.
		if (curr != null && curr.space != null && curr.space.getLocation().x == x && curr.space.getLocation().y == y)
			return curr.space;
		
		// Returns null.
		return null;
	}
	
	
	
	public void updateVisuals()
	{
		Node curr = headptr;
		
		while (curr != null)
		{
			curr.space.visual.setLocation(((Settings.WIDTH  / 2) - (Settings.SIZE_X / 2) + (Settings.SIZE_X * curr.space.getLocation().x) - (int)(Settings.SIZE_X * EngineDeclarations.POSITION_X)), 
			                              ((Settings.HEIGHT / 2) - (Settings.SIZE_Y / 2) + (Settings.SIZE_Y * curr.space.getLocation().y) - (int)(Settings.SIZE_Y * EngineDeclarations.POSITION_Y)));
			
			curr = curr.next;
		}
	}
}

class Node
{
	Gamespace space = null;
	Node next = null;
	Node prev = null;
}