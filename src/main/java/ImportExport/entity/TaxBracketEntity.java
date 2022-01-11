package ImportExport.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "tb_tax_bracket")

public class TaxBracketEntity  {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;
    @Column(name = "tax_bracket_name")
    private String taxBracketName;
    private String description;
    private Float coefficient;
    @OneToMany(mappedBy = "taxBracketEntity",cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<TypeOfCommodityEntity> typeOfCommodityEntities
            =new ArrayList<TypeOfCommodityEntity>();

}