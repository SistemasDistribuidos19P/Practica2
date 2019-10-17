package com.client;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class ClientListThread extends Thread  {
	
  	static Socket sc;
	
	public void run() {
		
		try {
			System.out.println("************************");
			System.out.println("Accessing server 1...");
			
			sc = new Socket("192.168.100.6", 5002);
			
			DataOutputStream out = new  DataOutputStream(sc.getOutputStream());
			ObjectOutputStream outObject = new ObjectOutputStream(sc.getOutputStream());
			ObjectInputStream inObject = new ObjectInputStream(sc.getInputStream());
			
			LinkedList<String> names = new LinkedList<String>();
			
			names.add("Estela");
			names.add("Michelle");
			names.add("Mike");
			names.add("Eduardo");
			names.add("Ana");
			names.add("Juanito");
			names.add("Maria");
			names.add("Ancelmo");
			names.add("Caro");
			names.add("Pedrito");
			names.add("Zaide");
			names.add("Wiliam");
			names.add("Elisa");
			
			System.out.println("Server 1 SUCCESS.");
			System.out.println("Finishing excecution...");
			System.out.println("************************\n");
									
			System.out.println("Original List: ");
			System.out.println(names);
			
			out.writeInt(1);
			outObject.writeObject(names);
			
			System.out.println("\nOrdered List:");
			Object orderedNameList = inObject.readObject();
			System.out.println(orderedNameList + "\n");
			
			sc.close();
			
		}
		
		catch (Exception e){
			
			try {
				
				System.out.println("Server 1 FAILED");
				System.out.println("Accessing server 2...");
				System.out.println("Server 2 SUCCESS");
				System.out.println("Continuing excecution...");
				System.out.println("************************\n");
				
				sc = new Socket("localhost", 5002);
								
				DataOutputStream out = new  DataOutputStream(sc.getOutputStream());
				ObjectOutputStream outObject = new ObjectOutputStream(sc.getOutputStream());
				ObjectInputStream inObject = new ObjectInputStream(sc.getInputStream());
				
				LinkedList<String> names = new LinkedList<String>();
				
				names.add("Estela");
				names.add("Michelle");
				names.add("Mike");
				names.add("Eduardo");
				names.add("Ana");
				names.add("Juanito");
				names.add("Maria");
				names.add("Ancelmo");
				names.add("Caro");
				names.add("Pedrito");
				names.add("Zaide");
				names.add("Wiliam");
				names.add("Elisa");
										
				System.out.println("Original List: ");
				System.out.println(names);
				
				out.writeInt(1);
				outObject.writeObject(names);
				
				System.out.println("\nOrdered List:");
				Object orderedNameList = inObject.readObject();
				System.out.println(orderedNameList + "\n");
				
				sc.close();
				
			} catch (Exception e2) {
				
				System.out.println("ERROR " + e.getMessage());
				
			}		
		}
	}
}
