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
@EqualsAndHashCode
@Data
@Builder
@Entity
@Table(name = "tb_tax_bracket")
public class TaxBracketEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "tax_bracket_name")
    private String taxBracketName;

    @Column(name = "description")
    private String description;

    @Column(name = "coefficient")
    private Float coefficient;

    /*@EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "taxBracketEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<TypeOfCommodityEntity> typeOfCommodities = new ArrayList<>();*/
}
