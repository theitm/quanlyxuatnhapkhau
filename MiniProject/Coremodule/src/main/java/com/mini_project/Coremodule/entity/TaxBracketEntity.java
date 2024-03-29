package com.mini_project.Coremodule.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_tax_bracket")
public class TaxBracketEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private String tax_bracket_name;
    private String description;
    private Float cofficient;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tax_bracket")
    private Collection<SectorsEntity> sectorsEntities;
}
