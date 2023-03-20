package pl.s221516.creditcard;

import org.junit.jupiter.api.Test;

public class NumericalRepresentationTest {

    @Test
    void lestCheckDouble() {
            double a = 0.001;
            double b = 0.003;
            double c = b - a;
            System.out.println(c);
        }

    @Test
    void lestCheckFloats() {
        float a = 0.003f;
        float b = 0.001f;
        float c = b - a;
        System.out.println(c);
    }
}
