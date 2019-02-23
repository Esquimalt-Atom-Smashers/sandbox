

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class OpenCVTest 
{
	public static void main (String[] args )
	{
		 { System.loadLibrary( Core.NATIVE_LIBRARY_NAME ); }
		System.out.println("Hello I got OpenCV compiled!");
		
		Mat image = Highgui.imread( "/home/donm/myimage.png", Highgui.CV_LOAD_IMAGE_GRAYSCALE );
		Highgui.imwrite("/home/donm/savedimage.png",  image );
		
		
	}

}