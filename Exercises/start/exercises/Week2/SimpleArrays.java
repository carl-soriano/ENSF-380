package Week2;

public class SimpleArrays {

    private String[] string_array; 

    public SimpleArrays() {
        this("Hello, World");
    }

    public SimpleArrays(String string_input) {

        string_array = new String[4];
        java.util.Arrays.fill(string_array,string_input);
    
    }

    public String arrayConcat(int index) {
        if (index >= string_array.length || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        String concat = "";
        for (int i = index; i < string_array.length; i++) {
            concat += string_array[i];
            if (i < string_array.length - 1) {
                concat += "#";
            }
        }
        return concat;
    }

    public String arrayCrop(int start, int end) {
        if (start < 0 || (start >= string_array.length) || end < 0 || (end >= string_array.length)) {
            return "Fail";
        }

        if (start > end) {
            int mem = start;
            start = end;
            end = mem;
        }

        if (start == end) {
            return "Match";
        }

        String concat = "";

        for (int i = start; i <= end; i++) {
            concat += string_array[i];
            if (i < end) {
                concat += "#";
            }
        }
        return concat;
    }

    public static void main(String[] args){
        SimpleArrays myArray1 = new SimpleArrays();
        String foundResult1 = myArray1.arrayConcat(0);
        System.out.println(foundResult1);
        SimpleArrays myArray2 = new SimpleArrays();
        String foundResult2 = myArray2.arrayConcat(2);
        System.out.println(foundResult2);
        SimpleArrays myArray3 = new SimpleArrays("Hi you");
        String foundResult3 = myArray3.arrayConcat(0);
        System.out.println(foundResult3);
        SimpleArrays myArray4 = new SimpleArrays("Hi you");
        String foundResult4 = myArray4.arrayConcat(2);
        System.out.println(foundResult4);
        SimpleArrays myArray5 = new SimpleArrays("Hi you");
        String foundResult5 = myArray5.arrayCrop(0, 2);
        System.out.println(foundResult5);
        SimpleArrays myArray6 = new SimpleArrays("Hi you");
        String foundResult6 = myArray6.arrayCrop(3, 2);
        System.out.println(foundResult6);
        SimpleArrays myArray7 = new SimpleArrays("Hi you");
        String foundResult7 = myArray7.arrayCrop(0, 6);
        System.out.println(foundResult7);
        SimpleArrays myArray8 = new SimpleArrays("Hi you");
        String foundResult8 = myArray8.arrayCrop(3, 3);
        System.out.println(foundResult8);
        }

}
    