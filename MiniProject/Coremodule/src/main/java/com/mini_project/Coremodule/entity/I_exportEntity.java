package com.mini_project.Coremodule.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_iexport")
public class I_exportEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    private Date date;
    private int type;

    @OneToMany(
            mappedBy = "id_iexport",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<DocumentEntity> documentEntities;


    @OneToMany(
            mappedBy = "id_iexport",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    Collection<DetailsI_exportEntity> commodityEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private CountryEntity id_country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_warehouse", referencedColumnName = "id")
    private WarehouseEntity id_warehouse;


}
