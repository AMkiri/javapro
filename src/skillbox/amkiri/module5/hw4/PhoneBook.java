package skillbox.amkiri.module5.hw4;

import java.util.Map;
import java.util.TreeMap;

class PhoneBook {

    private Map<String, String> phoneBook;

    PhoneBook() {
        phoneBook = new TreeMap<>();
    }

    String addContact(Entry newEntry) {
        String result = phoneBook.containsKey(newEntry.name) ?
                "Contact updated." :
                "New contact created.";
        phoneBook.put(newEntry.name, newEntry.phoneNum);
        return result;
    }

    Entry findByPhoneNum(String phoneNum) {
        return phoneBook.entrySet().stream()
                .filter(entry -> entry.getValue().equals(phoneNum))
                .findFirst()
                .map(en -> new Entry(en.getKey(), en.getValue()))
                .orElse(new Entry(null, phoneNum));

    }

    Entry findByName(String name) {
        return phoneBook.containsKey(name) ?
                new Entry(name, phoneBook.get(name)) :
                new Entry(name, null);
    }

    @Override
    public String toString() {

        if (phoneBook.isEmpty()) {
            return "\nNo data.\n\n";
        }

        StringBuilder builder = new StringBuilder();

        builder.append("\n\t---\n");
        for (Map.Entry<String, String> en : phoneBook.entrySet()) {
            builder.append( PhoneNumUtils.printPhoneBookEntry(en.getKey(), en.getValue()) );
            builder.append("\n");
        }
        builder.append("\t---\n\n");

        return builder.toString();
    }

    class Entry {
        private String phoneNum;
        private String name;

        Entry(String name, String phoneNum) {
            this.phoneNum = phoneNum;
            this.name = name;
        }

        String getPhoneNum() {
            return phoneNum;
        }

        String getName() {
            return name;
        }

        void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return PhoneNumUtils.printPhoneBookEntry(name, phoneNum);
        }
    }
}
