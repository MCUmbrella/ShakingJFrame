package vip.floatationdevice;

import javax.swing.*;
import java.util.Random;

public class ShakingJFrame extends JFrame
{
    boolean isShaking = false;
    private int shakingStrength=1;
    public ShakingJFrame setShakingStrength(int strength)
    {
        if(strength<0) throw new IllegalArgumentException("Strength must >=0");
        shakingStrength=strength+1;
        return this;
    }
    public ShakingJFrame setShakingStatus(boolean status)
    {
        isShaking=status;
        return this;
    }
    public ShakingJFrame()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                Random random = new Random();
                //w33d
                for(;;)
                {
                    if(isShaking) setLocation((int)(getLocation().getX()+random.nextInt()%shakingStrength), (int)(getLocation().getY()+random.nextInt()%shakingStrength));
                    try {sleep(20);} catch(InterruptedException e){}
                }
            }
        }.start();
    }
}
