import java.util.Stack;

class MultiplyLargeNumber {
    public static void main(String[] args) {
        String result = multiplyLargeNumber("500", "500");
        System.out.println(result);
    }

      //TODO: Improve further by implementation of subtractLargeNumber to avoid limitation of Long data size
      /**
       * 
       * @param a - first number as a string
       * @param b - second number as a string
       * @return result of multiplication by both number
       */
      public static String multiplyLargeNumber(String a, String b) {
        if (a.length() == 1 || b.length() == 1) {
            return (Integer.parseInt(a) * Integer.parseInt(b)) + "";
        }

        a = addPrefixZeroToTheNextTwoPowerByN(a);
        b = addPrefixZeroToTheNextTwoPowerByN(b);
        a = addPrefixZero(a, Math.max(a.length(), b.length()) - a.length());
        b = addPrefixZero(b, Math.max(a.length(), b.length()) - b.length());

        String a1, a0, b1, b0;
        a1 = a.substring(0, a.length() / 2);
        a0 = a.substring(a.length() / 2);
        b1 = b.substring(0, b.length() / 2);
        b0 = b.substring(b.length() / 2);

        String c0, c1, c2, c;
        c2 = multiplyLargeNumber(a1, b1);
        c0 = multiplyLargeNumber(a0, b0);
        c1 = (Long.parseLong(multiplyLargeNumber(addLargeNumber(a1, a0), addLargeNumber(b1, b0))) - Long.parseLong(addLargeNumber(c2, c0))) + "";

        c = addLargeNumber(addLargeNumber(addSuffixZero(c2, a.length()), addSuffixZero(c1, a.length() / 2)), c0);
        int index=0;
        for (int i = 0; i < c.length(); i++,index++) {
            if( c.charAt(i)!='0' ){
                break;
            }
        }
        String output = c.substring(index, c.length());
        return output;
    }

    public static String addPrefixZeroToTheNextTwoPowerByN(String n) {
        String str = n.concat("");
        int twoPowerByN = (int) Math.pow(2, Math.floor(Math.log10(n.length()) / Math.log10(2)));
        if (n.length() == twoPowerByN) {
            return n;
        }

        for (int i = n.length(); i < twoPowerByN * 2; i++) {
            str = "0" + str;
        }

        return str;
    }

    public static String addPrefixZero(String n, int numberOfZero) {
        String str = n.concat("");
        for (int i = 0; i < numberOfZero; i++) {
            str = "0" + str;
        }

        return str;
    }

    public static String addSuffixZero(String n, int numberOfZero) {
        String str = n.concat("");
        for (int i = 0; i < numberOfZero; i++) {
            str += "0";
        }

        return str;
    }

    public static String addLargeNumber(String a, String b) {
        Stack<Character> n1 = new Stack<>();
        Stack<Character> n2 = new Stack<>();
        Stack<Character> result = new Stack<>();

        for (int i = 0; i < a.length(); i++) {
            n1.push(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            n2.push(b.charAt(i));
        }

        int carry = 0;
        while (!n1.isEmpty() && !n2.isEmpty()) {
            int num1 = Integer.parseInt(n1.pop().toString());
            int num2 = Integer.parseInt(n2.pop().toString());

            int r = num1 + num2 + carry;
            if (r >= 10) {
                r %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(Character.forDigit(r, 10));
        }

        while (!n1.isEmpty()) {
            int num = Integer.parseInt(n1.pop().toString());
            int r = num + carry;
            if (r >= 10) {
                r %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(Character.forDigit(r, 10));
        }

        while (!n2.isEmpty()) {
            int num = Integer.parseInt(n2.pop().toString());
            int r = num + carry;
            if (r >= 10) {
                r %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(Character.forDigit(r, 10));
        }

        String res = "";
        if (carry != 0) {
            res = "1";
        }
        while (!result.isEmpty()) {
            res += result.pop();
        }

        return res;
    }
}