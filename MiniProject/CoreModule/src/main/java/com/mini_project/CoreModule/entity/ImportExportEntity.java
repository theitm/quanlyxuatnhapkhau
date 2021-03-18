package com.mini_project.CoreModule.entity;

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
public class ImportExportEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "date")
    private Date date;
    @Column(name = "type")
    private int type;

    @OneToMany(
            mappedBy = "importExportEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Collection<DocumentEntity> documentEntities;

    @OneToMany(
            mappedBy = "importExportEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Collection<DetailsImportExportEntity> detailsImportExportEntities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_country", referencedColumnName = "id")
    private CountryEntity countryEntity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_warehouse", referencedColumnName = "id")
    private WarehouseEntity warehouseEntity;


}
