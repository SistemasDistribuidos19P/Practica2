package com.server;

public class Server {
	

        	
	public static void main(String[] args) {
		System.out.println("Iniciando servidor...\n");
		iniciateServer();
	}
	
	public static void iniciateServer() {
        
    	try {
            
            Thread1 threadClient1 = new Thread1("Thread 1");
            Thread2 threadClient2 = new Thread2("Thread 2");
            
            threadClient1.start();
            //Integer.parseInt( "hola" ); codigo para provocar falla
            threadClient2.start();
                        
            threadClient1.join();
            threadClient2.join();
            
        }
    	
        catch (Exception e) {
        	
            System.out.println("ERROR: "+e.getMessage());
            
        }
	}
}