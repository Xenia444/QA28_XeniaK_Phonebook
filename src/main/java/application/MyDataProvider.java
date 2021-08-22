package application;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> negativeDataContactCSV() throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contactNeg.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > dataContactDP(){
        List<Object[]> list= new ArrayList<>();

        list.add(new Object[]{"Mike","D","7984516464","Mike@gmail.co","Holon Herzel3","university friend"});
        list.add(new Object[]{"John","L","9656498745","John@gmail.co","Haifa Herzel3","university friend"});
        list.add(new Object[]{"Sara","W","8465465184","Sara@gmail.co","Rehovot Herzel3","university friend"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > dataContactCSV() throws IOException{
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > validDataLogin() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"sam@gmail.com","Sam1234$"});
        list.add(new Object[]{"sam@gmail.com","Sam1234$"});
        list.add(new Object[]{"sam@gmail.com","Sam1234$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > dataFileCSV() throws IOException{
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while(line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
