/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlie.aplikasiinventarisperusahaan;

/**
 *
 * @author charlie
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        if (koneksi == null) {
            try {
                // url untuk mengakses database db_perusahaan di localhost
                String url = "jdbc:mysql://localhost:3306/db_perusahaan"; 
                String user = "charlie"; // Isi usernya
                String pass = "21";     // Passwordnya
                
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                
                
                koneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi Database Berhasil!");
            } catch (SQLException e) {
                System.out.println("Error Koneksi Database: " + e.getMessage());
            }
        }
        return koneksi;
    }
}
