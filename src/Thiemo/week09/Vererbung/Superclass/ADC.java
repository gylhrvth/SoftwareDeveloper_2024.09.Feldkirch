package Thiemo.week09.Vererbung.Superclass;

public class ADC extends Champions{

    private int range;

    public ADC(String position, String name, int movementSpeed, int HP, String gender, int range) {
        super(position, name, movementSpeed, HP, gender);
        this.range = range;
        System.out.println("I am the ADC constructor");
    }

    public void ADCthings(){
        System.out.println("ADC things");
    }
}

