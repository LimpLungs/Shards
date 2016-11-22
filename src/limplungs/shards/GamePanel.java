package limplungs.shards;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class GamePanel extends JPanel
{
	public GamePanel()
	{
		this.setLocation(0,0);
		this.setVisible(true);
		this.setSize(ShardsGame.screen);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.getInputMap().put(KeyStroke.getKeyStroke("ESC"), "released");
		this.getActionMap().put("released", esc);
	}
	
	// THIS IS NOT WORKING FOR SOME REASON...
	public AbstractAction esc = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	System.out.println("Tried to exit");
	    }
	};
	
	public void up()
	{
		ShardsGame.posY -= 1;
		ShardsGame.master.find(ShardsGame.posX, ShardsGame.posY + 1).createUp();
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
		{
			ShardsGame.posY += 1;
			ShardsGame.master.find(ShardsGame.posX, ShardsGame.posY - 1).createDown();
		}
		else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
		{
			ShardsGame.posX -= 1;
			ShardsGame.master.find(ShardsGame.posX + 1, ShardsGame.posY).createLeft();
		}
		else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
		{
			ShardsGame.posX += 1;
			ShardsGame.master.find(ShardsGame.posX - 1, ShardsGame.posY).createRight();
		}
		
		ShardsGame.instance.repaint();
		System.out.println(ShardsGame.posX + " , " + ShardsGame.posY);
	}


}
