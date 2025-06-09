import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MemorialPaymentUI extends JFrame {

    private JTextField paymentField;
    private JLabel totalLabel;
    private JLabel greetingLabel;
    private Image backgroundImage;

    private class BackgroundPanel extends JPanel {
        public BackgroundPanel() {
            try {
                backgroundImage = ImageIO.read(new File("resources/background.jpg"));
            } catch (IOException e) {
                System.out.println("Could not load background image: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.setColor(new Color(30, 30, 30));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }

    // Constructor accepts userId and totalAmount (previous balance)
    public MemorialPaymentUI(String userId, int totalAmount) {
        setTitle("Memorial Payment");
        setSize(1100, 630);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(null);
        add(panel);

        Font titleFont = new Font("Serif", Font.BOLD, 36);
        Font labelFont = new Font("Serif", Font.BOLD, 24);

        int centerX = 1100 / 2;

        JLabel titleLabel = new JLabel("Memorial Payment!");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(centerX - 200, 30, 400, 40);
        panel.add(titleLabel);

        greetingLabel = new JLabel("Greetings, User ID: " + userId);
        greetingLabel.setFont(labelFont);
        greetingLabel.setForeground(Color.WHITE);
        greetingLabel.setBounds(centerX - 250, 100, 500, 30);
        panel.add(greetingLabel);

        JLabel paymentLabel = new JLabel("Enter Payment:");
        paymentLabel.setFont(labelFont);
        paymentLabel.setForeground(Color.WHITE);
        paymentLabel.setBounds(centerX - 300, 160, 200, 30);
        panel.add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setFont(labelFont);
        paymentField.setBounds(centerX - 80, 160, 300, 30);
        panel.add(paymentField);

        if (totalAmount > 0) {
            JLabel totalStaticLabel = new JLabel("Previous Balance:");
            totalStaticLabel.setFont(labelFont);
            totalStaticLabel.setForeground(Color.WHITE);
            totalStaticLabel.setBounds(centerX - 300, 220, 200, 30);
            panel.add(totalStaticLabel);

            totalLabel = new JLabel(String.valueOf(totalAmount));
            totalLabel.setFont(labelFont);
            totalLabel.setForeground(Color.WHITE);
            totalLabel.setBounds(centerX - 80, 220, 300, 30);
            panel.add(totalLabel);
        } else {
            JLabel fullyPaidLabel = new JLabel("Fully Paid");
            fullyPaidLabel.setFont(labelFont);
            fullyPaidLabel.setForeground(Color.GREEN);
            fullyPaidLabel.setBounds(centerX - 80, 220, 300, 30);
            panel.add(fullyPaidLabel);

            paymentField.setEnabled(false); // Disable payment input if fully paid
        }

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFont(labelFont);
        submitBtn.setBounds(centerX - 70, 300, 140, 40);
        panel.add(submitBtn);

        submitBtn.addActionListener(e -> {
            if (!paymentField.isEnabled()) {
                JOptionPane.showMessageDialog(this,
                        "No payment needed. Account fully paid.",
                        "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String paymentText = paymentField.getText().trim();

            if (paymentText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a payment amount!",
                        "Input Required",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int paymentAmount;
            try {
                paymentAmount = Integer.parseInt(paymentText);
                if (paymentAmount <= 0) throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid positive number for payment!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int remainingBalance = totalAmount - paymentAmount;
            if (remainingBalance < 0) {
                JOptionPane.showMessageDialog(this,
                        "Payment exceeds previous balance!",
                        "Invalid Payment",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Payment successful!\nUser ID: " + userId +
                            "\nPayment: " + paymentAmount +
                            "\nRemaining Balance: " + remainingBalance,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Optionally update UI
            if (remainingBalance == 0) {
                JOptionPane.showMessageDialog(this,
                        "Congratulations! Your balance is now fully paid.",
                        "Fully Paid",
                        JOptionPane.INFORMATION_MESSAGE);
                paymentField.setEnabled(false);
                totalLabel.setText("0");
            } else {
                totalLabel.setText(String.valueOf(remainingBalance));
            }
        });
    }

    public static void launchPaymentUI(String userId, int totalAmount) {
        SwingUtilities.invokeLater(() -> {
            MemorialPaymentUI paymentUI = new MemorialPaymentUI(userId, totalAmount);
            paymentUI.setVisible(true);
        });
    }
}
