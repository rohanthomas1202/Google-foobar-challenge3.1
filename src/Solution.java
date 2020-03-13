import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {


        System.out.println(solution(0, 30000));

    }


    public static int solution(int start, int length) {
        int check_sum;
        check_sum = workers_ID(start, length);
        return check_sum;

    }

    /*A brute force way to solve the question,
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
}