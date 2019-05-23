package Java1.lesson6;

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Barsik");
        Dog dog = new Dog("Tuzik");

        dog.run(490);
        cat.run(100);
        cat.swim(100);
        dog.swim(2);

        Animal[] animals = {new Cat("Bars"),
                new Dog("Sharik"),
                new Cat("Rishik"),
                new Dog("Tuzik"),
                new Cat("Murzik"),
        };
        int i = 0;
        int j = 0;

        for (Animal a : animals) {
            if (a instanceof Cat) i++;
            else j++;
        }
        System.out.println("Создано котов: " + i + ". Создано собак: " + j);
    }
}

class Animal {

    protected String type;
    protected String name;

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;

    }

    public void voice() {
        System.out.println(type+" "+name + " издает звук");
    }

    public void info() {
        System.out.println(name + " " + type);
    }

    public void run(int distance) {
        System.out.println(type+" " + name + " may run at distance - " + distance+" !");
    }
    public void swim(int distance) {
        System.out.println(type+" "+ name + " may swim at distance - " + distance+" !");
    }
}

class Cat extends Animal {


    public Cat() {
        super();
        type = "Cat";
    }

    public Cat(String name) {
        super(name);
        type="Cat";
    }

    public Cat(String name, String color) {
        super(name);
        type ="Cat";
    }

    @Override
    public void swim(int distance) {
        System.out.println(type + " cannot swim...");
    }
    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println(type + " " + name +" не может пробежать "+ distance+" метров.");
        }
        else
            System.out.println(type+" " + name + " пробежал - " + distance+" метров!");
    }



}

class Dog extends Animal {
    public Dog() {
        type = "Dog";
    }

    public Dog(String name) {
        super(name);
        type = "Dog";
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(type + " " + name +" не может проплыть "+ distance+" метров.");
        }
        else
            System.out.println(type + " " + name +" проплыл "+ distance+" метров.");
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(type + " " + name +" не может пробежать "+ distance+" метров.");
        }
        else
            System.out.println(type+" " + name + " пробежал - " + distance+" метров!");
    }



}




