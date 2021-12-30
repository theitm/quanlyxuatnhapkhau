package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "tb_commodity")
public class CommodityEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_type_of_commodity")
    @Type( type = "uuid-char")
    private UUID idTypeOfCommodity;

    @Column(name = "commodity_name")
    private String commodityName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @Column(name = "unit")
    private String unit;



   /* @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commodityEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<WareHouseCommodityEntity> wareHouseCommodityEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commodityEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DetailsImportExportEntity> detailsImportExportEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional=false)
    @JoinColumn(name = "typeOfCommodityEntity_id",nullable = false)
    private TypeOfCommodityEntity typeOfCommodityEntity;*/
}

