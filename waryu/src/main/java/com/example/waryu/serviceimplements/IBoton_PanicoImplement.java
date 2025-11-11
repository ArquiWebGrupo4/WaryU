package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Boton_Panico;
import com.example.waryu.repositories.IBoton_PanicoRepository;
import com.example.waryu.serviceinterfaces.IBoton_PanicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;


@Service
public class IBoton_PanicoImplement implements IBoton_PanicoService {
    @Autowired
    private IBoton_PanicoRepository btn_Pan;

    @Override
    public void insert(Boton_Panico boton_panico){
        btn_Pan.save(boton_panico);
    }
    @Override
    public List<Boton_Panico> list(){
        return btn_Pan.findAll();
    }

    @Override
    public void delete(int id) {
        btn_Pan.deleteById(id);
    }

    @Override
    public Boton_Panico listId(int id) {
        return  btn_Pan.findById(id).orElse(null);
    }

    @Override
    public void update(Boton_Panico panico) {
        btn_Pan.save(panico);
    }

    @Override
    public List<Boton_Panico> Buscarporfechas(LocalDateTime fechaini, LocalDateTime fechafin){
        return btn_Pan.Buscarporfecha(fechaini,fechafin);
    }

    @Override
    public void interact(String nombre, double latitud, double longitud) {
        String url = "https://graph.facebook.com/v22.0/827902510409510/messages";
        String accessToken = "Bearer EAALdJvzuOd4BPZCGIMWZAOCEQKZAS7ZBTMZCfcETqv5CTR8Q1BU1ZAOyV5lQfBjsNnLMsYOtL3LHH50xWaHewZC1n6wULmsyacKrpXCQx3xC3gFOR1w84HFASZAiE0FSRaj1vXiGkxFgF82FKhnkTfi90i2jaoWLZBglXSZBhClQoDyZAYV0bYZB61ASwtmQpjWezRX2K11jJYJPHk8HihzTuMzZA1DLDvveRCjIqC4WRhZBmpcgHamJIv0buvtI00iJ6tgClUpAOiPK1nuGklGuVcYMt6";

        String jsonBody = String.format("""
        {
          "messaging_product": "whatsapp",
          "to": "51947117754",
          "type": "template",
          "template": {
            "name": "boton",
            "language": {
              "code": "es_PE"
            },
            "components": [
              {
                "type": "body",
                "parameters": [
                  { "type": "text", "text": "%s" },
                  { "type": "text", "text": "%s" },
                  { "type": "text", "text": "%s" }
                ]
              }
            ]
          }
        }
        """, nombre, String.valueOf(latitud), String.valueOf(longitud));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println("Respuesta: " + response.getBody());
    }

    @Override
    public void test() {
        String url = "https://graph.facebook.com/v22.0/900598543130925/messages";
        String accessToken = "Bearer EAALdJvzuOd4BP12Jqn8WQ0KaryvCAlEDUNaWtZBLQGC4Q4ZA4LOodNZBXan7DoSk2XmzoF6t5Ohle1UuimpbZB1UscLHtXP15nBnHeJNrwqLsrlyZBJiJZCcf0QZA2uDG8ZCIhqXBBqgnT9XnxRMYMUIh1tXfEGPXB0ENOhopxRehAHW7coj0LPNhm1mu7xZAvzakVXnZBzIoKpNxmDYEW8WSzOkwHFxeHF0KE2zbDPWzE0hTX95egXzBcipOVXjQkIxCsOrfBfzWYgxCYc3h8chHZB";

        // Body completo como String
        String jsonBody = """
        {
          "messaging_product": "whatsapp",
          "to": "51947117754",
          "type": "template",
          "template": {
            "name": "hello_world",
            "language": {
              "code": "en_US"
            }
          }
        }
        """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println("Respuesta: " + response.getBody());
    }
}
