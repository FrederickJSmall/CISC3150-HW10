import java.io.File;
import java.io.IOException;

/*
 * Frederick Small 
 * CISC 3150
 *  
 */

public class Main {
    public static void main(String[] args)
    {
    	
		System.out.println("Running ProcessBuilder\n\n");
		String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" +currentDir);
        
		String program = "";
		String file = "";
		boolean blockingCall = false;
		
		if (args.length >= 1 && args.length <=3)
		{
			System.out.print("Running in ");
			if (args[0].endsWith("&"))
			{
				System.out.println("Blocking mode");
				program=args[0].substring(0, args[0].length()-1);
				blockingCall = true;
			}
			else
			{
				System.out.println("Non-Blocking mode");
				program=args[0];
			}
			if (!args[1].equals(">"))
			{
				System.out.println("Invalid operation supplied");
				System.exit(-1);
			}
			file = args[2];
		}
		else
		{
			System.out.println("Invalid number of options supplied");
			System.exit(-1);
		}	
		
    	try {
            System.out.println("Running ProcessBuilder:");
			ProcessBuilder processBuilder = new ProcessBuilder(program);
			
			
			try {
				System.out.println("Writing output to following file:" + currentDir + "\\" + file);
				File output = new File(currentDir + "\\" + file);
				processBuilder.redirectOutput(output);

				Process process = processBuilder.start();
				if (blockingCall)
				{
					System.out.println("Waiting for main thread to terminate");
					process.waitFor();
				}
			} catch (IOException | InterruptedException e) {
				System.out.println(e.getMessage());
			}
			
    	}
    	finally
    	{
    		System.out.println("Process completed successfully");
    	}
    }
}
