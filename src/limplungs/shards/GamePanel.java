package limplungs.shards;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener
{
	private static final long serialVersionUID = 1L;

	public GamePanel()
	{
		this.setLocation(0,0);
		this.setVisible(true);
		this.setSize(ShardsGame.screen);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	
	public void up()
	{
		ShardsGame.posY -= 1;
		ShardsGame.master.find(ShardsGame.posX, ShardsGame.posY + 1).createUp();
	}
	
	public void down()
	{
		ShardsGame.posY += 1;
		ShardsGame.master.find(ShardsGame.posX, ShardsGame.posY - 1).createDown();
	}
	
	public void left()
	{
		ShardsGame.posX -= 1;
		ShardsGame.master.find(ShardsGame.posX + 1, ShardsGame.posY).createLeft();
	}
	
	public void right()
	{
		ShardsGame.posX += 1;
		ShardsGame.master.find(ShardsGame.posX - 1, ShardsGame.posY).createRight();
	}
	
	public void updateGamespaces()
	{
		this.repaint();
		this.requestFocusInWindow();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {

		int k = arg0.getKeyCode();
		System.out.println(k + arg0.getID());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
