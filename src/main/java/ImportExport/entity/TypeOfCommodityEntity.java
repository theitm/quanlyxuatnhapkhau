package ImportExport.entity;
//
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Type;
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.UUID;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
//@Entity
//@Table(name = "tb_type_of_commodity")
//
//public class TypeOfCommodityEntity {
//    @Id
//    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Column(name = "id", columnDefinition = "CHAR(36)")
//    @Type(type = "uuid-char")
//    private UUID id;
//    @Column(name="id_tax_Bracket")
//    private String idTaxBracket;
//    @Column(name="type_of_commodity_name")
//    private String typeOfCommodityName;
//    private String description;
//    @OneToMany(mappedBy = "typeOfCommodityEntity",cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<CommodityEntity> commodityEntities
//            =new ArrayList<CommodityEntity>();
//    @ManyToOne
//    @JoinColumn (name = "id_tax_bracket",insertable = false,updatable = false)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private TaxBracketEntity taxBracketEntity;
//    @OneToMany(mappedBy = "typeOfCommodityEntity",cascade = CascadeType.ALL)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<EmbargoEntity> embargoEntities
//            =new ArrayList<EmbargoEntity>();
//
//}


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
@Table(name = "tb_type_of_commodity")
public class TypeOfCommodityEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "type_of_commodity_name")
    private String typeOfCommodityName;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "typeOfCommodityEntity"
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<CommodityEntity> commodityEntities
            = new ArrayList<CommodityEntity>();

    @OneToMany(cascade =CascadeType.ALL,
            mappedBy = "typeOfCommodityEntity"
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<EmbargoEntity> embargoEntity
            = new ArrayList<EmbargoEntity>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tax_bracket",insertable = false , updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private TaxBracketEntity taxBracketEntity;

    @Column( name = "id_tax_bracket")
    @Type( type = "uuid-char")
    private UUID idTaxBracket;


}
