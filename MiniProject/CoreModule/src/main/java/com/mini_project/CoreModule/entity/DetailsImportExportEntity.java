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
@Table(name = "tb_details_import_export")
public class DetailsImportExportEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_import_export")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private ImportExportEntity importExportEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private CommodityEntity commodityEntity;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "total")
    private Double total;

}


