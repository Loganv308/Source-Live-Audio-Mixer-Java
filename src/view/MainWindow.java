package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class MainWindow {

    public static void run(String args[])
    {
        JFrame frame = new JFrame();

        frame.setTitle("Source Live Audio Mixer"); // Call the setTitle method on the instance
        frame.setSize(600, 400);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        // Panel to hold the buttons
        JPanel bottom_panel = new JPanel(new BorderLayout());

        JButton import_button = new JButton("Import");
        JButton youtube_Query_button = new JButton("Youtube Query");
        JButton settings_button = new JButton("Settings");
        JButton start_button = new JButton("Start");
        JButton playKey_button = new JButton("Play Key");

        import_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Import button clicked");
            }
        });

        youtube_Query_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Youtube Query button clicked");
            }
        });

        settings_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Settings button clicked");
            }
        });

        start_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Start button clicked");
            }
        });

        playKey_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Play Key button clicked");
                
            }
        });

        bottom_panel.add(import_button, BorderLayout.PAGE_START);
        bottom_panel.add(youtube_Query_button, BorderLayout.PAGE_END);
        bottom_panel.add(settings_button, BorderLayout.LINE_END);
        bottom_panel.add(start_button, BorderLayout.LINE_START);
        bottom_panel.add(playKey_button, BorderLayout.CENTER);
        
        frame.add(bottom_panel);

        frame.setVisible(true);
    }  
}
