package lessons.lessons6;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Passenger {

    private String fullName;
    private boolean paymentDone;  // Whether payment was made

    public Passenger(String fullName) {
        this.fullName = fullName;
        this.paymentDone = false;
    }

    @Override
    public String toString() {
        return "Passenger: " + fullName + (paymentDone ? " [Paid]" : " [Not paid]");
    }
}
