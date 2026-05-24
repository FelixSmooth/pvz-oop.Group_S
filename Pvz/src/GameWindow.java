import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{
    public GameWindow()
    {
        setTitle("Plant vs Zombies");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //create the garden 5x9
        GamePanel boardPanel = new GamePanel();
        boardPanel.setLayout(new GridLayout(5, 9));
        for(int i = 0; i < 45; i++)
        {
            JButton cell = new JButton();
            cell.setBackground(new Color(34, 139, 34));
            cell.addActionListener(e -> {
                int x = cell.getX();
                int y = cell.getY();
                Peashooter plant = new Peashooter(x, y);
                GameManager.getInstance().addPlant(plant);
                cell.setText("P"); 
                cell.setBackground(new Color(144, 238, 144));
                cell.setEnabled(false);
            });
            boardPanel.add(cell);
        }
        add(boardPanel);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            GameWindow window = new GameWindow();
            window.setVisible(true);
        });
    }
}
