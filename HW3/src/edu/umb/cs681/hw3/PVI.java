package edu.umb.cs681.hw3;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVI {

    public static void main(String args[]) {
        Path tmp = FileSystems.getDefault().getPath("").toAbsolutePath();
        String pathName = tmp+"\\PVIDATA.csv";
        Path path = Paths.get (pathName);

        System.out.println(pathName);
        try (Stream<String> lines = Files.lines(path)) {
            List<List<String>> matrix = lines.map(line -> {
                return Stream.of( line.split(",") ) .map(value->value.substring(0, value.length()))
                        .collect( Collectors.toList() ); }) .collect( Collectors.toList() );
            //System.out.println(matrix);

            List Massa = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());

            List barnstable = matrix.stream().filter((i) -> i.get(5).contains("Barnstable")).collect(Collectors.toList()).get(0);
            System.out.println("A). Deaths in barnstable county of the Mass state are: " + barnstable.get(7));

            String totaldeath = matrix.stream().filter((i) -> i.get(4).contains("Massachusetts"))
                    .map((i) -> i.get(7)).reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));

            System.out.println("B). Total deaths in Mass State are: " +totaldeath);

            System.out.println("C). Average deaths in Mass State are: " + Integer.parseInt(totaldeath)/Massa.size());





        } catch (IOException ex) {
           // System.out.println("hi");
            // do something or re-throw...
        }
    }

}