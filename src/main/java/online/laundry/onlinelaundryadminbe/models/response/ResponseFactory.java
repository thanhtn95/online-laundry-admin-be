package online.laundry.onlinelaundryadminbe.models.response;


import online.laundry.onlinelaundryadminbe.constant.ResponseStatusCodeEnum;

public class ResponseFactory {
    public static final GeneralResponse<Object> sucessRepsonse(Object data){
        return new GeneralResponse<>(ResponseStatusCodeEnum.SUCCESS.getCode(), data);
    }
}
