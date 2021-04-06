package com.uam.service;

import com.uam.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    public static void main(){
        Scanner sc = new Scanner(System.in);

        System.out.println("DIGITE O NÚMERO DE CLIENTES PARA CADASTRO:");
        Integer clientsNumber = sc.nextInt();

        List<Client> clientList = criaCliente(clientsNumber);

        System.out.println(clientList);
    }


    private static List<Client> criaCliente(Integer clientsNumber){

        Integer id = 0;

        Scanner sc = new Scanner(System.in);
        List<Client> clients = new ArrayList<>();

        for(int i=0; i<clientsNumber; i++){
            Client client = new Client();
            System.out.println("DIGITE O ID DO CLIENTE(" + i + ")");
            id = sc.nextInt();
            client.setId(id);
            client.setStatus(Boolean.TRUE);
            clients.add(client);
        }

        for(Client list: clients){
        	if(list.getId()==1)
        	{
        		System.out.println("Existe id 1");
        		System.out.println("Id:"+list.getId()+"\nStatus:"+list.getStatus());
        	}

        }

        return clients;
    }

}
