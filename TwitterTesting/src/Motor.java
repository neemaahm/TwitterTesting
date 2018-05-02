/**
 * Created by Neema on 4/29/2018.
 */
public class Motor {
    private String name;
    //if motor is on then status == true
    private boolean status;

    //constructor
    public Motor(String name) {
        this.name = name;
        status = false;
    }

    //turns the motor off
    public void off() {
        status = false;
        System.out.println(/*name + */": off");
    }

    public void on() {
        status = true;
        System.out.println(/*name + */": on");
    }

    //turns the motor on for a certain amount of time
    public void on(int milliseconds) {
        on();
        try {
            Thread.sleep(milliseconds); //sleep amount of milliseconds
            off();
        } catch (InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }

    public void pwm(double dutyCycle, int duration){
        int ratio = ((int)((dutyCycle+0.05)*10));
        int resolution = 10;
        System.out.println(ratio);
        int numbOfLoops = duration*(1000/resolution);
        for(int i=0; i<numbOfLoops; i++){
            if (i<ratio){
                System.out.println("ONIT");
                on();
                try{ Thread.sleep(resolution);} catch(InterruptedException e){ System.out.println("Interrupted");}
            } else {
                System.out.println("OFFIT");
                off();
                try{ Thread.sleep(resolution);} catch(InterruptedException e){ System.out.println("Interrupted");}
            }
        }

    }
}
