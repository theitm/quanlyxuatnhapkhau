package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(name = "tax_bracket_name")
    private String taxBracketName;

    @Column(name = "description")
    private String description;

    @Column(name = "coefficient")
    private Float coefficient;

    @OneToMany( cascade = CascadeType.ALL,
            mappedBy = "taxBracketEntity"
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<TypeOfCommodityEntity> typeOfCommodityEntities
            = new ArrayList<TypeOfCommodityEntity>();
}
