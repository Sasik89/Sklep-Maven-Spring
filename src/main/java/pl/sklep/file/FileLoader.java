package pl.sklep.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sklep.item.product.Writable;
import pl.sklep.item.productbase.IProductBase;
import pl.sklep.users.IUsersBase;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


@Component
public class FileLoader implements IFileLoader {

    @Autowired
    private IProductBase productBase;
    @Autowired
    private IUsersBase usersBase;

    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] objectData = line.split(";");
            String[] vars = Arrays.copyOfRange(objectData, 1, objectData.length);
            switch (objectData[0]) {
                case "RTV":
                    this.productBase.varsAddNewRTV(vars);
                    break;
                case "AGD":
                    this.productBase.varsAddNewAGD(vars);
                    break;
                case "Users":
                    this.usersBase.addUser(vars);
                    break;
                default:
                    System.out.println("Nieoczekiwany typ podczas ładowania bazy danych !!");
                    break;
            }
        }
        reader.close();
    }

    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(this.productBase.getProducts());
        entries.addAll(this.usersBase.getUsers());
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("db.csv"));
        boolean firstTime = true;
        for (Writable entry : entries) {
            String lineInFile = entry.toCSV();
            if (!firstTime) {
                writer.newLine();
            }
            firstTime = false;
            writer.write(lineInFile);
        }
        writer.close();
    }
}
