package br.com.dunasdev.WeakServApi.Shared.Core.Exceptions;

import java.time.LocalDateTime;

public record RecErroPadrao(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path
) {
}