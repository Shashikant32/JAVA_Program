import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> scoreCard = new HashMap<>();

        scoreCard.put("Rohit",50);
        scoreCard.put("Kohli",40);
        scoreCard.put("Sky",65);
        System.out.println(scoreCard.size());
        scoreCard.put("Rohit",45);
        System.out.println(scoreCard.get("Rohit"));

        System.out.println(scoreCard.get("Bumrah"));

        //while dealing with hashmaps make sure key that is present other wise key is NULL;
        // if(scoreCard.containsKey("Bumrah"))
        // {
        //     System.out.println("Key is present");
        // }else
        // {
        //     System.out.println("Key is Not present");
        // }

        for(String name:scoreCard.keySet())
            {
                System.out.println(name+ "->"+scoreCard.get(name));
            }
            
    }

}
