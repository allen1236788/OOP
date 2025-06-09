import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class GUImain extends JFrame {

    private databaseManager dbManager = new databaseManager(); 


    public GUImain() {
        setTitle("Memorial Plan");
        setSize(2100, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        setContentPane(backgroundPanel);

        // LEFT PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.DARK_GRAY);
        leftPanel.setPreferredSize(new Dimension(400, 1000));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        try {
            int logoWidth = 200;
            int logoHeight = 200;
            ImageIcon logoIcon = new ImageIcon("resources/planLogo.png");
            Image scaledLogo = logoIcon.getImage().getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            leftPanel.add(Box.createVerticalStrut(40));
            leftPanel.add(logoLabel);
            leftPanel.add(Box.createVerticalStrut(40));
        } catch (Exception e) {
            System.out.println("Failed to load logo: " + e.getMessage());
        }

        JButton buyLotButton = createButton("Buy Lot");
        JButton paymentButton = createButton("Payment");
        JButton exitButton = createButton("Exit");

        // Initially disable Buy Lot button, keep Payment enabled
        buyLotButton.setEnabled(false);
        paymentButton.setEnabled(true);

        Dimension btnSize = new Dimension(300, 100);
        for (JButton btn : new JButton[] { buyLotButton, paymentButton, exitButton }) {
            btn.setMaximumSize(btnSize);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(buyLotButton);
        leftPanel.add(Box.createVerticalStrut(60));
        leftPanel.add(paymentButton);
        leftPanel.add(Box.createVerticalStrut(60));
        leftPanel.add(exitButton);
        leftPanel.add(Box.createVerticalGlue());

        backgroundPanel.add(leftPanel, BorderLayout.WEST);

        // OVERLAY PANEL
        JPanel overlayPanel = new JPanel(null);
        overlayPanel.setOpaque(false);
        backgroundPanel.add(overlayPanel, BorderLayout.CENTER);

        JLabel title = new JLabel("Memorial Plan");
        title.setFont(new Font("Serif", Font.BOLD, 100));
        title.setForeground(Color.WHITE);
        title.setBounds(300, 30, 1000, 100);
        overlayPanel.add(title);

        JLabel usernameLabel = new JLabel("Enter user id:");
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 50));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(100, 250, 400, 40);
        overlayPanel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Serif", Font.PLAIN, 30));
        usernameField.setBounds(450, 250, 400, 50);
        usernameField.setOpaque(false);
        usernameField.setForeground(Color.WHITE);
        usernameField.setCaretColor(Color.WHITE);
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.white, 3),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        overlayPanel.add(usernameField);

        // --- SUBMIT BUTTON ---
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.PLAIN, 30));
        submitButton.setBounds(450, 320, 150, 50);
        submitButton.setBackground(new Color(40, 40, 40));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(60, 60, 60));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(new Color(40, 40, 40));
            }
        });

        overlayPanel.add(submitButton);

        JLabel registerLabel = new JLabel("Have not registered yet?");
        registerLabel.setFont(new Font("Serif", Font.BOLD, 50));
        registerLabel.setForeground(Color.WHITE);
        registerLabel.setBounds(250, 380, 600, 40);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        overlayPanel.add(registerLabel);

        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MemorialPlanReg().setVisible(true);
                dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                registerLabel.setForeground(Color.gray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerLabel.setForeground(Color.WHITE);
            }
        });

        // ACTIONS
        buyLotButton.addActionListener(e -> {
            new Window1().setVisible(true);
            dispose();
        });

        // User validation logic used by submit and payment buttons
        Runnable validateUser = () -> {
            String enteredUserId = usernameField.getText().trim();

            if (enteredUserId.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a User ID first!",
                        "Input Required",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }


            // *** Changed from mockUserDatabase to dbManager ***
            if (dbManager.userExists(enteredUserId)) {  
                JOptionPane.showMessageDialog(this,
                        "Hello \"" + enteredUserId + "\"! Welcome back!",
                        "Welcome",
                        JOptionPane.INFORMATION_MESSAGE);

                // Enable both Buy Lot and Payment buttons
                buyLotButton.setEnabled(true);
                paymentButton.setEnabled(true);

                // Disable username input and Submit button (keep payment enabled)
                usernameField.setEnabled(false);
                submitButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this,
                        "User ID \"" + enteredUserId + "\" not found.\nYou need to register first.",
                        "User Not Found",
                        JOptionPane.ERROR_MESSAGE);
            }
        };

        submitButton.addActionListener(e -> validateUser.run());

        paymentButton.addActionListener(e -> {
            // First validate user
            validateUser.run();

            // If valid user and Buy Lot button enabled (means user found), open MemorialPaymentUI
            if (buyLotButton.isEnabled()) {
                // For demo, assume totalAmount is fixed, say 1000
                int totalAmount = 1000; // you can replace with real fetched amount
                MemorialPaymentUI.launchPaymentUI(usernameField.getText().trim(), totalAmount);
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        // Reset buttons/input when usernameField text changes
        usernameField.getDocument().addDocumentListener(new DocumentListener() {
            private void reset() {
                buyLotButton.setEnabled(false);
                submitButton.setEnabled(true);
                usernameField.setEnabled(true);
                paymentButton.setEnabled(true);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                reset();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                reset();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                reset();
            }
        });
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.PLAIN, 40));
        button.setFocusPainted(false);
        button.setBackground(new Color(40, 40, 40));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(60, 60, 60));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(40, 40, 40));
            }
        });

        return button;
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

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
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUImain().setVisible(true));
    }
}
