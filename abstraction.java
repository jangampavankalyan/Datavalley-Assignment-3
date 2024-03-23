Abstraction in Java is a concept that allows you to hide the complex implementation details and show only the necessary features of an object. It enables you to focus on what an object does rather than how it achieves its functionality. In Java, abstraction is achieved using abstract classes and interfaces.

There are two main ways to implement abstraction in Java:

Abstract Classes:

An abstract class is a class that cannot be instantiated and may contain one or more abstract methods.
Abstract methods are declared without implementation.
Abstract classes can also contain concrete methods with implementation.
Subclasses of abstract classes must implement all the abstract methods or be declared abstract themselves.
  Interfaces:

An interface is a reference type in Java that contains only abstract methods and constants.
Interfaces cannot have method implementations.
Classes can implement one or multiple interfaces, providing implementations for all the abstract methods defined in the interfaces.
Interfaces support multiple inheritance in Java.
  // Abstract class representing a Vehicle
abstract class Vehicle {
    // Abstract method to start the vehicle
    public abstract void start();

    // Abstract method to stop the vehicle
    public abstract void stop();

    // Concrete method to display information about the vehicle
    public void displayInfo() {
        System.out.println("Vehicle information:");
    }
}

// Concrete class representing a Car
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

// Interface representing a Musical Instrument
interface MusicalInstrument {
    void playSound();
}

// Concrete class representing a Guitar
class Guitar implements MusicalInstrument {
    @Override
    public void playSound() {
        System.out.println("Guitar playing...");
    }
}

// Concrete class representing a Piano
class Piano implements MusicalInstrument {
    @Override
    public void playSound() {
        System.out.println("Piano playing...");
    }
}

public class Main {
    public static void main(String[] args) {
        // Abstraction using abstract classes
        Vehicle car = new Car();
        car.displayInfo();
        car.start();
        car.stop();

        // Abstraction using interfaces
        MusicalInstrument guitar = new Guitar();
        guitar.playSound();

        MusicalInstrument piano = new Piano();
        piano.playSound();
    }
}
Vehicle is an abstract class representing a generic vehicle with abstract methods for starting and stopping.
Car is a concrete class extending the Vehicle abstract class and implementing its abstract methods.
MusicalInstrument is an interface representing an entity that can play sound.
Guitar and Piano are concrete classes implementing the MusicalInstrument interface and providing their specific implementations for the playSound() method.
