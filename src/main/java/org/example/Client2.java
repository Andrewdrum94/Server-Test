package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        while (true) {
            try (Socket clientSocket2 = new Socket("127.0.0.1", 8082);
                 PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
                 Scanner scanner2 = new Scanner(System.in);
                 BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()))) {
                while (true) {
                    String actualCity = in2.readLine();
                    System.out.println("Актуальный город: " + actualCity);
                    System.out.print("Введите название города: ");
                    out2.println(scanner2.nextLine());
                    String response = in2.readLine();
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
