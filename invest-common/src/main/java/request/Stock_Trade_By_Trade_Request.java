package request;

import lombok.Data;

@Data
public class Stock_Trade_By_Trade_Request {
    /*
        股票代码
     */
    String code;
    /*
        日期
     */
    String date;
}
