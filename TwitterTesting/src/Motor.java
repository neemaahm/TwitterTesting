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

    //turns the motor on
    public void on(){
        status = true;
        System.out.println(name + ": off");
    }

    //turns the motor off
    public void off(){
        status = false;
        System.out.println(name + ": off");
    }


}
