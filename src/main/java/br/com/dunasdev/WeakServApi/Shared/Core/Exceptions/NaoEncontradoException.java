package br.com.dunasdev.WeakServApi.Shared.Core.Exceptions;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String message) {
        super(message);
    }
}