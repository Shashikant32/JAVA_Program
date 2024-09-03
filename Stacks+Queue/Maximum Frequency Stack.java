import java.util.*;

class FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> freqStackMap;
    private int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        freqStackMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);

        if (freq > maxFreq) {
            maxFreq = freq;
        }

        freqStackMap.computeIfAbsent(freq, k -> new Stack<>()).push(x);
    }

    public int pop() {
        Stack<Integer> stack = freqStackMap.get(maxFreq);

        int element = stack.pop();

        int freq = freqMap.get(element) - 1;
        freqMap.put(element, freq);

        if (stack.isEmpty()) {
            freqStackMap.remove(maxFreq);
            maxFreq--;
        }

        return element;
    }
}

public class Main {
    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.equals("push")) {
                int val = sc.nextInt();
                fs.push(val);
            } else if (str.equals("pop")) {
                System.out.println(fs.pop());
            }
        }
        sc.close();
    }
}
