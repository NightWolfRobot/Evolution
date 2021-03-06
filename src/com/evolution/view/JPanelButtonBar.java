package com.evolution.view;

import com.evolution.controller.Controller;
import com.evolution.model.CONSTANTS;
import static com.evolution.model.CONSTANTS.PATH_IMG;
import com.evolution.observer.Observer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * JPanel of the button bar
 *
 * @author Anthony
 */
public class JPanelButtonBar extends JPanel implements CONSTANTS, Observer {

    private JButton initBtn;
    private JButton quitBtn;
    private JButton playBtn;
    private JButton stopBtn;
    private JButton saveBtn;
    private JButton resetBtn;
    private JButton loadBtn;
    private JButton undoBtn;
    private JButton redoBtn;

    public Controller c;

    ActionButton a = new ActionButton();

    /**
     * Contruction the Button bar
     *
     * @param cParam Controller
     */
    public JPanelButtonBar(Controller cParam) {
        c = cParam;

        initBtn = new JButton(new ImageIcon(PATH_IMG + "init.png"));
        initBtn.setActionCommand("INIT");
        initBtn.addActionListener(a);
        initBtn.setPreferredSize(new Dimension(40, 40));

        quitBtn = new JButton(new ImageIcon(PATH_IMG + "quit.png"));
        quitBtn.setActionCommand("QUIT");
        quitBtn.addActionListener(a);
        quitBtn.setPreferredSize(new Dimension(40, 40));

        playBtn = new JButton(new ImageIcon(PATH_IMG + "play.png"));
        playBtn.setActionCommand("PLAY");
        playBtn.addActionListener(a);
        playBtn.setPreferredSize(new Dimension(40, 40));

        loadBtn = new JButton(new ImageIcon(PATH_IMG + "load.png"));
        loadBtn.setActionCommand("LOAD");
        loadBtn.addActionListener(a);
        loadBtn.setPreferredSize(new Dimension(40, 40));

        resetBtn = new JButton(new ImageIcon(PATH_IMG + "reset.png"));
        resetBtn.setActionCommand("RESET");
        resetBtn.addActionListener(a);
        resetBtn.setPreferredSize(new Dimension(40, 40));

        saveBtn = new JButton(new ImageIcon(PATH_IMG + "save.png"));
        saveBtn.setActionCommand("SAVE");
        saveBtn.addActionListener(a);
        saveBtn.setPreferredSize(new Dimension(40, 40));

        stopBtn = new JButton(new ImageIcon(PATH_IMG + "stop.png"));
        stopBtn.setActionCommand("STOP");
        stopBtn.addActionListener(a);
        stopBtn.setPreferredSize(new Dimension(40, 40));
        
        this.add(initBtn);
        this.add(playBtn);
        this.add(stopBtn);

        this.add(saveBtn);
        this.add(loadBtn);
        
        this.add(resetBtn);
        this.add(quitBtn);

        playBtn.setEnabled(false);
        saveBtn.setEnabled(false);
        resetBtn.setEnabled(false);
        stopBtn.setEnabled(false);
    }

    /**
     * Pattern Observer, it updates the status of all buttons "enabled or not"
     */
    @Override
    public void update() {
        /**
         * 0-init / 1-play /2-save /3-reset /4-quit /5-stop /6-load
         */
        initBtn.setEnabled(!c.m.validBtn[0]);
        playBtn.setEnabled(!c.m.validBtn[1]);
        saveBtn.setEnabled(!c.m.validBtn[2]);
        resetBtn.setEnabled(!c.m.validBtn[3]);
        quitBtn.setEnabled(!c.m.validBtn[4]);
        stopBtn.setEnabled(!c.m.validBtn[5]);
        loadBtn.setEnabled(!c.m.validBtn[6]);
    }

    class ActionButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("INIT")) {
                JDialogParameters param = new JDialogParameters(c);
            }

            if (e.getActionCommand().equals("LOAD")) {

                c.loadWorld();
            }

            if (e.getActionCommand().equals("PLAY")) {
                /**
                 * 0-init / 1-play /2-save /3-reset /4-quit /5-stop /6-load
                 */
                // TRUE  = HIDEN
                c.m.flagStop = false;
                c.m.flagDeadUniverse = false;
                c.m.setBtn(2, true);
                c.m.setBtn(6, true);
                c.m.setBtn(5, false);
                c.m.setBtn(1, true);
                c.m.playATurn();
            }

            if (e.getActionCommand().equals("SAVE")) {

                c.saveWorld();

            }

            if (e.getActionCommand().equals("QUIT")) {

                c.endWindow();

            }

            if (e.getActionCommand().equals("STOP")) {
                /**
                 * 0-init / 1-play /2-save /3-reset /4-quit /5-stop /6-load
                 */
                // TRUE  = HIDEN / FALSE = VISIBLE
                c.m.flagStop = true;
                c.m.setBtn(5, true);
                c.m.setBtn(1, false);
                c.m.setBtn(2, false);
                c.m.setBtn(6, false);

            }

            if (e.getActionCommand().equals("RESET")) {
                /**
                 * 0-init / 1-play /2-save /3-reset /4-quit /5-stop /6-load
                 */
                // TRUE  = HIDEN
                c.m.resetModel();
                c.m.setBtn(0, false);
                c.m.setBtn(1, true);
                c.m.setBtn(2, true);
                c.m.setBtn(3, true);
                c.m.setBtn(5, true);
                c.m.setBtn(6, false);
            }
        }

    }
}
