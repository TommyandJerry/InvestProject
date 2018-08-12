package beans;

import lombok.Data;

@Data
public class Stock_Now_All_Vo {

    /*
        股票代码
     */
    private String code;

    /*
        中文名称
     */
    private String name;
    /*
        涨跌幅
     */
    private String changepercent;
    /*
        现价
     */
    private String trade;
    /*
        开盘价
     */
    private String open;
    /*
        最高价
     */
    private String high;
    /*
        最低价
     */
    private String low;
    /*
        昨日收盘价
     */
    private String settlement;
    /*
        成交量
     */
    private String volume;
    /*
        换手率
     */
    private String turnoverratio;
    /*
        成交额
     */
    private String amount;
    /*
        市净率
     */
    private String pb;
    /*
        总市值
     */
    private String mktcap;
    /*
        流通市值
     */
    private String nmc;
}
