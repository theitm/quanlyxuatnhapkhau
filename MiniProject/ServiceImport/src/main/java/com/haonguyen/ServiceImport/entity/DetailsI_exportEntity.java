package com.haonguyen.ServiceImport.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_details_iexport")
public class DetailsI_exportEntity {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long STT;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_iexport")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    I_exportEntity idI_Export;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    CommodityEntity idCommodity;

    private String description;
    private Double quantity;
    private Double total;
}


