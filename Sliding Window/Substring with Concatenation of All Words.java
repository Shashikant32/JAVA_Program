import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
        int n= words.length;
        HashMap<String,Integer> wordMp = new HashMap<>();
        for(int i=0; i<words.length; i++)
            {
            wordMp.put(words[i],wordMp.getOrDefault(words[i],0)+1);    
            }
        int wordlen= words[0].length();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length()-n*wordlen; i++)
            {
                //making first word and checking into wordlen
                // String tmpword= s.substring(i,i+wordlen);
                // if(wordmp.containsKey(tmpword))
                // {
                //     // check next word,-> next word
                    
                // }
                //we wish to find n word
                HashMap<String,Integer> seenMp = new HashMap<>();
                
                for(int j=0; j<n; j++)
                    {
                        String tmpword= s.substring(i+j*wordlen,i+(j+1)*wordlen);
                        seenMp.put(tmpword,seenMp.getOrDefault(tmpword,0)+1);    
                        
                        if(!wordMp.containsKey(tmpword)) break;
                    }
                // if all the freq of word map equale all the freq of seen map then
                // we can say found a concat
                boolean flag = true;
                for(String wrd : wordMp.keySet())
                    {
                        if(!seenMp.containsKey(wrd) || wordMp.get(wrd) != seenMp.get(wrd))
                        {
                            flag = false;
                            break;
                        }
                    }
                if(flag) ans.add(i);
            }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
 