package pot_java.dao.domain;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Stock {
    private String symbol;
    private float price;
    private String companyName;
    private String confirmationNumber;

    public Stock() {}

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }
}
