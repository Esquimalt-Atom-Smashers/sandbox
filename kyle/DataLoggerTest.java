import java.io.IOException;

public class DataLoggerTest
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World" );
        System.out.println( "Why doesn't this work?");

        long zeroTimeMillis = System.currentTimeMillis();
       

        DataLoggerRobust logger = null;
        try
        {
            //DataLogger logger = new DataLogger( "/home/donm/data.txt" );
             logger = new DataLoggerRobust( "H:\\Documents\\drjava\\data.txt", zeroTimeMillis );
        }
        catch (IOException e )
        {}
        
        try
        {
            logger.log( "Does this work?");
            logger.log( "Log this!" );
        }
        catch (IOException e )
        { System.out.println();
        }
          
        try
            {
            Thread.sleep(5000);
            }
        catch (InterruptedException e )
        {
            System.out.println( "Sorry, logger failed" + e.getMessage());
        }
        try {
            logger.log( "Waking up now" );
        }
        catch ( IOException e )
        {
        }
        //logger.close();
        
   

        

    }
}
