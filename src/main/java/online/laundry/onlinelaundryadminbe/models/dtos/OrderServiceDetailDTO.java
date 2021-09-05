package online.laundry.onlinelaundryadminbe.models.dtos;

import com.laundy.laundrybackend.constant.ServiceDetailIconEnum;
import com.laundy.laundrybackend.models.OrderServiceDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderServiceDetailDTO {
    private Integer quantity;
    private String name;
    private String description;
    private ServiceDetailIconEnum serviceDetailIcon;
    private BigDecimal price;

    public static OrderServiceDetailDTO orderServiceDetailDTOFromOrderServiceDetail(OrderServiceDetail orderServiceDetail) {
        return OrderServiceDetailDTO.builder()
                .description(orderServiceDetail.getServiceDetail().getDescription())
                .name(orderServiceDetail.getServiceDetail().getName())
                .price(orderServiceDetail.getServiceDetail().getPrice())
                .quantity(orderServiceDetail.getQuantity())
                .serviceDetailIcon(orderServiceDetail.getServiceDetail().getServiceDetailIcon())
                .build();
    }

    public static List<OrderServiceDetailDTO> orderServiceDetailDTOSFromOrderServiceDetails(List<OrderServiceDetail> orderServiceDetails) {
        List<OrderServiceDetailDTO> detailDTOS = new ArrayList<>();
        for (OrderServiceDetail orderServiceDetail :
                orderServiceDetails) {
            detailDTOS.add(orderServiceDetailDTOFromOrderServiceDetail(orderServiceDetail));
        }
        return detailDTOS;
    }
}
