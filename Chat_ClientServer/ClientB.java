/*
	Program to implement a client
*/

import java.util.*;
import java.io.*;	//to use the IO classes
import java.net.*;	//to use the socket functionalities

public class ClientB	{
	public static void main(String args[]) throws UnknownHostException, 
													IOException{
//		final int PORT_NUMBER = 4005;
		
		Scanner keyboard = new Scanner(System.in);
		Scanner in = null;
		PrintWriter out = null;
		
		boolean flag = false;
		String message = null;

		Socket s = new Socket("localhost", glob.getPortNumber() );

		if( s.isConnected() )	{
			System.out.println("\n Connection with server established!");
			
			in = new Scanner( s.getInputStream() );
			out = new PrintWriter( s.getOutputStream(), true);
			
			flag = true;
		}
		else	{
			System.out.println("\n ERROR: Could not establish connection with server!");
			flag = false;
		}
		
		while( flag )	{
			System.out.print("\n Enter message: ");
			message = keyboard.nextLine();
			out.println(message);

			if( message.equals("bye") )	{
				flag = false;
			}
			
			if( in.hasNextLine() )	{
				message = in.nextLine();

				System.out.println(message);
			}
			
		}
		
	}  //end of main()
}
