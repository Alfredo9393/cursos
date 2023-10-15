/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devs4j.users.controllers;

import com.devs4j.users.entities.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author APerez
 */
@RestController
@RequestMapping("/alerts")
public class AlerController {
    
        private static final Logger Log = LoggerFactory.getLogger(AlerController.class);

    	@PostMapping
	public ResponseEntity<String> postAlert(@RequestBody String alertMesage) {
            Log.error("Alert received {} ",alertMesage);
            return new ResponseEntity<>( HttpStatus.ACCEPTED);
	}
}
