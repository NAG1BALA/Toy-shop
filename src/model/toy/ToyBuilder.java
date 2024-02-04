package src.model.toy;

public class ToyBuilder {

    public Toy build(String name, int numberOfToys) {
        return new Toy(name, numberOfToys);
    }
}

