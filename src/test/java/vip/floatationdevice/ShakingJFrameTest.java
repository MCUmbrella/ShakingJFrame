package vip.floatationdevice;

import javax.swing.*;

public class ShakingJFrameTest
{
    public static void main(String[] args)
    {
        ShakingJFrame frame = new ShakingJFrame();
        frame.setTitle("move it move it");
        JLabel label = new JLabel("i like to move it move it");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(ShakingJFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setShakingStatus(true);
        new Thread()
        {
            int strength = 0;
            int time = 0;
            @Override
            public void run()
            {
                try
                {
                    for(;;)
                    {
                        if(time == 200)
                        {
                            frame.dispose();
                            System.exit(0);
                        }
                        frame.setShakingStrength(strength);
                        strength++;
                        time++;
                        sleep(500);
                    }
                }catch(Exception e){}
            }
        }.start();
    }
}
