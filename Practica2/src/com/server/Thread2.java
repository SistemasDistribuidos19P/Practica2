package com.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Thread2 extends Thread {
	
    private String name;
    static final int PUERTO = 5002;
    static ServerSocket sc;
    static Socket so;

    Thread2(String threadName) {
            name = threadName;
    }	
    
    public void run() {
    	
    	try {
    		
			sc = new ServerSocket(PUERTO);
			so = new Socket();
			
			System.out.println("Waiting connection on " + name + "...");
			
			so = sc.accept();
			
			System.out.println("\n*******************************");
			System.out.print("Conection stablish on " + name + "\n");
			System.out.println("*******************************");
			
			ObjectInputStream inObject = new ObjectInputStream(so.getInputStream());
			ObjectOutputStream outObject = new ObjectOutputStream(so.getOutputStream());
			DataOutputStream out = new DataOutputStream(so.getOutputStream());
			DataInputStream in = new DataInputStream(so.getInputStream());

			int selection = in.readInt();
			System.out.println("Selección " + selection);
			
			if (selection == 1) {
	            
				Object clientNames = inObject.readObject();
				
				List<String> clientNamesList = new ArrayList();
				clientNamesList.addAll((Collection<? extends String>) clientNames);
				
				Collections.sort(clientNamesList);
				
				outObject.writeObject(clientNamesList);

														
			}else if (selection == 2) {
				
				String palabra = in.readUTF();
				Object clientFile = inObject.readObject();
				
				ArrayList<String> clientFileList = new ArrayList<String>();
				clientFileList.addAll((Collection<? extends String>) clientFile);
				
				System.out.println(palabra);
				
				int contador = 0;
				for (int i = 0; i < clientFileList.size(); i++) {
					
					String sarray[] = clientFileList.get(i).split(" ");
					
					for (int j = 0; j < sarray.length; j++) {
                        
                    	if (sarray[j].equals(palabra) == true) {
                            contador++;
                            
                        }
                        
                    }
					
				}
				
                    
                    
                    
                    out.writeInt(contador);
                    
                    System.out.println(contador);
                
			}
            
            sc.close();
			
		} catch (IOException | ClassNotFoundException e) {
			
			System.out.println("Error: " + e.getMessage());
			
		}            	
    }    
}