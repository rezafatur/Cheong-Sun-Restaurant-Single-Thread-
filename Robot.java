package testsinglethread;

import java.util.ArrayList;
import java.util.List;

public class Robot{
    public void robotHotdogs(){
        // Metode Robot Membuat Hotdogs
    }
    
    public void robotHamburgers(){
        // Metode Robot Membuat Hamburgers
    }
    
    public void robotFriedChicken(){
        // Metode Robot Membuat Fried Chicken
    }
    
    public void robotFrenchFries(){
        // Metode Robot Membuat French Fries
    }
    
    public void robotMinuman(){
        // Metode Robot Membuat Minuman
    }
}

class RobotMasakPaket_A extends Robot implements Runnable{
    @Override
    public void run(){
        robotHotdogs();
        robotFrenchFries();
        robotMinuman();
    }
}

class RobotMasakPaket_B extends Robot implements Runnable{
    @Override
    public void run(){
        robotHamburgers();
        robotFrenchFries();
        robotMinuman();
    }
}

class RobotMasakPaket_C extends Robot implements Runnable{
    @Override
    public void run(){
        robotFriedChicken();
        robotFrenchFries();
        robotMinuman();
    }
}