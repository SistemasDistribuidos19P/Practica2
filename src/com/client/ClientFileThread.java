package com.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientFileThread extends Thread {
	
	static Socket sc;
	
	public void run() {
		
		try {
			
			System.out.println("************************");
			System.out.println("Accessing server 1...");
			
			sc = new Socket("192.168.100.6", 5001);
						
			DataOutputStream out = new  DataOutputStream(sc.getOutputStream());
			DataInputStream in = new DataInputStream(sc.getInputStream());
			ObjectOutputStream outObject = new ObjectOutputStream(sc.getOutputStream());
			ObjectInputStream inObject = new ObjectInputStream(sc.getInputStream());
						
        	File archivo = new File ("mike.txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String palabraC = "sociedad";
            out.writeInt(2);
            out.writeUTF(palabraC);
            
            ArrayList<String> file = new ArrayList<String>();
            String linea = br.readLine();
            			
            do {
    			file.add(linea);
    			linea = br.readLine();
				
			} while (linea != null);
            
            br.close();
            
            outObject.writeObject(file);
            
            System.out.println("Server 1 SUCCESS.");
			System.out.println("Finishing excecution...");
			System.out.println("************************\n");
			
			System.out.println(file);
            
            int numPalabras = in.readInt();
            System.out.println("\nEl texto contiene la plabra '" + palabraC + "' " + numPalabras + " veces.");
          
			
            			
			sc.close();
			
		}
		
		catch (Exception e){
			
			try {
				
				System.out.println("Server 1 FAILED");
				System.out.println("Accessing server 2...");
				System.out.println("Server 2 SUCCESS");
				System.out.println("Continuing excecution...");
				System.out.println("************************\n");
				
				sc = new Socket("localhost", 5001);
				
				DataOutputStream out = new  DataOutputStream(sc.getOutputStream());
				DataInputStream in = new DataInputStream(sc.getInputStream());
				ObjectOutputStream outObject = new ObjectOutputStream(sc.getOutputStream());
				ObjectInputStream inObject = new ObjectInputStream(sc.getInputStream());
							
	        	File archivo = new File ("mike.txt");
	            FileReader fr = new FileReader (archivo);
	            BufferedReader br = new BufferedReader(fr);
	            
	            String wordC = "sociedad";
	            out.writeInt(2);
	            out.writeUTF(wordC);
	            
	            ArrayList<String> file = new ArrayList<String>();
	            String linea = br.readLine();
	            			
	            do {
	    			file.add(linea);
	    			linea = br.readLine();
					
				} while (linea != null);
	            
	            br.close();
	            
	            outObject.writeObject(file);
				
				System.out.println(file);
	            
	            int numWords = in.readInt();
	            System.out.println("\nThe text contains the word '" + wordC + "' " + numWords + " times.");
	          
				
	            			
				sc.close();
				
			} catch (Exception e2) {
				
				System.out.println("ERROR: " + e.getMessage());
				
			}	
		}
	}
}
