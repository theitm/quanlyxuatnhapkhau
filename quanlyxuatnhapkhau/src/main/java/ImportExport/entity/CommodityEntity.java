package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
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
public class CommodityEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    public UUID id;
    public String idTypeOfCommodity;
    public String commodityName;
    public float price;
    public String unit;
    public String description;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commodityEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<WareHouseCommodityEntity> wareHouseCommodityEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "commodityEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<DetailsImportExportEntity> detailsImportExportEntities = new ArrayList<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(optional=false)
    @JoinColumn(name = "typeOfCommodityEntity_id",nullable = false)
    private TypeOfCommodityEntity typeOfCommodityEntity;
}

