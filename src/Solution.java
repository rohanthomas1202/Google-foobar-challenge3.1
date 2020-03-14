public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(17,  2000000000));
    }



    // Solution which computes the checksum in O(N) time
    // Efficient way to find XOR of consecutive numbers
    public static int solution(int start, int length) {
        int check_sum = 0;              // keeps  track of the check_sum
        int from;                       // first number in the row
        int to;                         // last valid number to compute XOR of in the row
        // for each row, find the first and last valid worker ID to compute the check_sum
        for (int curr_row = 0; curr_row < length; curr_row++) {
            // starts at the first element in each row
            from = (start + (curr_row * length));
            // ends at one less than the previous row
            to = from + (length - 1 - curr_row);
            // if the first and last elements are the same, computing last row
            if (from != to) {
                check_sum = check_sum ^ (XOR_from_to((from - 1), to));
            } else {
                // XOR the last value to the current check_sum
                check_sum = check_sum ^ (from);
            }
        }
        return check_sum;
    }

    // find the XOR value of a consecutive numbers
    public static int XOR_from_to(int from, int to) {
        // Finding XOR of every element from a to b
        // (a ^ ... ^ b) = (1 ^ ... ^ b) ^ (1 ^ ... ^ a)
        return (XOR_1_to_n(from) ^ XOR_1_to_n(to));
    }

    // finding the XOR of 1 to a number efficiently
    public static int XOR_1_to_n(int num) {
        /*
        The XOR of an even number followed by a consecutive odd will always yield 1
        Using this, we can formulate a simple algorithm to compute the XOR of 1 to n in O(1)
        */

        int XOR_val = 0;

        switch (num % 4) {
            case 0:
                XOR_val = num;
                break;
            case 1:
                XOR_val = 1;
                break;
            case 2:
                XOR_val = num + 1;
                break;
            case 3:
                XOR_val = 0;
                break;
        }
        return XOR_val;
    }

}