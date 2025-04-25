package site.peterdev.conversor.service;

import org.springframework.stereotype.Service;

@Service
public class PesoService {

    public double convertir(double valor, String desde, String hacia) {
        double valorEnGramos = convertirAGramos(valor, desde);
        return convertirDesdeGramos(valorEnGramos, hacia);
    }

    private double convertirAGramos(double valor, String unidad) {
        return switch (unidad.toLowerCase()) {
            case "mg" -> valor / 1000;
            case "g" -> valor;
            case "kg" -> valor * 1000;
            case "oz" -> valor * 28.3495;
            case "lb" -> valor * 453.592;
            default -> throw new IllegalArgumentException("Unidad no válida: " + unidad);
        };
    }

    private double convertirDesdeGramos(double valor, String unidad) {
        return switch (unidad.toLowerCase()) {
            case "mg" -> valor * 1000;
            case "g" -> valor;
            case "kg" -> valor / 1000;
            case "oz" -> valor / 28.3495;
            case "lb" -> valor / 453.592;
            default -> throw new IllegalArgumentException("Unidad no válida: " + unidad);
        };
    }
}
