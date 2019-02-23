

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class DataLogger
{
    private String filename;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public DataLogger( String fileToWrite ) throws IOException
    {
        filename = fileToWrite;
        FileWriter clearWriter = new FileWriter( fileToWrite, false );
        // clear the file by writing a non-appended line
        PrintWriter clearPrinter = new PrintWriter( clearWriter );

        clearPrinter.print( "\n" );
        clearPrinter.close();
        

        // now open the persistent classes
/*        fileWriter = new FileWriter( fileToWrite, true );
        printWriter = new PrintWriter( fileWriter );
        log( "I want to log this" );

        filename = new String ( fileToWrite );*/
        
    	fileWriter = new FileWriter( filename, true );
        printWriter = new PrintWriter( fileWriter );

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
        fileWriter = new FileWriter( filename, true );
        printWriter = new PrintWriter( fileWriter );
        printWriter.printf( "%d: %s\n", timeMillis, textLine );
        System.out.println( timeMillis + " " + textLine );
        

        
 

    }
}
