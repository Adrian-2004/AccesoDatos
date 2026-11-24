package es.aula;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Pelicula {
    @Id
    @Column(name = "film_id")
    private Integer id;
    @Column(name = "title")
    private String titulo;
    @Column(name = "language_id")
    private Integer idiomaId;
    @Column(name = "rental_rate")
    private BigDecimal tarifa;

    protected Pelicula() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }
}