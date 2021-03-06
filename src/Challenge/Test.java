package Challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Test {

    public static void init(Integer mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> countries = new ArrayList<>();
        Integer  AdjMat [][] = new Integer[1][1];
        System.out.println("Hello, World!");
        countries = new ArrayList<>();

        File file = new File("src\\Challenge\\in.txt");

       BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        Boolean already = false;
        while ((st = br.readLine()) != null){
            System.out.println(st);
            if(st.contains(",")){
                if(!already) {
                    AdjMat = new Integer[countries.size()][countries.size()];
                    init(AdjMat);
                    already = true;
                }

                StringTokenizer myTok = new StringTokenizer(st,",");

                String cou = myTok.nextToken();
                int index = countries.indexOf(cou);
                String cou2 = myTok.nextToken();
                int index2 = countries.indexOf(cou2);

                System.out.println(index + " " + index2);
                AdjMat[index][index2] = Integer.parseInt(myTok.nextToken());

            }
            else{
                    countries.add(st);
            }

        }

        for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

        for (int i = 0; i < AdjMat.length; i++) {
            for (int j = 0; j < AdjMat.length; j++) {
                System.out.print(AdjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
