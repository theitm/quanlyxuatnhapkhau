package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_import_export")
public class ImportExportEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
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
    @JsonIgnore
    private Collection<DocumentEntity> documentEntities
            = new ArrayList<DocumentEntity>();

    @OneToMany(
            mappedBy = "importExportEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<DetailsImportExportEntity> detailsImportExportEntities
            = new ArrayList<DetailsImportExportEntity>() ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_country", referencedColumnName = "id",
            insertable = false,updatable = false)
    private CountryEntity countryEntity;

    @Column( name = "id_country")
    @Type( type = "uuid-char")
    private UUID idCountry;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_warehouse", referencedColumnName = "id",
            insertable = false,updatable = false)
    private WarehouseEntity warehouseEntity;

    @Column( name = "id_warehouse")
    @Type( type = "uuid-char")
    private UUID idWarehouse;


}
