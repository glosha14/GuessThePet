import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessThePet extends JFrame {
    private final String correctAnswer = "Pig";

    public GuessThePet() {
        setTitle("Guess The Pet ");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        ImageIcon originalIcon = new ImageIcon("resources/pig.png");
        Image resizedImage = originalIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);


        JRadioButton birdBtn = new JRadioButton("Bird");
        JRadioButton catBtn = new JRadioButton("Cat");
        JRadioButton dogBtn = new JRadioButton("Dog");
        JRadioButton rabbitBtn = new JRadioButton("Rabbit");
        JRadioButton pigBtn = new JRadioButton("Pig");

        ButtonGroup group = new ButtonGroup();
        group.add(birdBtn);
        group.add(catBtn);
        group.add(dogBtn);
        group.add(rabbitBtn);
        group.add(pigBtn);

        JPanel optionsPanel = new JPanel(new GridLayout(5, 1));
        optionsPanel.setBorder(BorderFactory.createTitledBorder("What animal is shown above?"));
        optionsPanel.add(birdBtn);
        optionsPanel.add(catBtn);
        optionsPanel.add(dogBtn);
        optionsPanel.add(rabbitBtn);
        optionsPanel.add(pigBtn);

        add(optionsPanel, BorderLayout.SOUTH);


        ActionListener checkAnswer = e -> {
            String selected = ((JRadioButton) e.getSource()).getText();
            if (selected.equals(correctAnswer)) {
                JOptionPane.showMessageDialog(this, " Correct! That's a Pig ");
            } else {
                JOptionPane.showMessageDialog(this, " Oops! That's not right. Try again.");
            }
        };

        birdBtn.addActionListener(checkAnswer);
        catBtn.addActionListener(checkAnswer);
        dogBtn.addActionListener(checkAnswer);
        rabbitBtn.addActionListener(checkAnswer);
        pigBtn.addActionListener(checkAnswer);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessThePet().setVisible(true));
    }
}
