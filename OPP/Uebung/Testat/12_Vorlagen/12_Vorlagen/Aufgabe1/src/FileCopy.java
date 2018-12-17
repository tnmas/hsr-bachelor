import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
	public static void main(String[] args) throws IOException{
		
       BufferedInputStream input = null;
       BufferedOutputStream output = null; 
       
        try {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		// Accepts the path to the source file.
		System.out.println("Enter the path source file: ");
		String inputFilePath = scan.nextLine();

		// Accepts the path to the destination file.
		System.out.println("Enter the path destination path file: ");
		String outputFilePath = scan.nextLine();

            	input = new BufferedInputStream(new FileInputStream(inputFilePath));
            	output = new BufferedOutputStream(new FileOutputStream(outputFilePath));

            	int byteRead;
            	while ((byteRead = input.read()) != -1) { 
                	output.write(byteRead);
            	}

            	System.out.println("Done! File is copied successfully.");

        }finally { 
                	if (input != null)
                    		input.close();
                	if (output != null)
                    		output.close();
          	}     	  
	}
}
