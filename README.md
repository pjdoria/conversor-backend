# Conversor de Unidades - Backend

Este es el backend de la aplicación web para convertir entre diferentes unidades de medida, desarrollado con **Java** y **Spring Boot**. Expone una API REST que permite realizar conversiones de longitud, peso y temperatura.

## 🚀 Tecnologías utilizadas

- [Java 17]
- [Spring Boot]
- [Maven]
- [Spring Web]

## 🎯 Funcionalidades

- Conversión de:
  - Longitud: milímetro, centímetro, metro, kilómetro, pulgada, pie, yarda, milla
  - Peso: miligramo, gramo, kilogramo, onza, libra
  - Temperatura: Celsius, Fahrenheit, Kelvin
- Endpoints REST para cada tipo de conversión
- Permite el consumo desde el frontend vía CORS


## 📡 Endpoints disponibles
GET /api/longitud?valor=10&from=m&to=km

GET /api/peso?valor=500&from=g&to=kg

GET /api/temperatura?valor=32&from=celsius&to=fahrenheit

## 🌐 CORS
El backend está configurado para permitir peticiones desde http://localhost:5173 (frontend React con Vite).

##🔗 Proyecto relacionado
👉 Frontend del conversor (React)
