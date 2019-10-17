package com.server;

public class Server {
	

        	
	public static void main(String[] args) {
		System.out.println("Iniciando servidor...\n");
		iniciateServer();
	}
	
	public static void iniciateServer() {
        
    	try {
            
            Thread1 threadClient1 = new Thread1("1");
            Thread2 threadClient2 = new Thread2("2");
            
            threadClient1.start();
            threadClient2.start();
            
            threadClient1.join();
            threadClient2.join();
            
        }
    	
        catch (Exception e) {
        	
            System.out.println("Error: "+e.getMessage());
            
        }
	}
}