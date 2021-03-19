public class CounterAttack {
    public int[] analyze(String str, String[] words) {
        String[] dic = str.split(" ");
        int[] fina = new int[words.length];
        for (int x=0; x<words.length; x++){
            for (int y = 0; y< dic.length; y++){
                if ((words[x]).equals(dic[y])){
                    fina[x] += 1;
                }
            }
        }
        return fina;
    }
}
