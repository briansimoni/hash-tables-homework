import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws java.io.IOException {


        HashTable table = new HashTable(12000);


        FileReader inputFile = new FileReader(args[0]);
        BufferedReader bufferReader = new BufferedReader(inputFile);
        String line;

        while ((line = bufferReader.readLine()) != null)   {
            String[] split = line.split(",");
            String city = split[0];
            String coordinates = split[1] + "," + split[2];
            table.insert(city, coordinates);
        }

        bufferReader.close();




        System.out.println(table.getObject("New York"));
        System.out.println(table.getObject("Mount Darwin"));



    }






}
