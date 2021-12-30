package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_warehouse_commodity")
public class WareHouseCommodityEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column( name = "id_warehouse")
    @Type( type = "uuid-char")
    private UUID idWarehouse;

    @Column( name = "id_commodity")
    @Type( type = "uuid-char")
    private UUID idCommodity;

    @Column(name = "inventory_number")
    private double inventoryNumber;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "wareHouseEntity_id",nullable = false)
//    private WareHouseEntity wareHouseEntity;
//
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "commodityEntity_id",nullable = false)
//    private CommodityEntity commodityEntity;

}
