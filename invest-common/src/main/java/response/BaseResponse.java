package responses;

import lombok.Data;

@Data
public class BaseResponse {

    /*
    返回码。0代表调用成功，其他代表调用失败：
    101代表没有该用户；102代表签名错误；
    103代表AIP不存在；104代表调用太频繁；
    105代表请求并发数超过限制；110代表可调用次数不足；
    111代表请求IP不在白名单中；112代表当前账户余额为负或代表验证码扣费失败，请查看余额；
    113代表用户自定义退出；114代表没有返回数据；500代表其他错误类型，具体原因请看返回结果的错误原因。
     */
    private String error_code;

    /*
    返回说明，错误原因
     */
    private String reason;
}
