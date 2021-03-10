package com.mini_project.Coremodule.entity;

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
@Table(name = "tb_details_iexport")
public class DetailsI_exportEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_iexport")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    I_exportEntity id_iexport;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    CommodityEntity id_commodity;

    private String description;
    private Double quantity;
    private Double total;
}


