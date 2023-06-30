package com.openpay.jaraplication.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Repository;

import com.openpay.jaraplication.model.character.Root;

@Repository
public interface ServiceRepository {

	/*
	 * =============================================================================
	 * ========================= SERVICIOS API 
	 * =============================================================================
	 */
	public Root getCharacterData() throws Exception;
	
	public Root getCharacterDataId(String id) throws Exception;
	
}
