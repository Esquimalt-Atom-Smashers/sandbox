import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DataLogger
{
    private String filename;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private long zeroTimeMillis = 0;

    public DataLogger( String fileToWrite, long newZeroTimeMillis ) throws IOException
    {
      
      zeroTimeMillis = newZeroTimeMillis;
      filename = fileToWrite;
        FileWriter clearWriter = new FileWriter( fileToWrite, false );
        // clear the file by writing a non-appended line
        PrintWriter clearPrinter = new PrintWriter( clearWriter );

        clearPrinter.print( "\n" );
        clearPrinter.close();
        

        // now open the persistent classes
        fileWriter = new FileWriter( filename, true );
        printWriter = new PrintWriter( fileWriter );

    }
    
    public void setZeroTime( long newZeroTimeMillis )
    {
      zeroTimeMillis = newZeroTimeMillis;
    }

    public void close()
    {
     try 
     {

     fileWriter.close();
        printWriter.close();
     }
     catch (IOException e)
     {
     }
    }

    public void log( String textLine ) throws IOException
    {
     

        
        long timeMillis = System.currentTimeMillis();
        printWriter.printf( "%09d: %s", timeMillis- zeroTimeMillis, textLine );
        printWriter.println( "" );
        
        printWriter.println( (timeMillis-zeroTimeMillis) + ": " + textLine );
        
        System.out.println( timeMillis + " " + textLine );
        

        
 

    }
}
