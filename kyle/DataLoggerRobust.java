import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DataLoggerRobust
{
    private String filename;
    private long zeroTimeMillis = 0;

    public DataLoggerRobust( String fileToWrite, long newZeroTimeMillis ) throws IOException
    {
      
      zeroTimeMillis = newZeroTimeMillis;
      filename = fileToWrite;


    }
    
    public void setZeroTime( long newZeroTimeMillis )
    {
      zeroTimeMillis = newZeroTimeMillis;
    }



    public void log( String textLine ) throws IOException
    {
        

        // now open the persistent classes
        FileWriter fileWriter = new FileWriter( filename, true );
        PrintWriter printWriter = new PrintWriter( fileWriter );

        
        long timeMillis = System.currentTimeMillis();
        printWriter.printf( "%09d: %s", timeMillis- zeroTimeMillis, textLine );
        printWriter.println( "" );
        
        //printWriter.println( (timeMillis-zeroTimeMillis) + ": " + textLine );
        
        System.out.println( timeMillis + " " + textLine );
        
        fileWriter.close();
        printWriter.close();
        

        
 

    }
}
