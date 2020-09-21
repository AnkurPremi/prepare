package DataStructures.stacks;

import java.util.LinkedList;
import java.util.Queue;

//An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
//        out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
//        or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
//        that type). They cannot select which specific animal they would like. Create the data structures to
//        maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
//        and dequeueCat. You may use the built-in Linked list data structure.
public class AnimalShelter {

    private Queue<Animal> catQ;
    private Queue<Animal> dogQ;
    private static int sNumber = 1;

    AnimalShelter() {
        catQ = new LinkedList<>();
        dogQ = new LinkedList<>();
    }

    public static void main(String[] args) {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue("cat");animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");animalShelter.enqueue("dog");
        animalShelter.enqueue("cat");animalShelter.enqueue("cat");
        animalShelter.enqueue("cat");animalShelter.enqueue("dog");
        animalShelter.enqueue("dog");animalShelter.enqueue("dog");
        System.out.println(animalShelter.deQueueAny());
        System.out.println(animalShelter.deQueueAny());
        System.out.println(animalShelter.deQueueCat());
        System.out.println(animalShelter.deQueueDog());
    }

    private void enqueue(String animalName) {
        if (animalName.equals("cat")) {
            catQ.offer(new Animal(animalName, sNumber++));
        } else {
            dogQ.offer(new Animal(animalName, sNumber++));
        }
    }

    private String deQueueAny() {
        if (dogQ.isEmpty() && catQ.isEmpty()) return null;
        else if (dogQ.isEmpty()) return catQ.poll().name;
        else if (catQ.isEmpty()) return dogQ.poll().name;
        else if (dogQ.peek().serialNumber < catQ.peek().serialNumber) {
            return dogQ.poll().name;
        } else {
            return catQ.poll().name;
        }
    }

    private String deQueueDog() {
        return dogQ.isEmpty() ? null : dogQ.poll().name;

    }

    private String deQueueCat() {
        return catQ.isEmpty() ? null : catQ.poll().name;
    }

    class Animal {
        String name;
        int serialNumber;

        Animal(String name, int serialNumber) {
            this.name = name;
            this.serialNumber = serialNumber;
        }
    }
}
