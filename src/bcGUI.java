import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Dylan on 1/05/2014.
 */
public class bcGUI extends JFrame {
    private JTabbedPane battleModeTab;
    private JPanel btcPanel;
    private JSpinner wwAtkWpnSpinner;
    private JSpinner wwDefWpnSpinner;
    private JSpinner wwAtkShipSpinner;
    private JSpinner wwDefShipSpinner;
    private JLabel wwAtkLabel;
    private JLabel wwDefLabel;
    private JLabel wwAtkShipLabel;
    private JLabel wwAtkWpnLabel;
    private JLabel wwDefShipLabel;
    private JLabel wwDefWpnLabel;
    private JLabel wwAtkWinLoseLabel;
    private JLabel wwDefWinLoseLabel;
    private JPanel whoWinsModePanel;
    private JPanel wwDefPanel;
    private JPanel wwAtkPanel;
    private JPanel howToWinModePanel;
    private JLabel hwChoiceLabel;
    private JRadioButton hwAtkRadioButton;
    private JRadioButton hwDefRadioButton;
    private JSpinner hwAtkWpnSpinner;
    private JSpinner hwDefShipSpinner;
    private JSpinner hwDefWpnSpinner;
    private JSpinner hwAtkShipSpinner;
    private JLabel hwAtkShipLabel;
    private JLabel hwAtkWpnLabel;
    private JPanel hwAtkPanel;
    private JPanel hwDefPanel;
    private JLabel hwDefShipLabel;
    private JLabel hwDefWpnLabel;

    public bcGUI()
    {
        super("Neptune's Pride 2 Battle Calculator wat");

        setContentPane(btcPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wwAtkWpnSpinner.setValue(1);
        wwDefWpnSpinner.setValue(1);
        hwAtkWpnSpinner.setValue(1);
        hwAtkShipSpinner.setValue(1);
        hwDefShipSpinner.setValue(1);
        hwDefWpnSpinner.setValue(1);


        wwAtkShipSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                valueChecker();
                wwController();
            }
        });
        wwAtkWpnSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                valueChecker();
                wwController();
            }
        });
        wwDefShipSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                valueChecker();
                wwController();
            }
        });
        wwDefWpnSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                valueChecker();
                wwController();
            }
        });

        hwAtkShipSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueChecker();
                hwController(true, false);
            }
        });
        hwAtkWpnSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueChecker();
                hwController(false, false);
            }
        });
        hwDefShipSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueChecker();
                hwController(false, true);
            }
        });
        hwDefWpnSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueChecker();
                hwController(false, false);
            }
        });



        setVisible(true);
    }

    private void wwController()
    {
        if (wwCalc.winCalculator( (Integer)wwAtkShipSpinner.getValue(), (Integer)wwAtkWpnSpinner.getValue(), (Integer)wwDefShipSpinner.getValue(), (Integer)wwDefWpnSpinner.getValue()))
        {
            wwAtkWinLoseLabel.setText("Winner");
            wwDefWinLoseLabel.setText("Loser");
        }
        else
        {
            wwAtkWinLoseLabel.setText("Loser");
            wwDefWinLoseLabel.setText("Winner");
        }
    }

    private void hwController(boolean atkShipChange, boolean defShipChange)
    {
        if (hwAtkRadioButton.isSelected()) {
            if (atkShipChange) {
                if ((Integer)hwAtkShipSpinner.getValue() <= (Integer)hwDefWpnSpinner.getValue() + 1)
                    hwAtkShipSpinner.setValue((Integer) hwDefWpnSpinner.getValue() + 2);
                hwAtkWpnSpinner.setValue(hwCalc.atkWeaponCalculator((Integer) hwAtkShipSpinner.getValue(), (Integer) hwDefShipSpinner.getValue(), (Integer) hwDefWpnSpinner.getValue()));
            } else {
                hwAtkShipSpinner.setValue(hwCalc.atkShipCalculator((Integer) hwAtkWpnSpinner.getValue(), (Integer) hwDefShipSpinner.getValue(), (Integer) hwDefWpnSpinner.getValue()));
            }
        }
        if (hwDefRadioButton.isSelected()) {
            if (defShipChange) {
                hwDefWpnSpinner.setValue(hwCalc.defWeaponCalculator((Integer) hwAtkShipSpinner.getValue(), (Integer) hwAtkWpnSpinner.getValue(), (Integer) hwDefShipSpinner.getValue()));
            } else {
                hwDefShipSpinner.setValue(hwCalc.defShipCalculator((Integer) hwAtkShipSpinner.getValue(), (Integer) hwAtkWpnSpinner.getValue(), (Integer) hwDefWpnSpinner.getValue()));
            }
        }
    }

    private void valueChecker()
    {
        if ((Integer)wwAtkShipSpinner.getValue() < 0)
            {wwAtkShipSpinner.setValue(0);}
        if ((Integer)wwAtkWpnSpinner.getValue() < 1)
            {wwAtkWpnSpinner.setValue(1);}
        if ((Integer)wwDefShipSpinner.getValue() < 0)
            {wwDefShipSpinner.setValue(0);}
        if ((Integer)wwDefWpnSpinner.getValue() < 1)
            {wwDefWpnSpinner.setValue(1);}
        if ((Integer)hwAtkShipSpinner.getValue() < 1)
            {hwAtkShipSpinner.setValue(1);}
        if ((Integer)hwAtkWpnSpinner.getValue() < 1)
            {hwAtkWpnSpinner.setValue(1);}
        if ((Integer)hwDefShipSpinner.getValue() < 1)
            {hwDefShipSpinner.setValue(1);}
        if ((Integer)hwDefWpnSpinner.getValue() < 1)
            {hwDefWpnSpinner.setValue(1);}
    }
}
