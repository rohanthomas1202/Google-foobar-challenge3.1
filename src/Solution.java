import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {


        solution(0, 3);

    }


    public static int solution(int start, int length) {
            int check_sum;
            ArrayList<Integer> test;
            test = workers_ID(start, length);
            check_sum = find_XOR(test);
            System.out.println(check_sum);
            return check_sum;

    }


    public static ArrayList<Integer> workers_ID(int start, int length) {
        ArrayList<Integer> worker_list = new ArrayList<>();
        boolean check = true;
        for (int rows = 0; rows < length; rows++) {
            for (int columns = 0; (columns < length + 1); columns++) {

                if (columns + rows == length) {
                    check = false;
                } else if (check) {
                    // if the number being added is  an odd number, check if the number is the first number,
                    // if not check if the number just before it was the previous even, if so, we can simplify the calculation to 1
                    if (((start % 2) != 0) && ((worker_list.size() != 0) && ((worker_list.get(worker_list.size() - 1) == (start - 1))))) {
                        worker_list.remove(worker_list.size() - 1);
                        worker_list.add(1);
                    } else {
                        worker_list.add(start);
                    }
                    start++;
                } else {
                    start++;
                }
            }
            check = true;
        }
        return worker_list;
    }


    public static int find_XOR(ArrayList<Integer> ID) {
        int XOR_val = 0;
        for (int i = 0; i < ID.size(); i++) {
            XOR_val = XOR_val ^ ID.get(i);
        }
        return XOR_val;
    }
}