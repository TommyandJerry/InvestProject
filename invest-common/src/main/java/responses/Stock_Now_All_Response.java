package responses;

import com.invest.beans.Stock_Now_All_Vo;
import lombok.Data;

import java.util.List;

@Data
public class Stock_Now_All_Response extends BaseResponse{
    /*
       返回整个股市当前行情
     */
    private List<Stock_Now_All_Vo> data;
}
