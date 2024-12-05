package es.unileon.prg2.patterns.strategy;

import es.unileon.prg2.patterns.handler.*;
import java.util.Map;

public class DefaultStrategy implements ElectionStrategy {
    @Override
    public void calculateSeats(Map<Handler, Integer> votos, Map<Handler, Integer> escaños, int totalEscaños) {
        for (Handler partido : votos.keySet()) {
            escaños.put(partido, 0);
        }
    }
}

