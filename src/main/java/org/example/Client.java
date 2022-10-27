package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        while (true) {
            try (Socket clientSocket = new Socket("127.0.0.1", 8082);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 Scanner scanner = new Scanner(System.in);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                while (true) {
                    String actualCity = in.readLine();
                    System.out.println("Актуальный город: " + actualCity);
                    System.out.print("Введите название города: ");
                    out.println(scanner.nextLine());
                    String response = in.readLine();
                    if (response.equals("end")) {
                        break;
                    }
                    System.out.println(response);
                }
                break;
            } catch (
                    IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}