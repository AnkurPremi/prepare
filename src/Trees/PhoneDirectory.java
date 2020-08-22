package Trees;

//can be represented using an arrayList
//can be represented using a 10-ary tree
public class PhoneDirectory {
    PhoneNumberNode node;

    PhoneDirectory() {
        node = new PhoneNumberNode();
    }

    public static void main(String[] args) throws Exception{
        PhoneDirectory directory = new PhoneDirectory();
        directory.addPhoneNumber("9837602047", "Daddy");
        directory.addPhoneNumber("9358027122", "Mummy");
        directory.addPhoneNumber("8479900801", "Ankur");
        directory.addPhoneNumber("9997022867", "Ankit");

        String name = directory.searchPhoneNumber("8479900801");
        System.out.println(name);
        name = directory.searchPhoneNumber("9997022867");
        System.out.println(name);
        name = directory.searchPhoneNumber("9205567472");
        System.out.println(name);
    }

    public void addPhoneNumber(String number, String name) {
        PhoneNumberNode temp = node;
        for (int i = 0; i < number.length(); i++) {
            int val = Character.getNumericValue(number.charAt(i));
            if (temp.arr[val] == null) {
                temp.arr[val] = new PhoneNumberNode();
            }
            temp = temp.arr[val];
        }
        temp.name = name;
    }

    //It's a number to name relationship
    public String searchPhoneNumber(String number) throws Exception{
        System.out.println("Searching ..."+ number);
        Thread.sleep(3000);
        PhoneNumberNode temp = node;
        for (int i = 0; i < number.length(); i++) {
            int val = Character.getNumericValue(number.charAt(i));
            if (temp.arr[val] == null) {
                return "Phone number doesn't exist in the directory";
            }
            temp = temp.arr[val];
        }
        return temp.name;
    }
}

class PhoneNumberNode {
    PhoneNumberNode[] arr = new PhoneNumberNode[10];
    String name = null;
}
