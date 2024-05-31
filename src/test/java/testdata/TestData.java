package testdata;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Locale;


public class TestData {

    Faker faker = new Faker(new Locale("en"));

    private Date data = faker.date().birthday();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String gender = faker.options().nextElement(new String[]{"Male", "Female", "Other"});
    public String mobile = faker.phoneNumber().subscriberNumber(10);
    public String hobbies = faker.options().nextElement(new String[]{"Sports", "Reading", "Music"});
    public String file = faker.options().nextElement(new String[]{"test.png"});
    public String state = faker.options().nextElement(new String[]{"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"});
    public String city = getCity(state);
    public String subjects = faker.options().nextElement(new String[]{"Maths", "Accounting", "Arts", "Social Studies", "Physics", "Chemistry"});
    public String year = String.valueOf((data.getYear() + 1900));
    public String day = getDay();
    public String month = getMonth();


    private String getDay() {
        String day = "";
        if (data.getDate() < 10)
            day = "0" + String.valueOf(data.getDate());
        else day = String.valueOf(data.getDate());
        return day;
    }

    private String getMonth() {
        String[] nameMonth = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return nameMonth[data.getMonth()];

    }


    private String getCity(String state) {
        String city = "";
        switch (state) {
            case ("NCR"):
                city = faker.options().nextElement(new String[]{"Delhi", "Gurgaon", "Noida"});
                break;
            case ("Uttar Pradesh"):
                city = faker.options().nextElement(new String[]{"Agra", "Lucknow", "Merrut"});
                break;
            case ("Haryana"):
                city = faker.options().nextElement(new String[]{"Karnal", "Panipat"});
                break;
            case ("Rajasthan"):
                city = faker.options().nextElement(new String[]{"Jaipur", "Jaiselmer"});
                break;
        }
        return city;
    }

}
