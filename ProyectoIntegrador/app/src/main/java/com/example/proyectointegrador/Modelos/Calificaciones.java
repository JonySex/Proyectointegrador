package com.example.proyectointegrador.Modelos;

public class Calificaciones {


    public String idCalificacion;
    public int Calificacion;
    public String nombreMateria;
    public String NombreAlumno;
    public String NombreMaestro;


    public Calificaciones() {
    }

    public Calificaciones(String idCalificacion, float calificacion, String nombreMateria, String NombreAlumno, String NombreMaestro) {
        idCalificacion = idCalificacion;
        calificacion = calificacion;
        nombreMateria = nombreMateria;
        NombreAlumno = NombreAlumno;
        NombreMaestro = NombreMaestro;
    }
}
