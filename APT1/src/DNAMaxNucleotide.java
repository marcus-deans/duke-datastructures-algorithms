public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        int newcount;
        int maxcount = 0;
        char nuck = nuc.charAt(0);
        String fina = new String ("");
        //String fina = "";
        for (int x = 0; x < strands.length ; x++){
            newcount = 0;
            String curword = new String (strands[x]);
            for (int y=0; y < curword.length() ; y++){
                //String curcar = new String (curword.);
                char curcar = curword.charAt(y);
                //if (curcar.equals(nuck)){
                if (curcar == nuck){
                    newcount ++;
                }
            }
            if ((newcount == maxcount)&&(curword.length() > fina.length())){
                fina = strands[x];
            }
            if (newcount > maxcount){
                maxcount = newcount;
                fina = strands[x];
            }

        }
        if (maxcount == 0){
            fina = "";
        }
        return fina;
    }
}
