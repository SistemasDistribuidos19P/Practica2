package com.client;

public class ThreadClientController {
        	
	public static void main(String[] args) {
		System.out.println("Iniciando clientes concurrentes...\n");
		iniciateServer();
	}
	
	public static void iniciateServer() {
        
    	try {
            
    		ClientListThread threadClient1 = new ClientListThread();
    		ClientFileThread threadClient2 = new ClientFileThread();
            
            threadClient1.start();
            threadClient1.join();
            threadClient2.start();
            threadClient2.join();
            
        }
    	
        catch (Exception e) {
        	
            System.out.println("Error: "+e.getMessage());
            
        }
	}
}