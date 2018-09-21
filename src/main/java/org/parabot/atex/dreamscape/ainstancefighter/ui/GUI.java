package org.parabot.atex.dreamscape.ainstancefighter.ui;

import org.parabot.atex.dreamscape.ainstancefighter.data.Boss;
import org.parabot.atex.dreamscape.ainstancefighter.data.Potion;
import org.parabot.atex.dreamscape.ainstancefighter.data.Settings;
import org.parabot.environment.api.utils.Time;
import org.rev317.min.api.methods.Prayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    private Settings settings;

    private JComboBox cmbSelectBoss;
    private JCheckBox chkUseFood;
    private JTextField txtFoodId;
    private JTextField txtFoodAmount;
    private JCheckBox chkUsePrayerPots;
    private JComboBox cmbSelectPotion;
    private JCheckBox chkUsePrayer;
    private JList lstCurses;
    private JPanel contentPane;
    private JButton startButton;
    private JTextField txtPotionAmount;
    private JSlider sdrHealthTreshold;
    private JSlider sdrPrayerTreshold;

    /**
     * Method for testing purposes
     * @param args
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        while(gui.isVisible()) {
            Time.sleep(100);
        }
    }

    public GUI() {
        setTitle("Configure script");
        setContentPane(contentPane);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(startButton);
        for(Boss boss : Boss.values()) {
            cmbSelectBoss.addItem(boss);
        }
        for(Potion potion : Potion.values()) {
            cmbSelectPotion.addItem(potion);
        }
        lstCurses.setListData(Prayer.Curse.values());

        pack();
        setVisible(true);

        chkUseFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                txtFoodAmount.setEnabled(cb.isSelected());
                txtFoodId.setEnabled(cb.isSelected());
                sdrHealthTreshold.setEnabled(cb.isSelected());
            }
        });

        chkUsePrayerPots.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                cmbSelectPotion.setEnabled(cb.isSelected());
                txtPotionAmount.setEnabled(cb.isSelected());
                sdrPrayerTreshold.setEnabled(cb.isSelected());
            }
        });

        chkUsePrayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox cb = (JCheckBox) e.getSource();
                lstCurses.setEnabled(cb.isSelected());
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateForm() != null) {
                    settings = validateForm();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        });

    }

    private Settings validateForm() {
        int foodId = 0;
        Potion potion = (Potion)cmbSelectPotion.getSelectedItem();;
        int prayerTreshold = 0;
        int healthTreshold = 0;
        int foodCount = 0;
        int potionCount = 0;
        Boss selectedBoss;
        ArrayList<Prayer.Curse> curses = new ArrayList<>();
        try {
            selectedBoss = (Boss)cmbSelectBoss.getSelectedItem();
            if(chkUseFood.isSelected()) {
                foodId = Integer.parseInt(txtFoodId.getText());
                foodCount = Integer.parseInt(txtFoodAmount.getText());
                healthTreshold = sdrHealthTreshold.getValue();
            }
            if(chkUsePrayer.isSelected()) {
                for(int i : lstCurses.getSelectedIndices()) {
                    curses.add(Prayer.Curse.values()[i]);
                }
            }
            if(chkUsePrayerPots.isSelected()) {
                potionCount = Integer.parseInt(txtPotionAmount.getText());
                prayerTreshold = sdrPrayerTreshold.getValue();
            }

            if(foodCount > 27){
                foodCount = 27;
                potionCount = 0;
            }
            if(foodCount + potionCount > 27) {
               potionCount = 27 - foodCount;
            }
            return new Settings(foodId, potion, prayerTreshold, healthTreshold, foodCount, potionCount, selectedBoss, curses);
        } catch(Exception ex) {
            return null;
        }
    }

    public Settings getSettings() {
        return settings;
    }
}
