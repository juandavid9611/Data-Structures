package Challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressTest {


    public static void matrizToFile(int m[][], List<String> p) throws IOException {
        // attach a file to FileWriter
        FileWriter fw=new FileWriter("src/Challenge/pruebaMatriz.txt");
        // into FileWriter

        fw.write(m.length + "");
        fw.write(System.getProperty("line.separator"));
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                fw.write(Integer.toString(m[i][j])+" ");
            }
            fw.write(System.getProperty("line.separator"));
        }
        for (int j = 0; j < p.size(); j++) {
            fw.write(p.get(j));
            fw.write(System.getProperty("line.separator"));
        }

        System.out.println("Writing successful");
        //close the file
        fw.close();
    }

    public static void compress() throws IOException {
        //-------------------------COMPRIMIR-------------------------------

        //Assign the original file : file to
        //FileInputStream for reading data
        FileInputStream fis=new FileInputStream("src/Challenge/prueba.txt");

        //Assign compressed file:file2 to FileOutputStream
        FileOutputStream fos=new FileOutputStream("src/Challenge/file2.txt");

        //Assign FileOutputStream to DeflaterOutputStream
        DeflaterOutputStream dos=new DeflaterOutputStream(fos);

        //read data from FileInputStream and write it into DeflaterOutputStream
        int data;
        while ((data=fis.read())!=-1)
        {
            dos.write(data);
        }

        //close the file
        fis.close();
        dos.close();
    }

    public static void decompress() throws IOException{
        //-------------------------DESCOMPRIMIR-------------------------------

        //assign Input File : file2 to FileInputStream for reading data
        FileInputStream fis2=new FileInputStream("src/Challenge/file2.txt");

        //assign output file: file3 to FileOutputStream for reading the data
        FileOutputStream fos2=new FileOutputStream("src/Challenge/file3.txt");

        //assign inflaterInputStream to FileInputStream for uncompressing the data
        InflaterInputStream iis2=new InflaterInputStream(fis2);

        //read data from inflaterInputStream and write it into FileOutputStream
        int data2;
        while((data2=iis2.read())!=-1)
        {
            fos2.write(data2);
        }

        //close the files
        fos2.close();
        iis2.close();

        //TODO: File to matrix
    }

    public static void fileToMatriz() throws IOException {
        Scanner input = new Scanner (new File("src/Challenge/pruebaMatriz.txt"));

        Scanner rowReader = new Scanner(input.nextLine());
        int rows = rowReader.nextInt();
        int[][] a = new int[rows][rows];
        List<String> paises = new ArrayList<String>();

        for(int i = 0; i < rows; ++i)
        {
            for(int j = 0; j < rows; ++j)
            {
                if(input.hasNextInt())
                {
                    a[i][j] = input.nextInt();
                }
            }
        }

        while(input.hasNextLine()){
            paises.add(input.nextLine());
        }

        for(int k = 0; k < a.length; k++){
            for (int z = 0; z < a.length; z++){
                System.out.println(a[k][z]);
            }
            System.out.println("----------------");
        }

        for (String e: paises){
            System.out.println(e);
        }
    }


    public static void main(String[] args) throws IOException {

        int [][] matriz = new int[6][6];
        List<String > paises = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = j;
            }
        }
        paises.add("Colombia");
        paises.add("USA");
        paises.add("Argentina");
        paises.add("Inglaterra");
        paises.add("Canada");
        //matrizToFile(matriz, paises);
        fileToMatriz();




    }

}
