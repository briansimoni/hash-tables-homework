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


                    double lat1 = latitude((String)table.getObject(city1));
                    double lon1 = longitude((String)table.getObject(city1));
                    double lat2 = latitude((String)table.getObject(city2));
                    double lon2 = longitude((String)table.getObject(city2));


                    double distance = haversine(lat1, lon1, lat2, lon2);
                    System.out.println(distance);


                } else if (command.equals("retrieve")) {
                    System.out.println(table.getObject(city1));
                } else {
                    System.out.println("Invalid input");
                }

            }
        }




    }

    // Get latitude from coordinates string
    static double latitude(String coordinates) {
        String split[] = coordinates.split(",");
        return Double.valueOf(split[0]);
    }

    // Get longitude from coordinates string
    static double longitude(String coordinates) {
        String split[] = coordinates.split(",");
        return Double.valueOf(split[1]);
    }




    static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6372.8;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }





}
