package Swing;

import Model.Currency;
import Model.CurrencySet;
import Model.Exchange;
import Model.Money;
import View.UI.ExchangeDialog;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ExchangeDialogPanel extends JPanel implements ExchangeDialog {

    private final CurrencySet currencySet;
    private double quantity;
    private Currency currencyFrom;
    private Currency currencyTo;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        this.currencySet = currencySet;
        this.setLayout(new FlowLayout());
        this.add(createQuantityField());
        this.add(createCurrencyFromComboBox());
        this.add(createCurrencyToComboBox());
    }

    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(quantity, currencyTo), currencyTo);
    }

    private JTextField createQuantityField() {
        JTextField quantityField = new JTextField();
        quantityField.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (quantityField.getText().compareTo("Introduce the desired quantity you want to convert...") == 0) {
                    quantityField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Double.parseDouble(quantityField.getText()) == 0.0) {
                    quantityField.setText("Introduce the desired quantity you want to convert...");
                }
            }
        });
        return quantityField;
    }

    private JComboBox<Currency> createCurrencyFromComboBox() {
        JComboBox<Currency> currencyFromComboBox;
        currencyFromComboBox = new JComboBox<>(currencySet.toArray());

        currencyFromComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) {
                    currencyFrom = currencyFromComboBox.getItemAt(currencyFromComboBox.getSelectedIndex());
                }
            }
        });
        return currencyFromComboBox;
    }

    private JComboBox<Currency> createCurrencyToComboBox() {
        JComboBox<Currency> currencyToComboBox;
        currencyToComboBox = new JComboBox<>(currencySet.toArray());

        currencyToComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) {
                    currencyFrom = currencyToComboBox.getItemAt(currencyToComboBox.getSelectedIndex());
                }
            }
        });
        return currencyToComboBox;
    }

}
