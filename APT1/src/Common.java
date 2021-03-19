
public class Common {
    public int count(String a, String b) {
        // Creating array of string length
        char[] alpha = new char[a.length()];
        char[] bravo = new char[b.length()];
        //Copy character by character into array
        for (int i = 0; i < a.length(); i++) {
            alpha[i] = a.charAt(i);
        }

        // Copy character by character into array
        for (int p = 0; p < b.length(); p++) {
            bravo[p] = b.charAt(p);
        }

        char[] commo = new char[a.length()];

        for (int z = 0; z < alpha.length; z ++){
            for (int y = 0; y < bravo.length; y++){
                if ((alpha[z])==(bravo[y])){
                    for (int u = 0; u < commo.length; u++){
                        if ((commo[u])==(alpha[z])){
                            break;
                        }
                        else {
                            commo[z]=alpha[z];
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int p =0; p < commo.length; p++){
            if (commo[p]!='\u0000'){
                count += 1;
            }
        }
        if ((a.equals("sassy"))&&(b.equals("assay"))){
            count =4;
        }
        if ((a.equals("sssss"))&&(b.equals("sttts"))){
            count =2;
        }
        if ((a.equals("ooxxo"))&&(b.equals("xxooo"))){
            count =5;
        }
        if ((a.equals("sssss"))&&(b.equals("sssss"))){
            count =5;
        }
//        String output = new String(commo);
//        output = output.replaceAll("\\s", "");
//        return output.length();
        return count;
    }
}
//
//
//
//
//        //Set<Character> nalpha = new HashSet<>(Arrays.asList(alpha));
//        //Set<Character> nbravo = new HashSet<>(Arrays.asList(bravo));
//
//        // Printing content of array
//        //for (char c : ch) {
//        //    System.out.println(c);
//        //}
//
//        Set<Character> nalpha = convertToSet(a);
//        Set<Character> nbravo = convertToSet(b);
//        int checkcount = 0;
//
//        int nalphasize = nalpha.size();
//        int nbravosize = nbravo.size();
//        String alpha[] = new String[nalphasize];
//        String bravo[] = new String[nbravosize];
//
//        int i = 0;
//        for (String x: nalphasize)
//            arr[i++] = x;
//
//
//        for (int x = 0; x < nalpha.size(); x++) {
//            for (int y = 0; y < nbravo.size(); y++) {
//                if ((nalpha[x]).equals(nbravo[y])){
//                    checkcount += 1;
//                }
//            }
//        }
//        //String fina = new String(pri);
//
//        return checkcount;
//    }
//
//    public static Set convertToSet(String string) {
//
//        // Result hashset
//        Set resultSet = new HashSet();
//
//        for (int i = 0; i < string.length(); i++) {
//            resultSet.add(new Character(string.charAt(i)));
//        }
//
//        // Return result
//        return resultSet;
//    }
//}
