/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ClienteRestPelicula 
{
    public static List<Pelicula> peliculasPorTema(String tema) throws org.json.simple.parser.ParseException
    {
        List<Pelicula> listaPeliculas = new ArrayList();
        
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.omdbapi.com/")
                .queryParam("s", tema)
                .queryParam("apikey", "92bba147");
        
        Invocation.Builder invocationBuilder = 
                target.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
        
        JSONParser parser = new JSONParser();
        JSONObject responseJSON = 
                (JSONObject) parser.parse(response.readEntity(String.class));
        JSONArray peliculas = (JSONArray) responseJSON.get("Search");
        for (Iterator it = peliculas.iterator(); it.hasNext();) 
        {
            Object pelicula = it.next();
            JSONObject cadaPelicula = (JSONObject) pelicula;
            String titulo = (String) cadaPelicula.get("Title");
            String anio = (String) cadaPelicula.get("Year");
            String poster = (String) cadaPelicula.get("Poster");
            listaPeliculas.add(new Pelicula(titulo, anio, poster));
        }
        return listaPeliculas;
    }
}
