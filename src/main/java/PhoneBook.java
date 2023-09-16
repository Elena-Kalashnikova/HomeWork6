import java.security.KeyStore;
import java.util.*;

public class PhoneBook {


    public static void addContact(Map<String, ArrayList<Integer>> phonebook, String name, int number) {
        if (phonebook.containsKey(name)) {
            phonebook.get(name).add(number);
        } else {
            ArrayList<Integer> listNumber = new ArrayList<>();
            listNumber.add(number);
            phonebook.put(name, listNumber);
        }

    }




    public static void printPhoneBook(Map<String, ArrayList<Integer>> phonebook) {
        ArrayList<Map.Entry<String, ArrayList>> sortNumbers = new ArrayList(phonebook.entrySet());
        Collections.sort(sortNumbers, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
                return o2.getValue().size()-o1.getValue().size();
            }
        });


        for (Map.Entry<String, ArrayList> entry : sortNumbers) {
            String key = entry.getKey();
            String value = String.valueOf(entry.getValue());
            System.out.printf("%s -> %s%n", key, value);

        };
    }


    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Пушкин", 1368);
        addContact(phoneBook, "Лермонтов", 1256);
        addContact(phoneBook, "Есенин", 1254);
        addContact(phoneBook, "Есенин", 1257);
        addContact(phoneBook, "Есенин", 1256);
        addContact(phoneBook, "Булгаков", 1234);
        addContact(phoneBook, "Булгаков", 1233);

        printPhoneBook(phoneBook);
    }
}




