package Swing;

import Model.CurrencySet;
import View.UI.ExchangeDialog;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.SOUTH;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private final CurrencySet currencySet;
    private ExchangeDialog exchangeDialog;
    private ActionListener actionListener;

    public ApplicationFrame(CurrencySet currencySet) {
        this.currencySet = currencySet;
        this.setTitle("Money Calculator");
        this.setLayout(new BorderLayout());
        this.setSize(250, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(createExchangeDialogPanel(currencySet));
        this.getContentPane().add(createMoneyPanel(), SOUTH);
        this.getContentPane().add(createCalculateButton(), SOUTH);
        
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calcular");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Pendiente
            }
        });
        return button;
    }

    private JPanel createMoneyPanel() {
        return new JPanel();
    }

    private JPanel createExchangeDialogPanel(CurrencySet currencySet) {
        ExchangeDialogPanel exchangeDialogPanel = new ExchangeDialogPanel(currencySet);
        exchangeDialog = exchangeDialogPanel;
        return exchangeDialogPanel;
    }
    
    
}
