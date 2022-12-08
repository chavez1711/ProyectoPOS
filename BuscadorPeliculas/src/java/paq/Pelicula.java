/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

public class Pelicula {
    private String titulo;
    private String anio;
    private String poster;

    public Pelicula(String titulo, String anio, String poster) {
        this.titulo = titulo;
        this.anio = anio;
        this.poster = poster;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", anio=" + anio + ", poster=" + poster + '}';
    }

    
}
