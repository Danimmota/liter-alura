package com.challenge.liter_alura.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
