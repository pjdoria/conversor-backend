package site.peterdev.conversor.controller;

import org.springframework.web.bind.annotation.*;

import site.peterdev.conversor.service.LongitudService;

@RestController
@RequestMapping("/api/longitud")
public class LongitudController {

    private final LongitudService longitudService;

    public LongitudController(LongitudService longitudService) {
        this.longitudService = longitudService;
    }

    @GetMapping("/convertir")
    public double convertir(
            @RequestParam double valor,
            @RequestParam String desde,
            @RequestParam String hacia
    ) {
        return longitudService.convertir(valor, desde, hacia);
    }

    private double convertirAMetros(double valor, String unidad) {
        return switch (unidad.toLowerCase()) {
            case "mm" -> valor / 1000;
            case "cm" -> valor / 100;
            case "m" -> valor;
            case "km" -> valor * 1000;
            case "in" -> valor * 0.0254;
            case "ft" -> valor * 0.3048;
            case "yd" -> valor * 0.9144;
            case "mi" -> valor * 1609.34;
            default -> throw new IllegalArgumentException("Unidad no válida: " + unidad);
        };
    }

    private double convertirDesdeMetros(double valor, String unidad) {
        return switch (unidad.toLowerCase()) {
            case "mm" -> valor * 1000;
            case "cm" -> valor * 100;
            case "m" -> valor;
            case "km" -> valor / 1000;
            case "in" -> valor / 0.0254;
            case "ft" -> valor / 0.3048;
            case "yd" -> valor / 0.9144;
            case "mi" -> valor / 1609.34;
            default -> throw new IllegalArgumentException("Unidad no válida: " + unidad);
        };
    }
}
