package com.corhuila.app_explora_neiva.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "reservacion")
public class Reservacion extends ABaseEntity {

    /*
     * nullable: true → Permite valores nulos en la columna, lo que significa que
     * puedes insertar registros sin definir un valor para esa columna.
     * nullable: false → No permite valores nulos, lo que obliga a insertar un
     * valor en la columna para cada fila
     * EJEMPLO DE LLAVE FORANEA:
     * 
     * @ManyToOne(optional = false) // Cada reseña debe estar asociada a un sitio
     * turístico
     * 
     * @JoinColumn(name = "sitio_turistico_id", referencedColumnName = "id")
     * private SitioTuristico sitioTuristico;
     */

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "numero_personas", nullable = false)
    private int numeroPersonas;

    @Column(name = "observaciones", nullable = true, length = 500)
    private String observaciones;

    @Column(name = "tipo_reserva", nullable = false, length = 80)
    private String tipoReserva;

    /**
     * @ManyToOne: Esta es una anotación de JPA (Java Persistence API) que indica
     *             que existe una relación de tipo
     *             "muchos a uno" entre la entidad actual (Reservacion) y otra
     *             entidad (User).
     *             En este caso, significa que muchas instancias de Reservacion
     *             pueden estar asociadas a una sola instancia de User.
     * 
     *             optional = false: Esto especifica que esta relación es
     *             obligatoria, es decir, una instancia de Reservacion
     *             debe estar asociada a un User. No se permite que el campo user
     *             sea null.
     * 
     * @JoinColumn: Define cómo se mapea esta relación en la base de datos, es
     *              decir, cómo se conectan las tablas correspondientes.
     * 
     *              name = "id_usuario": Especifica el nombre de la columna en la
     *              tabla de Reservacion que se usará como clave foránea
     *              para referenciar a la tabla de User.
     * 
     *              referencedColumnName = "id": Indica que la columna id de la
     *              tabla User es la clave primaria que será referenciada
     *              por la clave foránea id_usuario.
     * 
     *              private User user: Este es el atributo de la clase Reservacion
     *              que representa la relación con la entidad User.
     *              En términos prácticos, este campo permite acceder a los datos
     *              del usuario asociado a una reservación directamente
     *              desde el objeto Reservacion.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_sitio_turistico", referencedColumnName = "id")
    private SitioTuristico sitioTuristico;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public SitioTuristico getSitioTuristico() {
        return sitioTuristico;
    }

    public void setSitioTuristico(SitioTuristico sitioTuristico) {
        this.sitioTuristico = sitioTuristico;
    }

}
