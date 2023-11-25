package otus.study.cashmachine.webserver.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoneyDto {

    @JsonProperty(value = "number")
    private String number;

    @JsonProperty(value = "pin")
    private String pin;

    @JsonProperty(value = "money")
    private BigDecimal sum;

}
