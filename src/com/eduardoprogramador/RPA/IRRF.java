/*
 *   Copyright 2021. Eduardo Programador
 *   www.eduardoprogramador.com
 *   consultoria@eduardoprogramador.com
 *
 *   Todos os direitos reservados.
 * */

package com.eduardoprogramador.RPA;

public class IRRF {

    private String valor, porcentagem, baseLegal;
    private String baseCalculo, aliquotaRir, aliquotaRirValor;
    private String deducaoDependentes, deducaoRir;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public String getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(String baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    public String getAliquotaRir() {
        return aliquotaRir;
    }

    public void setAliquotaRir(String aliquotaRir) {
        this.aliquotaRir = aliquotaRir;
    }

    public String getAliquotaRirValor() {
        return aliquotaRirValor;
    }

    public void setAliquotaRirValor(String aliquotaRirValor) {
        this.aliquotaRirValor = aliquotaRirValor;
    }

    public String getDeducaoDependentes() {
        return deducaoDependentes;
    }

    public void setDeducaoDependentes(String deducaoDependentes) {
        this.deducaoDependentes = deducaoDependentes;
    }

    public String getDeducaoRir() {
        return deducaoRir;
    }

    public void setDeducaoRir(String deducaoRir) {
        this.deducaoRir = deducaoRir;
    }
}
