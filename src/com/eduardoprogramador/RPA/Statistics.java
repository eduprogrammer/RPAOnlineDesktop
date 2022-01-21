/*
 *   Copyright 2021. Eduardo Programador
 *   www.eduardoprogramador.com
 *   consultoria@eduardoprogramador.com
 *
 *   Todos os direitos reservados.
 * */

package com.eduardoprogramador.RPA;

public class Statistics {
    private String valorPagar, cppInss, custoPj, totalImposto;

    public String getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(String valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getCppInss() {
        return cppInss;
    }

    public void setCppInss(String cppInss) {
        this.cppInss = cppInss;
    }

    public String getCustoPj() {
        return custoPj;
    }

    public void setCustoPj(String custoPj) {
        this.custoPj = custoPj;
    }

    public void setTotalImposto(String imposto) {
        this.totalImposto = imposto;
    }

    public String getTotalImposto() {
        return this.totalImposto;
    }
}
