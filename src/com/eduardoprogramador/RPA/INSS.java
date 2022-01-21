/*
 *   Copyright 2021. Eduardo Programador
 *   www.eduardoprogramador.com
 *   consultoria@eduardoprogramador.com
 *
 *   Todos os direitos reservados.
 * */

package com.eduardoprogramador.RPA;

public class INSS {
    private String valor, porcentagem, baseLegal;

    public INSS(String valor, String porcentagem, String baseLegal) {
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
