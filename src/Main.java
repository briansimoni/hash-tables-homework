import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

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





        System.out.println("Please enter a command");

        boolean stop = false;

        while(!stop) {
            Scanner input = new Scanner(System.in);

            String command = input.next();
            String arguments = input.nextLine();
            arguments = arguments.trim();


            if(command.equals("stop")) {
                stop = true;
            } else {

                String split[] = arguments.split(",");
                String city1 = split[0].trim();
                String city2 = "";
                if(split.length > 1) {
                    city2 = split[1].trim();
                }

                if(command.equals("distance")){

                    System.out.println(table.getObject(city1));
                    System.out.println(table.getObject(city2));


                } else if (command.equals("retrieve")) {
                    System.out.println(table.getObject(city1));
                } else {
                    System.out.println("Invalid input");
                }

            }
        }




    }






}
