package es.unileon.prg2.patterns.strategy;

import java.util.Map;
import es.unileon.prg2.patterns.handler.*;

public interface ElectionStrategy {
    void calculateSeats(Map<Handler, Integer> votos, Map<Handler, Integer> escaños, int totalEscaños);
}

