package com.openpay.jaraplication.serviceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openpay.jaraplication.controller.RestApiControllerMarvel;
import com.openpay.jaraplication.model.character.Root;
import com.openpay.jaraplication.service.ServiceRepository;
import com.openpay.jaraplication.utils.Utilities;

@Service
public class ServiceRepositoryImpl implements ServiceRepository{

	private static final Logger log = LogManager.getLogger(RestApiControllerMarvel.class);

	@Override
	public Root getCharacterData() throws Exception {
		Root respuesta = null;
		try {
			log.info("Log level: INFO, Peticion realizada ");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate plantilla = new RestTemplate();
			String url = Utilities.bulidUrl();
			log.info("Log level: INFO: " + "la URL es: " + url);

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<Root> response = plantilla.exchange(url, HttpMethod.GET, entity,
					Root.class);
			respuesta =  response.getBody();
			
			log.info("Log level: INFO: Peticion Exitosa");
           
		} catch (Exception e) {
			log.error("Log level: ERROR: " + e.getMessage());
		}
	return respuesta;
	}


	@Override
	public Root getCharacterDataId(String id) throws Exception {
		Root respuesta = null;
		try {
			log.info("Log level: INFO, Peticion realizada ");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			RestTemplate plantilla = new RestTemplate();
			String url = Utilities.bulidUrlId(id);
			log.info("Log level: INFO: " + "la URL es: " + url);

			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<Root> response = plantilla.exchange(url, HttpMethod.GET, entity,
					Root.class);
			respuesta =  response.getBody();
			
			log.info("Log level: INFO: Peticion Exitosa");
           
		} catch (Exception e) {
			log.error("Log level: ERROR: " + e.getMessage());
		}
		return respuesta;
	}
}
