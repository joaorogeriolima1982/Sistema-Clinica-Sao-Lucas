/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import br.com.caelum.stella.validation.CPFValidator;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import java.util.regex.Pattern;

/**
 *
 * @author João Rogério de Lima
 */
public class ServiceValidarCpfEmailTelefone {
     private final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{3,}$");
    
     public boolean validarCpf(String cpff) {
		CPFValidator cpfValidator = new CPFValidator();
		
		try{
			cpfValidator.assertValid(cpff);
			return true;
		}catch(Exception e){
			return false;
		}
    }
     
     public boolean validarTelefone(String telefonee){
                PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
         
         try{
                Phonenumber.PhoneNumber phone = phoneUtil.parse(telefonee, "BR");
                return phoneUtil.isValidNumber(phone);
             
         }catch(NumberParseException e){
                return false;
         }                                                                         
    }
     
     public boolean validarEmail(String emaill){
         
         try{
             return EMAIL_PATTERN.matcher(emaill).matches();
             
         }catch(Exception e){
            return false; 
         }
     }
}
