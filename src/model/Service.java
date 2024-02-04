package model;



import model.toy.Toy;
import model.toy.ToyBuilder;
import model.toylist.ToyList;
import model.writer.Writable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private ToyList toyList;
    private ToyBuilder builder;
    private Writable writable;

    public Service() {
        toyList = new ToyList();
        builder = new ToyBuilder();
    }


    public boolean save() {
        return writable.write(toyList, "list.data");
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public List<Toy> resultList() throws IOException {
        FileWriter filewriter = new FileWriter("result.txt");
        List<Toy> result = toyList.resultList(toyList);

        for (Toy item : result) {
            filewriter.write("ID: " + item.getId() + ", Игрушка: " + item.getName());
            filewriter.write(System.lineSeparator());
        }
        filewriter.flush();
        filewriter.close();
        return result;
    }

    public String addToy(String name, int numberOfToys) {
        Toy toy = builder.build(name, numberOfToys);
        toyList.addToy(toy);
        toyList.setTotal(toyList.getTotal() + numberOfToys);
        toyList.setFrequences(toyList.getTotal());
        return toy.toString();
    }

    public boolean deleteToy(int id) {
        toyList.deleteToy(id);
        return save();
    }

    public String getInfo() {
        return toyList.getInfo();
    }

    public String changeNumberOfToys(int id, int numberOfToys) {
        Toy toy = toyList.findInList(id);
        toyList.setTotal(toyList.getTotal() - toy.getNumberOfToys());
        toy.setNumberOfToys(numberOfToys);
        toyList.setTotal(toyList.getTotal() + numberOfToys);
        toyList.setFrequences(toyList.getTotal());
        return toy.toString();
    }

    public void load() throws IOException {
        toyList = (ToyList) writable.read("list.data");
    }

    public String viewResultList() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("result.txt"))) {
            sb.append(br.lines().collect(Collectors.joining(System.lineSeparator())));
            return sb.toString();
        } catch (
                IOException e) {
            e.getMessage();
        }
        return null;
    }
}
