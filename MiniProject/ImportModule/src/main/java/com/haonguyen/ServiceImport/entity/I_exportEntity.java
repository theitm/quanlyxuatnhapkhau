package com.haonguyen.ServiceImport.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@Table(name = "tb_iexport")
public class I_exportEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id_iexport", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID idIexport;
    private String idCountry;
    private String idWarehouse;
    private Date dateReceipt;
    private int type;

    @OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "id_iexport")
    private Collection<DocumentEntity> documentEntities;


    @OneToMany(
            mappedBy = "idI_Export",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    Collection<DetailsI_exportEntity> commodityEntities;

}
