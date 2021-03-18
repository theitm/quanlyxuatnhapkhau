package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_embargo")
public class EmbargoEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "description")
    private String description;

    @Column(name = "activate")
    private Integer activate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_of_commodity",insertable = false , updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private TypeOfCommodityEntity typeOfCommodityEntity;

    @Column( name = "id_type_of_commodity")
    @Type( type = "uuid-char")
    private UUID idTypeOfCommodity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country",insertable = false , updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private CountryEntity countryEntity;

    @Column( name = "id_country")
    @Type( type = "uuid-char")
    private UUID idCountry;


}
