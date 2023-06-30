package com.openpay.jaraplication.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.openpay.jaraplication.model.character.Root;
import com.openpay.jaraplication.serviceImpl.ServiceRepositoryImpl;
import com.openpay.jaraplication.utils.Utilities;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/openpay")
public class RestApiControllerMarvel {
	
	 @Autowired
	 ServiceRepositoryImpl serviceRepositoryImpl;

	private static final Logger log = LogManager.getLogger(RestApiControllerMarvel.class);

	/*
	 * =============================================================================
	 * ========================= SERVICIOS API PARA MARVEL
	 * =============================================================================
	 */

	@GetMapping("/character")
	@ResponseBody
	public Root getCharacter() {
		log.info(
				"_________________________________________________INICIO___________________________________________________________");
		Root respuesta = null;
			try {
				respuesta =  serviceRepositoryImpl.getCharacterData();
				} catch (Exception e) {
				log.error("Log level: ERROR: " + e.getMessage());
			}
		log.info(
				"_________________________________________________FIN___________________________________________________________");
		return respuesta;
	}
	
	@GetMapping("/characterId")
	@ResponseBody
	public Root getCharacterId(@RequestParam(required = true) String id) {
		log.info(
				"_________________________________________________INICIO___________________________________________________________");
		Root respuesta = null;
			try {
				respuesta =  serviceRepositoryImpl.getCharacterDataId(id);
				} catch (Exception e) {
				log.error("Log level: ERROR: " + e.getMessage());
			}
		log.info(
				"_________________________________________________FIN___________________________________________________________");
		return respuesta;
	}

	
}