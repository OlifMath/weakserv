package br.com.dunasdev.WeakServApi.Shared.Exceptions;

public class NaoEncontradoException extends RuntimeException {
    public NaoEncontradoException(String message) {
        super(message);
    }
}