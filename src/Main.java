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
		
		String program = "";
		boolean blockingCall = false;
		
		if (args.length >= 1)
		{
			if (args[0].endsWith("&"))
			{
				program=args[0].substring(0, args[0].length()-1);
				blockingCall = true;
			}
			else
			{
				program=args[0];				
			}
		}
				
    	try {
			ProcessBuilder processBuilder = new ProcessBuilder(program);
			
			
			try {
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
    		System.out.println("Process terminated");
    	}
    }
}
