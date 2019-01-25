package Challenge;

import java.util.List;

public class Dijkstra {

    public  int [][] matriz;
    public List<String> paises;
    public int vertices;


    public Dijkstra(int[][] matriz, List<String> paises, int vertices) {
        this.matriz = matriz;
        this.paises = paises;
        this.vertices = vertices;
    }


    public void agregarArista(int origen, int destino, int peso) {
        this.matriz[origen][destino]=peso;
    }







    //----Getters & Setters----------------------------
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public List<String> getPaises() {
        return paises;
    }

    public void setPaises(List<String> paises) {
        this.paises = paises;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }
}
