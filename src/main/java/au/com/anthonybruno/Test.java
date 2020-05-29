package au.com.anthonybruno;

import au.com.anthonybruno.generator.defaults.IntGenerator;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        File file;
        try {
            file = File.createTempFile("test", ".csv");
            System.out.println("file path : " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(" Start time: "+  new Timestamp(System.currentTimeMillis()));


            Faker faker = new Faker();

            Gen.start()
                    .addField("First Name", () -> faker.name().firstName())
                    .addField("Last Name", () -> faker.name().lastName())
                    .addField("Age", new IntGenerator(18, 80))
                    .generate(291271111)
                    .asCsv()
                    .toFile(file);

            System.out.println(" Success!! End time: "+  new Timestamp(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Error!! End time: "+  new Timestamp(System.currentTimeMillis()));
        }


    }
}
