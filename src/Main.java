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
		boolean returnImmediate = false;
		
		if (args.length == 1)
		{
			if (!args[0].endsWith("&"))
			{
				program=args[0]; 
			}
			else
			{
				program=args[0].substring(0, args[0].length()-1);
				returnImmediate = true;
			}
		}
		
    	try {
			ProcessBuilder processBuilder = new ProcessBuilder("notepad");
			
			
			try {
				Process process = processBuilder.start();
				if (program.endsWith("&"))
					process.waitFor();
				
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			
    	}
    	finally
    	{
    		System.out.println("Process terminated");
    	}
    }
}
