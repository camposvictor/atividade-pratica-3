import java.awt.*;
import javax.swing.*;

public class CustomButton extends JButton {
  public CustomButton(String label) {
    super(label);

    setBackground(new Color(52, 94, 218));
    setForeground(Color.WHITE);
    setFocusable(false);
    setFont(new Font("Helvetica", Font.BOLD, 14));
  }

}