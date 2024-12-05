package es.unileon.prg2.patterns.strategy;

import java.util.Map;
import es.unileon.prg2.patterns.handler.*;

public class ProportionalStrategy implements ElectionStrategy {
    @Override
    public void calculateSeats(Map<Handler, Integer> votos, Map<Handler, Integer> escaños, int totalEscaños) {
        int totalVotos = votos.values().stream().mapToInt(Integer::intValue).sum();

        if (totalVotos == 0) {
            System.out.println("No hay votos para calcular los escaños.");
            return;
        }

        for (Handler partido : votos.keySet()) {
            int votosPartido = votos.get(partido);
            int escañosPartido = (int) Math.round((votosPartido * 1.0 / totalVotos) * totalEscaños);
            escaños.put(partido, escañosPartido);
        }
    }
}