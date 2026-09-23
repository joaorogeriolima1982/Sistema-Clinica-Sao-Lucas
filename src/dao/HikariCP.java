/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;
import security.CriptografiaAES;

/**
 *
 * @author João Rogério de Lima
 */
public class HikariCP {
      private static String url;
      private static String usuario;
      private static String senha;
      private static SecretKey chave;
      private static HikariDataSource dataSource = null;
      
    static {  
        
            Properties prop = new Properties();
            
            try(FileInputStream fis = new FileInputStream("config.properties")){
                prop.load(fis);
                
                String chaveBase64 = Files.readString(Path.of("chave.key")).trim();
                
                chave = CriptografiaAES.carregarChave(chaveBase64);
                
                url = CriptografiaAES.descriptografar(prop.getProperty("url"), chave);
                usuario = CriptografiaAES.descriptografar(prop.getProperty("usuario"), chave);
                senha = CriptografiaAES.descriptografar(prop.getProperty("senha"), chave);
            
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERRO AO PROCESSAR AS CREDENCIAIS DO BANCO DE DADOS, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

    
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(usuario);
        config.setPassword(senha);

        config.setDriverClassName("org.postgresql.Driver");

        config.setMaximumPoolSize(10);

        config.setMinimumIdle(2);

        config.setConnectionTimeout(30000);

        config.setIdleTimeout(600000);

        config.setMaxLifetime(1800000);

        config.setPoolName("ClinicaPool");
        
        try{

        dataSource = new HikariDataSource(config);
        
        }catch(Exception e){
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR NO BANCO DE DADOS, VERIFIQUE A CONEXÃO COM A INTERNET OU CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
     public static void fecharPool(){ 
        if(dataSource != null){
            dataSource.close();
        }
    }
}
