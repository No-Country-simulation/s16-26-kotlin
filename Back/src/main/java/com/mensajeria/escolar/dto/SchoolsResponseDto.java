package com.mensajeria.escolar.dto;

import com.mensajeria.escolar.entity.Escuela;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolsResponseDto implements Serializable {
    public Long id;
    public String name;
    public List<SchoolLevelResponseDto> levels;

    public SchoolsResponseDto(Escuela escuela) {
        this.id = escuela.getId();
        this.name = escuela.getNombre();
        this.levels = escuela.getNiveles().stream().map(SchoolLevelResponseDto::new).toList();
    }

}
