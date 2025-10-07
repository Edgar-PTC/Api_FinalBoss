package finalboss.edgarpineda_camilarugamas_B_G1.Models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;

@Getter @Setter @ToString
@EqualsAndHashCode
public class PeliculasDTO {
    private Integer id;

    @NotBlank(message = "El titulo de la pelicula no puede quedar en blanco")
    private String titulo;

    private String director;

    private String genero;

    private Integer anio_estreno;

    private Integer duracion_min;

    @NotNull(message = "La fecha de creacion de la pelicula no puede quedar vacia")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha_creacion;
}
