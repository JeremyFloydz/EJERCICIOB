package org.example.ejeb;

import java.util.Objects;

/**
 * Clase que representa una persona con nombre, apellidos y edad.
 * <p>
 * La clase incluye métodos para obtener las propiedades de una persona, y
 * métodos sobrescritos de {@link Object} para comparar y calcular el código hash
 * de las instancias de persona.
 * </p>
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    /**
     * Constructor para crear una nueva instancia de {@code Persona}.
     *
     * @param nombre    El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param edad      La edad de la persona.
     */
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve los apellidos de la persona.
     *
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Devuelve la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Compara esta instancia de {@code Persona} con otro objeto.
     * <p>
     * Dos personas se consideran iguales si tienen el mismo nombre,
     * apellidos y edad.
     * </p>
     *
     * @param obj El objeto a comparar con esta instancia.
     * @return {@code true} si los objetos son iguales, {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;
        Persona persona = (Persona) obj;
        return edad == persona.edad &&
                nombre.equals(persona.nombre) &&
                apellidos.equals(persona.apellidos);
    }

    /**
     * Calcula el código hash de esta instancia de {@code Persona}.
     *
     * @return El código hash basado en el nombre, apellidos y edad.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad);
    }
}
