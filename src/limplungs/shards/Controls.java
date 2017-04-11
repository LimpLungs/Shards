package limplungs.shards;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import limplungs.shards.EngineDeclarations.EnumDirection;

class Controls implements KeyListener
{
	private ShardsGame shards;
	
	public Controls(ShardsGame game)
	{
		game.addKeyListener(this);
		
		shards = game;
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent key)
	{
		
	}

	
	
	@Override
	public void keyTyped(KeyEvent key)
	{
		
	}
	
	
	
	@Override
	public void keyReleased(KeyEvent key)
	{
		if (key.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			System.out.println("Exit 1: Pressed Escape");
			System.exit(1);
		}
		
		if (key.getKeyCode() == KeyEvent.VK_UP)
		{
			EngineFunctions.moveDirection(shards, EnumDirection.NORTH);
		}
		
		if (key.getKeyCode() == KeyEvent.VK_DOWN)
		{
			EngineFunctions.moveDirection(shards, EnumDirection.SOUTH);
		}
		
		if (key.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			EngineFunctions.moveDirection(shards, EnumDirection.EAST);
		}
		
		
		if (key.getKeyCode() == KeyEvent.VK_LEFT)
		{
			EngineFunctions.moveDirection(shards, EnumDirection.WEST);
		}
	}
}
