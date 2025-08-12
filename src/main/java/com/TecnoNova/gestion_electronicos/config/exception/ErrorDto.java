package com.TecnoNova.gestion_electronicos.config.exception;

import java.time.LocalTime;

public record ErrorDto(
        String mensaje,
        LocalTime fechaError
) {
}
