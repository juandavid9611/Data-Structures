package Challenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressTest {


    public static void matrizToFile(int m[][], List<String> p) throws IOException {


        // attach a file to FileWriter
        FileWriter fw=new FileWriter("src/Challenge/pruebaMatriz.txt");


        // into FileWriter

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                fw.write(Integer.toString(m[i][j]));
            }
            fw.write(System.getProperty("line.separator"));
        }

        System.out.println("Writing successful");
        //close the file
        fw.close();


    }


    public static void main(String[] args) throws IOException {

        int [][] matriz = new int[6][6];
        List<String > paises = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = 0;
            }
        }
        paises.add("Colombia");
        paises.add("USA");
        paises.add("Argentina");
        paises.add("Inglaterra");
        paises.add("Canada");


        matrizToFile(matriz, paises);


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
    }

}
