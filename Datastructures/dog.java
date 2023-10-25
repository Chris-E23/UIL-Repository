package Datastructures;
class animal{

    private int age;
    private int height;
    private String name;

    public animal(int age, int height, String name){

        this.age = age;
        this.height = height;
        this.name = name;
    }

    public animal(int age, int height){
        this(age, height, "unnamed");
    }


}
public class dog extends animal{
    

    private boolean happy; 
    public dog(int age, int height, String name, boolean happy){

        super(age, height, name);
        this.happy = happy;
    }

    public dog(int age, int height){
        this(age, height, "unnamed", true);
    }

    public void bark(String noise){

        System.out.println(noise);

    }

}
class run{

    public static void main(String[] args){
        dog doggy = new dog(4, 48, "Jax", true);
        dog doggy2 = new dog(4, 48);

        doggy.bark("woof");
        doggy2.bark("arf");

    }


}