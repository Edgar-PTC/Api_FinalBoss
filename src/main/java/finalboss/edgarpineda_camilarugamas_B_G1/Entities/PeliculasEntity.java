package finalboss.edgarpineda_camilarugamas_B_G1.Entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Getter @Setter @ToString
@EqualsAndHashCode
@Table(name = "PELICULAS")
public class PeliculasEntity {
    @Id
    @Column(name = "ID_PELICULA", columnDefinition = "NUMBER", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PELICULAS")
    private Integer id;

    @Column(name = "TITULO", columnDefinition = "VARCHAR2(200)", nullable = false)
    private String titulo;

    @Column(name = "DIRECTOR", columnDefinition = "VARCHAR2(120)")
    private String director;

    @Column(name = "GENERO", columnDefinition = "VARCHAR2(60)")
    private String genero;

    @Column(name = "ANO_ESTRENO", columnDefinition = "NUMBER(4,0)")
    private Integer anio_estreno;

    @Column(name = "DURACION_MIN", columnDefinition = "NUMBER(4,0)")
    private Integer duracion_min;

    @Column(name = "FECHA_CREACION", columnDefinition = "DATE", nullable = false)
    private Date fecha_creacion;
}
