/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreFichero = "fichero.dat";
    private static FileInputStream entradaCorriente = null;
    private static BufferedInputStream entradaIntermedio = null;

    public static void iniciarArchivos() throws FileNotFoundException
    {
        entradaCorriente = new FileInputStream(nombreFichero);
        entradaIntermedio = new BufferedInputStream(entradaCorriente);
    }
    
    public static int mostrarArchivoTexto() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = entradaCorriente.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            iniciarArchivos();
            
            int total = mostrarArchivoTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaIntermedio != null && entradaCorriente != null )
                {
                    entradaCorriente.close();
                    entradaIntermedio.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
