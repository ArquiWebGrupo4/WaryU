package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Boton_Panico;
import com.example.waryu.entities.Usuario;
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

    @Autowired
    private UsuarioServiceImplement uS;

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
    public void interact(String userid, double latitud, double longitud) {
        String url = "https://graph.facebook.com/v22.0/827902510409510/messages";
        String accessToken = "Bearer EAALdJvzuOd4BQABx7WbmK4VKUykZBqr0CPTh1JaAATfeFziMaWspNqW8ASCuiCX1Kyaj23ESTshApM1DW6AwlWJm9TQwi9lxY7f4DjbKhv7AWjxlEpU5PPyidzLq7gZCKSM92k8NXbHfWGxCPSWbMWS4iUwcr8ZBD8eLcHaFB1Nf5ywyxvXWu41qasiMwZDZD";
        Usuario u = uS.findID(Integer.parseInt(userid));

        String jsonBody = String.format("""
        {
          "messaging_product": "whatsapp",
          "to": "%s",
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
                  { "type": "text", "text": "%s" },
                  { "type": "text", "text": "%s" }
                ]
              }
            ]
          }
        }
        """,u.getTelefono_Panico(), u.getNombreCompleto(), String.valueOf(latitud), String.valueOf(longitud), u.getMensaje());

        System.out.print(jsonBody);
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
        String accessToken = "Bearer EAALdJvzuOd4BP0gpR9qLHadSZBqtAKAhpqK6OagJssznJCwEtoSgwmjSDNGrL5yn8TBNIwRlHJBZA0xFYsgwWsLx5KoApZAOLjCm7DadGhOFjh85DdS2KAQmZBUoKNrkZAyCqNDbxB19l9bRl9t2yP8ZC8uwxtA0B4E1j9ZCAG5rgJJ2GdV681ZB4TKSbwPv6QZDZD";

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
