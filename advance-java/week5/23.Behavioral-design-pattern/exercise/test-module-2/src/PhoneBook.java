import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    List<Person> phoneBook;

    public PhoneBook() {
        phoneBook = new ArrayList<>();
    }

    public boolean add(String phoneNumber, String group, String name, String gender, String address, String birthDate, String email) {
        String phoneNumberRegex = "^0\\d{8}$";
        String birthDateRegex = "^([0-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-\\d{4}$";
        String emailRegex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern patternPhoneNumber = Pattern.compile(phoneNumberRegex);
        Pattern patternEmail = Pattern.compile(emailRegex);
        Pattern patternBirthDate = Pattern.compile(birthDateRegex);
        Matcher phoneNumberMatcher = patternPhoneNumber.matcher(phoneNumber);
        Matcher emailMatcher = patternEmail.matcher(email);
        Matcher birthDateMatcher = patternBirthDate.matcher(birthDate);
        if (phoneNumberMatcher.matches()
                && !isBlank(group)
                && !isBlank(name)
                && isValidGender(gender)
                && !isBlank(address)
                && !isBlank(birthDate)
                && emailMatcher.matches()) {
            Person newPerson = new Person(phoneNumber,group,name,gender,address,birthDate,email);
            phoneBook.add(newPerson);
            return true;
        } else{
            return false;
        }

    }

    public void show() {
        for (Person person : phoneBook) {
            System.out.println(person.toString());
        }
    }

    public boolean delete(String phoneNumber) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).getNumber().equals(phoneNumber)) {
               phoneBook.remove(i);
               return true;
            }
        }
        return false;
    }

    public int find(String phoneOrName) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).getNumber().equals(phoneOrName) || phoneBook.get(i).getName().equals(phoneOrName)) {
                return i;
            }

        }
        return -1;
    }

    public String showAt(int index) {
        return phoneBook.get(index).toString();
    }



    public static boolean  isBlank(String string) {
       return string == null || string.trim().isEmpty();
    }

    public static boolean isValidGender(String gender) {
        if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
            return true;
        }
        else {
            return false;
        }
    }
}
