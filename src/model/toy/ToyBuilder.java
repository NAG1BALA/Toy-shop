package model.toy;

import model.toy.Toy;

public class ToyBuilder {

    public Toy build(String name, int numberOfToys) {
        return new Toy(name, numberOfToys);
    }
}

