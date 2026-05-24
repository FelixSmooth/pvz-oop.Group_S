import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener
{
    private Timer tmr;
    private final int DELAY = 50;

    public GamePanel()
    {
        tmr = new Timer(DELAY, this);
        tmr.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //update game state
        for(Zombie z : GameManager.getInstance().getZombies())
        {
            z.update();
        }
        repaint();
    }
    public void checkCollisions() {
    // Giả sử bạn có 2 danh sách đạn và zombie từ GameManager
    ArrayList<Bullet> bullets = GameManager.getInstance().getBullets();
    ArrayList<Zombie> zombies = GameManager.getInstance().getZombies();

    for (int i = bullets.size() - 1; i >= 0; i--) {
        Bullet b = bullets.get(i);
        
        for (int j = zombies.size() - 1; j >= 0; j--) {
            Zombie z = zombies.get(j);
            if (b.getX() >= z.getX() && b.getX() <= z.getX() + 50) {
                z.takeDmg(b.getDamage());
                bullets.remove(i);
                if (z.isDead()) {
                    zombies.remove(j);
                }
                break;
            }
        }
    }
}
}
