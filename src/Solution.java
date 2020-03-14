import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {


        System.out.println(solution(0, 3));

    }


    public static int solution(int start, int length) {
        int check_sum;
        //check_sum = workers_ID(start, length);
        check_sum = XOR_checksum(start, length);
        return check_sum;

    }

    /*An inefficient way to solve the question,
     * first attempt
     */
    public static int workers_ID(int start, int length) {
        int worker_list = 0;
        boolean check = true;
        for (int rows = 0; rows < length; rows++) {
            for (int columns = 0; (columns < length + 1); columns++) {

                if (columns + rows == length) {
                    check = false;
                } else if (check) {

                    worker_list = worker_list ^ start;

                    start++;
                } else {
                    start++;
                }
            }
            check = true;
        }
        return worker_list;
    }

    public static int XOR_checksum(int start, int length) {
        int check_sum = 0;
        int from = -1;
        int to = -1;

        for (int curr_row = 0; curr_row < length; curr_row++) {
            from = (start + (curr_row * length));
            to = from + (length - 1 - curr_row);
            if (from != to) {
                System.out.println("From: " + from + " To: " + to);
                check_sum = check_sum ^ (XOR_from_to((from - 1), to));
            } else {
                System.out.println("Endln: " + from);
                check_sum = check_sum ^ (from);
            }
        }
        return check_sum;
    }

    // find the XOR value of a number from a given number to a given number
    public static int XOR_from_to(int from, int to) {
        int val = XOR_1_to_n(from) ^ XOR_1_to_n(to);
        System.out.println(val);

        return (val);

    }

    // finding the XOR of 1 to a number efficiently
    public static int XOR_1_to_n(int num) {
        /*
        The XOR of an even number followed by an odd(must be consecutive even and odd) will always yield 1
        Using this, since we start at 1, the next digit is 2 followed by 3, which yields to just 1,
        hence we can get all one's until we reach the number we are looking for
        eg: XOR_1_to_n(5);  5 % 4 = 1, hence we must get 1 as XOR between 1 and 5
        1 ^ ((2 ^ 3) --> 1) ^ ((4 ^ 5) --> 1)
        1 ^ 1 ^ 1 = 0 ^ 1 = 1
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

        System.out.println("1 to " + num + " : " + XOR_val);
        return XOR_val;

    }

}