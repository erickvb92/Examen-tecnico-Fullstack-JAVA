package com.openpay.jaraplication.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.openpay.jaraplication.controller.RestApiControllerMarvel;

public class Utilities {

	private static final Logger log = LogManager.getLogger(RestApiControllerMarvel.class);
	
	 public static String calculateMD5(String input) {
	        try {
	            // Obtiene una instancia de MessageDigest con el algoritmo MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");

	            // Convierte la cadena de entrada en un arreglo de bytes
	            byte[] inputBytes = input.getBytes();

	            // Calcula el hash MD5 de los bytes de entrada
	            byte[] hashBytes = md.digest(inputBytes);

	            // Convierte los bytes del hash a una representación hexadecimal
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashBytes) {
	                sb.append(String.format("%02x", b));
	            }

	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	 public static String bulidUrl() {
		 String endpoint = "";
		 int limit = 20;
		 try {
			 String hash = calculateMD5(Constants.stringToHash);
			 endpoint = Constants.baseUrl + "?limit=" + limit + "&ts=" + Constants.ts + "&apikey=" + Constants.publickey + "&hash=" + hash;
		 }catch(Exception e){
			 log.error("Log level: ERROR bulidUrl: " + e.getMessage());
		 }
		return endpoint;
	 }
	 
	 public static String bulidUrlId(String id) {
		 String endpoint = "";
		 int limit = 20;
		 try {
			 String hash = calculateMD5(Constants.stringToHash);
			 endpoint = Constants.baseUrl + "/"+ id+ "?limit=" + limit + "&ts=" + Constants.ts + "&apikey=" + Constants.publickey + "&hash=" + hash;
		 }catch(Exception e){
			 log.error("Log level: ERROR bulidUrlId: " + e.getMessage());
		 }
		return endpoint;
	 }
	 
}
