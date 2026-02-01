import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class Algos {

//    [ 1, 2, 3, 4, 5, 6 ]
//    [ 3, 4, 5, 6, 1, 2 ]

//    i take moves and say loop over the array size - numbers to end
    // actually first i % number of moves to the size to avoid full iterations


    static class Methods{

        public int[] rotater(int[]arr,int size, int moves){

            int shifter = moves%size;

            ArrayList<Integer> part2 = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
            part2.subList(shifter,size).clear();
            ArrayList<Integer> part1 = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
            part1.subList(0,shifter).clear();

            ArrayList<Integer> result = part1;
            result.addAll(part2);

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }



    public static void main(String[] args) {
        Methods m = new Methods();

        int[] arr = {1, 2, 3, 4, 5, 6};
        int moves = 2;
        // two left shifts

        int[] rotated = m.rotater(arr, arr.length, moves);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(rotated));

        //this will be true
        String exp1 = "{[()]}";
        //false
        String exp2 = "{[(])}";

        SingleArrayStack s1 = new SingleArrayStack(exp1.length());
        SingleArrayStack s2 = new SingleArrayStack(exp2.length());

        System.out.println(s1.paired(exp1));
        System.out.println(s2.paired(exp2));

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        //original
        System.out.println(stack);
        StackReverser.reverse(stack);
        //reversed
        System.out.println(stack);

    }
}
