package Challenge;

import java.io.*;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import static Challenge.Dijkstra.dijkstra;


public class Test {

    private static List<String> paises;

    private static int MatAdj[][];

    public static void init(int mat[][]){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = 0;
            }
        }
    }

    public static void readFile() throws IOException {
        List<String> countries = new ArrayList<>();
        int  AdjMat [][] = new int[0][];
        //System.out.println("Hello, World!");
        countries = new ArrayList<>();

        File file = new File("src\\Challenge\\in.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        Boolean already = false;
        int vertices = 0;
        while ((st = br.readLine()) != null){
            //System.out.println(st);
            if(st.contains(",")){
                if(!already) {
                    AdjMat = new int[countries.size()][countries.size()];
                    init(AdjMat);
                    already = true;
                }

                StringTokenizer myTok = new StringTokenizer(st,",");

                String cou = myTok.nextToken();
                int index = countries.indexOf(cou);
                String cou2 = myTok.nextToken();
                int index2 = countries.indexOf(cou2);
                int weight = Integer.parseInt(myTok.nextToken());
                //System.out.println("Index : " + index + " " + index2);
                AdjMat[index][index2] = weight;

            }
            else{
                countries.add(st);
            }

        }

        /*for (int i = 0; i < countries.size(); i++) {
            System.out.println(countries.get(i));
        }

        for (int i = 0; i < AdjMat.length; i++) {
            for (int j = 0; j < AdjMat.length; j++) {
                System.out.print(AdjMat[i][j] + " ");
            }
            System.out.println();
        }*/
        paises = countries;
        MatAdj = AdjMat;
        int sourceVertex = 0;
        //System.out.println("Vertices" + countries.size());
        //dijkstra(AdjMat,sourceVertex,sourceVertex);
    }

    public static void main(String[] args) throws IOException {
        // Menu para utilizar el programa
        CompressTest.decompress();
        while (true){
            System.out.println("\n1. Todos los caminos desde de un pais\n2. Menor camino posble entre dos paises\n3. Cargar Archivo");
            Scanner keyboard = new Scanner(System.in);
            int option = keyboard.nextInt();
            if(option == 1){
                System.out.println("Digite el nombre del punto de partida");
                Scanner keyboard2 = new Scanner(System.in);
                String pais = keyboard2.next();

                //System.out.println(paises.toString());
                if (paises.contains(pais)){
                    dijkstra(MatAdj,paises.indexOf(pais),paises.indexOf(pais), paises);
                    /*for (String st: paises){
                        if (!st.equals(pais)){
                            System.out.println("\n"+pais + "->" + paises.indexOf(pais)+"\n"+st+"->"+paises.indexOf(st));
                            dijkstra(MatAdj,paises.indexOf(pais),paises.indexOf(st), paises);
                        }

                    }*/

                }else{
                    System.out.println("Pais no existe");
                }
            }else{
                if(option == 2){
                    System.out.println("Digite el punto de partida");
                    Scanner keyboard2 = new Scanner(System.in);
                    String pais1 = keyboard2.next();
                    System.out.println("Digite el destino");
                    String pais2 = keyboard2.next();
                    if (paises.contains(pais1)){
                        //Llamar a Dikstra entre los dos paises
                        dijkstra(MatAdj,paises.indexOf(pais1),paises.indexOf(pais2), paises);

                    }else{

                    }


                }else {
                    if (option == 3){
                        //Cargar archivo
                        readFile();
                        CompressTest.matrizToFile(MatAdj,paises);
                        CompressTest.compress();
                    }else{
                        System.out.println("Opcion invalida");
                    }

                }
            }

        }


    }
}
