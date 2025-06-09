import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Window1 extends JFrame {

        private databaseManager dbManager = new databaseManager(); 


    private int userId;
    private boolean isSelectionMode = false;
    private Set<JButton> selectedLots = new HashSet<>();
    private Map<String, Integer> priceMap = Map.of(
            "Standard", 200_000,
            "Garden", 500_000,
            "Mansion", 1_000_000);

    private JButton payBtn;
    private JButton addBtn; // make addBtn accessible to control its state

    public Window1(int userId) { 
        this();
        this.userId = userId;
    }

    private class BackgroundPanel extends JPanel {
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

    public Window1() {
        setTitle("Memorial Map");
        setSize(1100, 630);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel();
        panel.setLayout(null);
        add(panel);

        Font lotFont = new Font("Serif", Font.BOLD, 20);
        Font labelFont = new Font("Serif", Font.BOLD, 24);
        Font titleFont = new Font("Serif", Font.BOLD, 36);

        JLabel title = new JLabel("Memorial Map!");
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        title.setBounds(800, 20, 300, 50);
        panel.add(title);

        addVerticalLabel("STANDARD", 60, 100, panel, labelFont);
        addVerticalLabel("LOT", 60, 270, panel, labelFont);
        addPriceAndLots("200K", 120, 100, panel, lotFont, "Standard");

        addVerticalLabel("GARDEN", 440, 100, panel, labelFont);
        addVerticalLabel("LOT", 440, 250, panel, labelFont);
        addPriceAndLots("500K", 500, 100, panel, lotFont, "Garden");

        addVerticalLabel("MANSION", 780, 100, panel, labelFont);
        addVerticalLabel("LOT", 780, 260, panel, labelFont);
        addPriceAndLots("1M", 840, 100, panel, lotFont, "Mansion");

        // PAY button
        payBtn = new JButton("PAY");
        payBtn.setFont(new Font("Serif", Font.BOLD, 30));
        payBtn.setBounds(970, 525, 100, 50);
        payBtn.setBackground(new Color(50, 50, 50));
        payBtn.setForeground(Color.WHITE);
        payBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        payBtn.setEnabled(false);
        payBtn.addActionListener(e -> {
            int total = calculateTotal();
            MemorialPaymentUI.launchPaymentUI("Selected Lots", total);
        });
        panel.add(payBtn);

        // ADD button
        addBtn = new JButton("ADD");
        addBtn.setFont(labelFont);
        addBtn.setBounds(700, 530, 100, 40);
        addBtn.setBackground(new Color(30, 100, 30));
        addBtn.setForeground(Color.WHITE);
        addBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        addBtn.addActionListener(e -> {
            isSelectionMode = true;
            JOptionPane.showMessageDialog(this, "Selection mode enabled. Click a lot to add.");
        });
        panel.add(addBtn);

        // CANCEL button
        JButton cancelBtn = new JButton("CANCEL");
        cancelBtn.setFont(labelFont);
        cancelBtn.setBounds(580, 530, 110, 40);
        cancelBtn.setBackground(new Color(100, 30, 30));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        cancelBtn.addActionListener(e -> {
            isSelectionMode = false;
            for (JButton btn : selectedLots) {
                btn.setEnabled(true);
                btn.setText("Lot " + btn.getClientProperty("lotNumber"));
                btn.setToolTipText(null);
            }
            selectedLots.clear();
            payBtn.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Selection canceled. Lots are now available again.");
        });
        panel.add(cancelBtn);

        // EXIT button
        JButton exitBtn = new JButton("EXIT");
        exitBtn.setFont(labelFont);
        exitBtn.setBounds(850, 530, 100, 40);
        exitBtn.setBackground(new Color(50, 50, 50));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        exitBtn.addActionListener(e -> System.exit(0));
        panel.add(exitBtn);
    }

    private void addVerticalLabel(String text, int x, int yStart, JPanel panel, Font font) {
        int spacing = 28;
        int textHeight = spacing * text.length();
        int offsetY = yStart + ((6 * 35 + 60) - textHeight) / 2;

        for (int i = 0; i < text.length(); i++) {
            JLabel label = new JLabel(String.valueOf(text.charAt(i)), SwingConstants.CENTER);
            label.setFont(font);
            label.setForeground(Color.WHITE);
            label.setBounds(x, offsetY + i * spacing, 30, 30);
            panel.add(label);
        }
    }

    private void addPriceAndLots(String price, int x, int y, JPanel panel, Font font, String category) {
        JLabel priceLabel = new JLabel("PRICES");
        priceLabel.setFont(font);
        priceLabel.setBounds(x, y, 150, 40);
        priceLabel.setForeground(Color.WHITE);
        panel.add(priceLabel);

        JLabel priceValue = new JLabel(price);
        priceValue.setFont(font);
        priceValue.setBounds(x, y + 30, 100, 30);
        priceValue.setForeground(Color.WHITE);
        panel.add(priceValue);

        for (int i = 1; i <= 6; i++) {
            JPanel boxPanel = new JPanel(null);
            boxPanel.setBounds(x, y + 70 + i * 35, 100, 30);
            boxPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            boxPanel.setOpaque(false);

            JButton lotBtn = new JButton("Lot " + i);
            lotBtn.setFont(font);
            lotBtn.setBounds(0, 0, 100, 30);
            lotBtn.setContentAreaFilled(false);
            lotBtn.setBorderPainted(false);
            lotBtn.setForeground(Color.white);
            lotBtn.putClientProperty("lotNumber", i);
            lotBtn.putClientProperty("category", category);

            String lotName = category + " Lot " + i;

            lotBtn.addActionListener(e -> {
                if (!lotBtn.isEnabled()) return;

                if (isSelectionMode) {
                    lotBtn.setText("Unavailable");
                    lotBtn.setEnabled(false);
                    lotBtn.setToolTipText("Unavailable");
                    selectedLots.add(lotBtn);
                    payBtn.setEnabled(true);

                    //put the adding to sql here
/*                     boolean lots=dbManager.lotChoice(lotName,userId);
 */

                    isSelectionMode = false; // Disable selection after one click
                    JOptionPane.showMessageDialog(this, "Lot selected: " + lotName + ". Click 'ADD' to select another.");
                } else {
                    JOptionPane.showMessageDialog(this, "Click 'ADD' to select a lot.");
                }
            });

            lotBtn.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    if (!lotBtn.isEnabled()) {
                        lotBtn.setToolTipText("Unavailable");
                    }
                }
            });

            boxPanel.add(lotBtn);
            panel.add(boxPanel);
        }
    }



    private int calculateTotal() {
        int total = 0;
        for (JButton btn : selectedLots) {
            String category = (String) btn.getClientProperty("category");
            Integer price = priceMap.get(category);
            if (price != null) {
                total += price;
            }
                boolean pay=dbManager.updatePayment(total,userId);

        }
        return total;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window1().setVisible(true));
    }
}
