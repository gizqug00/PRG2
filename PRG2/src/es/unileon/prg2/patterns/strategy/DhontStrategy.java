package es.unileon.prg2.patterns.strategy;

import java.util.HashMap;
import java.util.Map;
import es.unileon.prg2.patterns.handler.*;

public class DhontStrategy implements ElectionStrategy {
    @Override
    public void calculateSeats(Map<Handler, Integer> votos, Map<Handler, Integer> escaños, int totalEscaños) {
        Map<Handler, Integer> votosOriginales = new HashMap<>(votos);

        for (Handler partido : votos.keySet()) {
            escaños.put(partido, 0);
        }

        for (int i = 0; i < totalEscaños; i++) {
            Handler ganador = null;
            int maxVotos = 0;

            for (Handler partido : votosOriginales.keySet()) {
                int votosActuales = votosOriginales.get(partido);
                if (votosActuales > maxVotos) {
                    maxVotos = votosActuales;
                    ganador = partido;
                }
            }

            if (ganador != null) {
                escaños.put(ganador, escaños.get(ganador) + 1);
                int divisor = escaños.get(ganador) + 1;
                votosOriginales.put(ganador, votos.get(ganador) / divisor);
            }
        }
    }
}
