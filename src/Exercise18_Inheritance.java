class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Exercise18_Inheritance {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        System.out.print("Animal makes sound: ");
        myAnimal.makeSound();
        
        Dog myDog = new Dog();
        System.out.print("Dog makes sound: ");
        myDog.makeSound();
    }
}
