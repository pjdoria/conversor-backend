package site.peterdev.conversor.controller;

import org.springframework.web.bind.annotation.*;

import site.peterdev.conversor.service.LongitudService;
import site.peterdev.conversor.service.TemperaturaService;

@RestController
@RequestMapping("/api/temperatura")
public class TemperaturaController {

    private final TemperaturaService temperaturaService;

    public TemperaturaController(TemperaturaService temperaturaService) {
        this.temperaturaService = temperaturaService;
    }
    
    @GetMapping("/convertir")
    public double convertir(
            @RequestParam double valor,
            @RequestParam String desde,
            @RequestParam String hacia
    ) {
        if (desde.equalsIgnoreCase(hacia)) return temperaturaService.convertir(valor, desde, hacia);

        return switch (desde.toLowerCase()) {
            case "c" -> desdeCelsius(valor, hacia);
            case "f" -> desdeFahrenheit(valor, hacia);
            case "k" -> desdeKelvin(valor, hacia);
            default -> throw new IllegalArgumentException("Unidad no válida: " + desde);
        };
    }

    private double desdeCelsius(double valor, String hacia) {
        return switch (hacia.toLowerCase()) {
            case "f" -> valor * 9/5 + 32;
            case "k" -> valor + 273.15;
            default -> throw new IllegalArgumentException("Unidad no válida: " + hacia);
        };
    }

    private double desdeFahrenheit(double valor, String hacia) {
        return switch (hacia.toLowerCase()) {
            case "c" -> (valor - 32) * 5/9;
            case "k" -> (valor - 32) * 5/9 + 273.15;
            default -> throw new IllegalArgumentException("Unidad no válida: " + hacia);
        };
    }

    private double desdeKelvin(double valor, String hacia) {
        return switch (hacia.toLowerCase()) {
            case "c" -> valor - 273.15;
            case "f" -> (valor - 273.15) * 9/5 + 32;
            default -> throw new IllegalArgumentException("Unidad no válida: " + hacia);
        };
    }
}