package lojadedoces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LojaDeDoces extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel[] itemLabels;
    private ImageIcon[] itemImages;
    private JTextField[] quantityFields;
    private JButton orderButton;
    private JPanel[] itemPanels;

    public LojaDeDoces() {
        super("Loja de Doces");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Ajustado para acomodar as imagens
        setLayout(new BorderLayout());

        // Título
        titleLabel = new JLabel("Loja de Doces", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Painel para os itens
        JPanel itemsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        itemLabels = new JLabel[3];
        itemImages = new ImageIcon[3];
        quantityFields = new JTextField[3];
        itemPanels = new JPanel[3];

        // Item 1: Brigadeiro
        itemImages[0] = new ImageIcon("brigadeiro.jpg"); // Verifique o caminho das imagens
        itemLabels[0] = new JLabel("R$ 10,00");
        quantityFields[0] = new JTextField( 3);
        itemPanels[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanels[0].add(new JLabel(itemImages[0]));
        itemPanels[0].add(itemLabels[0]);
        itemPanels[0].add(quantityFields[0]);

        // Item 2: Biscoito
        itemImages[1] = new ImageIcon("pudim.jpg"); // Verifique o caminho das imagens
        itemLabels[1] = new JLabel("R$ 15,00");
        quantityFields[1] = new JTextField( 3);
        itemPanels[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanels[1].add(new JLabel(itemImages[1]));
        itemPanels[1].add(itemLabels[1]);
        itemPanels[1].add(quantityFields[1]);

        // Item 3: Pudim
        itemImages[2] = new ImageIcon("bolo.jpg"); // Verifique o caminho das imagens
        itemLabels[2] = new JLabel("R$ 25,00");
        quantityFields[2] = new JTextField( 3);
        itemPanels[2] = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanels[2].add(new JLabel(itemImages[2]));
        itemPanels[2].add(itemLabels[2]);
        itemPanels[2].add(quantityFields[2]);

        for (JPanel itemPanel : itemPanels) {
            itemsPanel.add(itemPanel);
        }

        add(itemsPanel, BorderLayout.CENTER);

        // Botão Pedir
        orderButton = new JButton("Pedir");
        orderButton.addActionListener(this);
        add(orderButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderButton) {
            // Processar o pedido
            StringBuilder pedido = new StringBuilder("Seu pedido:\n");
            for (int i = 0; i < itemLabels.length; i++) {
                try {
                    int quantidade = Integer.parseInt(quantityFields[i].getText());
                    pedido.append(itemLabels[i].getText()).append(" x ").append(quantidade).append("\n");
                } catch (NumberFormatException ex) {
                    // Caso o campo de quantidade não seja um número válido
                    pedido.append(itemLabels[i].getText()).append(" x 0\n");
                }
            }
            JOptionPane.showMessageDialog(this, pedido.toString());
        }
    }

    public static void main(String[] args) {
        new LojaDeDoces();
    }
}
