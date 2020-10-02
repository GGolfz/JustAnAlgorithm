public class StringMatching {
    public static void main(String[] args) {
        String input1 = "AbCDEfGhI";
        String input2 = "aDeI";
        int pointer = 0;
        int count = 0;

        input1=input1.toLowerCase();
        input2=input2.toLowerCase();
        for (int i = 0; i < input2.length(); i++) {
            while (pointer < input1.length()) {
                if (input1.charAt(pointer) == input2.charAt(i)) {
                    pointer++;
                    count++;
                    break;
                }
                pointer++;
            }
        }
        System.out.println(count);
        System.out.println(input2.length());
        if (count == input2.length()) {
            System.out.println("Matching");
        } else {
            System.out.println("Not Matching");
        }

    }
}