package com.corhuila.app_explora_neiva.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "factura")
public class Factura extends ABaseEntity {

    /*
     * numero_factura : string (formato como "F00001")
     * fecha_emision : datetime
     * monto_total : decimal(10,2)
     * metodo_pago : string («efectivo», «tarjeta», «transferencia», «nequi», etc.)
     * estado_pago : string («pendiente», «pagado», «cancelado»)
     * id_reservacion : int «FK»
     */

    @Column(name = "numero_factura", nullable = false, length = 20)
    private String numeroFactura;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "descripcion", nullable = true, length = 500)
    private String descripcion;

    @Column(name = "monto_total", nullable = false)
    private double montoTotal;

    @Column(name = "metodo_pago", nullable = false, length = 50)
    private String metodoPago;

    @Column(name = "estado_pago", nullable = false, length = 20)
    private String estadoPago;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_reservacion", referencedColumnName = "id")
    private Reservacion reservacion;

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
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
