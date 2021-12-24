package ImportExport.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_commodity")
public class Commodity {
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

    @OneToMany(mappedBy = "commodities")
    public List<WareHouseCommodityEntity> wareHouseCommodityEntities;

    @OneToMany(mappedBy = "commodities")
    public List<DetailsImportExport> detailsImportExports;

    @OneToMany
    private List<TypeOfCommodity> typeOfCommodities;
}

