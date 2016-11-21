package limplungs.shards;

public class GamespaceList
{
	private Node headptr;
	private Node tailptr;
	
	public GamespaceList()
	{
		headptr = new Node();
		tailptr = new Node();
	}
	
	public void insert(QuadLinkedGamespace space)
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
			
			return;
		}
		
		// List has 1+
		tailptr.next = temp;
		temp.prev = tailptr;
		tailptr = temp;
			
		return;
	}
	
	public QuadLinkedGamespace find(int x, int y)
	{
		Node curr = headptr;
		
		while (curr != null && (curr.space.getLocation().x != x || curr.space.getLocation().y != y))
		{
			curr = curr.next;
		}
		
		// Returns space if points match.
		if (curr != null && curr.space.getLocation().x == x && curr.space.getLocation().y == y)
			return curr.space;
		
		// Returns null.
		return null;
	}
	
	public void update(String direction, QuadLinkedGamespace created, QuadLinkedGamespace existing)
	{
		if (existing == null || created == null)
			return;

		created.setLink(direction, existing);
	}
}

class Node
{
	QuadLinkedGamespace space = null;
	Node next = null;
	Node prev = null;
}