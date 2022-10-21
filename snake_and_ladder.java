import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        // Write your code here
        int count = 0;
        Queue<Integer> que = new LinkedList();
        ArrayList<Integer> array = new ArrayList<Integer>();
        HashMap<Integer,Integer> snake = new HashMap();
        HashMap<Integer,Integer> ladder = new HashMap();
        for(List<Integer> m : ladders)
            snake.put(m.get(0),m.get(1));
        for(List<Integer> n : snakes)
            ladder.put(n.get(0),n.get(1));


        que.add(1);
        while(que.size()!=0){
            int size = que.size();
            while(size>0){
                System.out.println("This is size1 "+size);
                System.out.println("This is turns "+count);
                size-=1;

                int tmp = que.poll();
                if(tmp==100){
                    return count;}
                if(array.contains(tmp)){
                    continue;}
                array.add(tmp);
/                for(int i=tmp+1;i<=Math.min(tmp+6,100);i++){
                    if(snake.containsKey(i)){
                        que.add(snake.get(i));
                    }else if(ladder.containsKey(i)){
                        que.add(ladder.get(i));
                    }else{
                        que.add(i);
                    }
                }
                //System.out.println("This is size2 "+size);
            }
            count++;
        }
        return -1;
    }

}



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

