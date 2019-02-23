
import java.io.IOException;

public class DataLoggerTest
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World" );
        System.out.println( "Why doesn't this work?");

       

        try
        {
            DataLogger logger = new DataLogger( "/home/donm/data.txt" );
            logger.log( "Does this work?");
            logger.log( "Log this!" );
            logger.close();
        }
        catch (IOException e )
        {
            System.out.println( "Sorry, logger failed" + e.getMessage());
        }
        

    }
}