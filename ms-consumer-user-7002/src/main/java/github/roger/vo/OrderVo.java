package github.roger.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
public class OrderVo {
    private Integer id;
    private BigDecimal orderMoney;
    private Date dateCreated;
    private String dataSource;
}
