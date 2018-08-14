package beans;

import lombok.Data;

@Data
public class Stock_Trade_By_Trade {
    /*
        成交额(元)
     */
    private String amount;
    /*
        价格变动
     */
    private String change;
    /*
        成交价格
     */
    private String price;
    /*
        成交时间
     */
    private String time;
    /*
        性质--买盘/卖盘/中性盘
     */
    private String type;
    /*
        成交量(手)
     */
    private String volume;
}
