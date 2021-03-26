package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tb_details_import_export")
public class DetailsImportExportEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_import_export",insertable = false,updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private ImportExportEntity importExportEntity;

    @Column( name = "id_import_export")
    @Type( type = "uuid-char")
    private UUID idImportExport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity" ,insertable = false,updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private CommodityEntity commodityEntity;

    @Column( name = "id_commodity")
    @Type( type = "uuid-char")
    private UUID idCommodity;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "total")
    private Double total;

    @Column(name = "ref_id_export")
    @Type(type = "uuid-char")
    private UUID refIdExport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ref_id_export" ,insertable = false,updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private DetailsImportExportEntity detailsImportExportEntity;

    @OneToMany(
            mappedBy = "detailsImportExportEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<DetailsImportExportEntity> detailsImportExportEntities
            = new ArrayList<DetailsImportExportEntity>();



}


