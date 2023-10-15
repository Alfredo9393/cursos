/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metrics.controller;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author APerez
 */
@RestController
@RequestMapping("/api/devsj")
public class metricas {
    
    @Autowired
    private MeterRegistry registry;
    
    private static final Logger Log = LoggerFactory.getLogger(metricas.class);
    
    //http://localhost:8080/api/devsj/metric
    @RequestMapping(value="/metric",method=RequestMethod.GET)
    public  ResponseEntity<String> get(){
        registry.counter("devs4j_adap.metrics").increment();
        Timer timer = registry.timer("devs4j_timer.metrics");
        timer.record(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
            Log.info("Usless task");

        });

        Log.info("MeterRegistry used {} ", registry.getClass().getName());
        System.out.println("invoke rest");
        return new ResponseEntity<String>("@raidentrance",HttpStatus.OK);
    }
}
