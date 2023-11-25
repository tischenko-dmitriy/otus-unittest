package otus.study.cashmachine.webserver.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {

    @JsonProperty(value = "accountId")
    private Long accountId;

    @JsonProperty(value = "number")
    private String number;

    @JsonProperty(value = "pinCode")
    private String pinCode;

}
