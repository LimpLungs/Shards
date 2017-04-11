package limplungs.shards;

public class EngineDeclarations
{
	/**
	 *  Data to Save --- TODO: Save Settings & Controls as well.
	 */
	public static double POSITION_X = 0;
	public static double POSITION_Y = 0;
	public static GamespaceList master = new GamespaceList();
	public static Thread time = new Thread();
	public static boolean isRunning = false;
	
	/**
	 *  Data to Use
	 */
	
	// Must be factor of 1.0, and less than 1.0!
	// Multiple of .02 seems to work the best. 
	// Other numbers tend to make a shift in the origin.
	// Lower is better
	public static double CAMERA_SMOOTHNESS   = .01; 
	public static int CAMERA_MOVE_SPEED = 3;
	
	public enum EnumDirection
	{
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
}
