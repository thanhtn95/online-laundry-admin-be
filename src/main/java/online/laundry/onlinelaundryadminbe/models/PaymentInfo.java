package online.laundry.onlinelaundryadminbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laundy.laundrybackend.models.request.OrderPaymentForm;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "payment_info")
public class PaymentInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String partnerCode;

    @NotNull
    @NotBlank
    private String requestId;

    @NotNull
    @NotBlank
    private String hash;

    @NotNull
    private Double version;

    @JsonIgnore
    @OneToOne(mappedBy = "paymentInfo")
    private Order order;

    public static PaymentInfo paymentInfoFromOrderPaymentForm(OrderPaymentForm orderPaymentForm){
        return PaymentInfo.builder()
                .hash(orderPaymentForm.getHash())
                .partnerCode(orderPaymentForm.getPartnerCode())
                .requestId(orderPaymentForm.getRequestId())
                .version(orderPaymentForm.getVersion())
                .build();
    }
}
