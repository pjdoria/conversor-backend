package site.peterdev.conversor.controller;

import org.springframework.web.bind.annotation.*;
import site.peterdev.conversor.service.PesoService;

@RestController
@RequestMapping("/api/peso")
public class PesoController {

    private final PesoService pesoService;

    public PesoController(PesoService pesoService) {
        this.pesoService = pesoService;
    }

    @GetMapping("/convertir")
    public double convertir(
            @RequestParam double valor,
            @RequestParam String desde,
            @RequestParam String hacia
    ) {
        return pesoService.convertir(valor, desde, hacia);
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
