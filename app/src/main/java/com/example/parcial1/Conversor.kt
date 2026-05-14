package com.example.parcial1

class Conversor {
    private val tasas: Map<String, Map<String, Double>> = mapOf(

        "USD" to mapOf(
            "USD" to 1.0,
            "EUR" to 0.8564,
            "PAB" to 1.0,
            "COP" to 3793.0,
            "CRC" to 455.59,
            "MXN" to 17.93
        ),

        "EUR" to mapOf(
            "USD" to 1.1677,
            "EUR" to 1.0,
            "PAB" to 1.1677,
            "COP" to 4430.0,
            "CRC" to 532.10,
            "MXN" to 20.94
        ),

        "PAB" to mapOf(
            "USD" to 1.0,
            "EUR" to 0.8564,
            "PAB" to 1.0,
            "COP" to 3793.0,
            "CRC" to 455.59,
            "MXN" to 17.93
        ),

        "COP" to mapOf(
            "USD" to 0.0002636,
            "EUR" to 0.0002257,
            "PAB" to 0.0002636,
            "COP" to 1.0,
            "CRC" to 0.1201,
            "MXN" to 0.004727
        ),

        "CRC" to mapOf(
            "USD" to 0.002195,
            "EUR" to 0.001880,
            "PAB" to 0.002195,
            "COP" to 8.326,
            "CRC" to 1.0,
            "MXN" to 0.03935
        ),

        "MXN" to mapOf(
            "USD" to 0.05578,
            "EUR" to 0.04777,
            "PAB" to 0.05578,
            "COP" to 211.55,
            "CRC" to 25.41,
            "MXN" to 1.0
        )
    )

    fun convertir(monedaOrigen: String, monedaDestino: String, cantidad: Double): Double {
        //Validar que las cantidades cumplan las reglas del software
        if(cantidad <= 0){
            throw IllegalArgumentException("La cantidad debe ser mayor a 0")
        }


        val mapaOrigen = tasas[monedaOrigen]
            ?: throw IllegalArgumentException("Moneda origen no soportada: $monedaOrigen")

        val tasa = mapaOrigen[monedaDestino]
            ?: throw IllegalArgumentException("Moneda destino no soportada: $monedaDestino")


        return cantidad * tasa
    }

}