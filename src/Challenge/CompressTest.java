package Challenge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressTest {


    public static void main(String[] args) throws IOException {


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
