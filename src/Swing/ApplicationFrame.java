package Swing;

import Control.Command;
import Model.CurrencySet;
import View.UI.ExchangeDialog;
import View.UI.MoneyDisplay;
import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private final CurrencySet currencySet;
    private Command command;
    private ExchangeDialog exchangeDialog;
    private MoneyPanel moneyPanel;
    private ActionListener actionListener;

    public ApplicationFrame(CurrencySet currencySet) {
        this.currencySet = currencySet;
        this.setTitle("Money Calculator");
        this.setLayout(new BorderLayout());
        this.setSize(350, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(createExchangeDialogPanel(currencySet), NORTH);
        this.getContentPane().add(createMoneyPanel(), CENTER);
        this.getContentPane().add(createCalculateButton(), SOUTH);
        this.setVisible(true);

    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calcular");
        button.addActionListener((ActionEvent e) -> {
            command.execute();
        });
        return button;
    }

    private JPanel createMoneyPanel() {
        this.moneyPanel = new MoneyPanel();
        return this.moneyPanel;
    }

    private JPanel createExchangeDialogPanel(CurrencySet currencySet) {
        ExchangeDialogPanel exchangeDialogPanel = new ExchangeDialogPanel(currencySet);
        exchangeDialog = exchangeDialogPanel;
        return exchangeDialogPanel;
    }

    public ExchangeDialog getExchangeDialog() {
        return exchangeDialog;
    }

    public void registerCommand(Command command) {
        this.command = command;
    }

    public MoneyDisplay getMoneyPanel() {
        return moneyPanel;
    }

}
