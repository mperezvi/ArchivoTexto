/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarchivosdetexto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARCELINO
 */
public class ArchivoProducto {
    private String nombreArchivo;

    public ArchivoProducto(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
   
    
    public  void insertaProducto(Producto prod) throws IOException 
    {
        FileWriter fw = new FileWriter(nombreArchivo,true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(prod.toString());
        pw.close();
    }
    
    public  Producto buscar(String codigo) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(nombreArchivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        Producto prod=null;
        
        while((linea=br.readLine())!=null)
        {
            String datos[]=linea.split(",");
            if(codigo.equals(datos[0]))
                prod=new Producto(datos[0],datos[1],Double.parseDouble(datos[2]),Integer.parseInt(datos[3]));
        }
        return prod;
    }
    
    public Object  [][] devuelveDatos() throws FileNotFoundException, IOException
    {
        
        FileReader fr = new FileReader(nombreArchivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        int cont=0;
        
        while((linea=br.readLine())!=null)
        {
            cont++;
        }
        br.close();
        
        fr = new FileReader(nombreArchivo);
        br = new BufferedReader(fr);
        Producto prod;
        int i=0;
        Object matriz[][]=new Object[cont][4];
        while((linea=br.readLine())!=null)
        {
            String datos[]=linea.split(",");
            matriz[i][0]=datos[0];
            matriz[i][1]=datos[1];
            matriz[i][2]=datos[2];
            matriz[i][3]=datos[3];
            i++;
        }
        
        br.close();
        return matriz;
        
    }
    
    
    
}
