package com.openpay.jaraplication.utils;

import java.util.Date;

public class Constants {

	static final String baseUrl = "https://gateway.marvel.com:443/v1/public/characters";
	static final String publickey = "6a564f05ea086bb144ca5bd5d483304c";
	static final String privatekey = "ac0402ac1c0eee97bc850016561610e4e46e6882";
	static final long ts = new Date().getTime();
	static final String stringToHash = ts + privatekey + publickey;
	
}
