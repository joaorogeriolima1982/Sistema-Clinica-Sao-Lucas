/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author João Rogério de Lima
 */
public class CriptografiaAES {
    private static final String ALGORITMO = "AES";
    private static final String TRANSFORMACAO = "AES/GCM/NoPadding";
    private static final int IV_LENGTH = 12;
    private static final int TAG_LENGTH = 128;
    
    public static SecretKey gerarChave() throws Exception {

        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITMO);
        keyGenerator.init(256);

        return keyGenerator.generateKey();
    }
     
    public static SecretKey carregarChave(String chaveBase64) {

        byte[] bytes = Base64.getDecoder().decode(chaveBase64);

        return new SecretKeySpec(bytes, ALGORITMO);
    }
      
    public static String salvarChave(SecretKey chave) {

        return Base64.getEncoder().encodeToString(chave.getEncoded());
    }
       
    public static String criptografar(String texto, SecretKey chave) throws Exception {

        byte[] iv = new byte[IV_LENGTH];

        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        Cipher cipher = Cipher.getInstance(TRANSFORMACAO);

        GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH, iv);

        cipher.init(Cipher.ENCRYPT_MODE, chave, spec);

        byte[] criptografado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));

        byte[] resultado = new byte[iv.length + criptografado.length];

        System.arraycopy(iv, 0, resultado, 0, iv.length);
        System.arraycopy(criptografado, 0, resultado, iv.length, criptografado.length);

        return Base64.getEncoder().encodeToString(resultado);
    }
    
     public static String descriptografar(String textoCriptografado,
                                         SecretKey chave) throws Exception {

        byte[] dados = Base64.getDecoder().decode(textoCriptografado);

        byte[] iv = new byte[IV_LENGTH];
        byte[] criptografado = new byte[dados.length - IV_LENGTH];

        System.arraycopy(dados, 0, iv, 0, IV_LENGTH);
        System.arraycopy(dados, IV_LENGTH, criptografado, 0, criptografado.length);

        Cipher cipher = Cipher.getInstance(TRANSFORMACAO);

        GCMParameterSpec spec = new GCMParameterSpec(TAG_LENGTH, iv);

        cipher.init(Cipher.DECRYPT_MODE, chave, spec);

        byte[] texto = cipher.doFinal(criptografado);

        return new String(texto, StandardCharsets.UTF_8);
    }
     
     public static String retornarSenha(String senhadescriptografada){
           Properties prop = new Properties();           

           try (FileInputStream fis = new FileInputStream("config.properties2")) {  
           prop.load(fis);                                                                                     
            
           String chaveBase64 = Files.readString(Path.of("chave.key")).trim();                 

           SecretKey chave = CriptografiaAES.carregarChave(chaveBase64);
            
           senhadescriptografada = CriptografiaAES.descriptografar(prop.getProperty("senhadescripto"), chave);

           } catch (Exception d) {
            d.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR A SENHA DE AUTORIZAÇÃO, CONTATE O SUPORTE!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
           }
           return senhadescriptografada;
     }

}
