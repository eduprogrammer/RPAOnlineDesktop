/*
 *   Copyright 2021. Eduardo Programador
 *   www.eduardoprogramador.com
 *   consultoria@eduardoprogramador.com
 *
 *   Todos os direitos reservados.
 * */

package com.eduardoprogramador.RPA;

public class ISS {
    private String valor, porcentagem, baseLegal;

    public ISS(String valor, String porcentagem, String baseLegal) {
        this.valor = valor;
        this.porcentagem = porcentagem;
        this.baseLegal = baseLegal;
    }

    public String getValor() {
        return valor;
    }

    public String getPorcentagem() {
        return porcentagem;
    }

    public String getBaseLegal() {
        return baseLegal;
    }
}
