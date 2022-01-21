/*
 *   Copyright 2021. Eduardo Programador
 *   www.eduardoprogramador.com
 *   consultoria@eduardoprogramador.com
 *
 *   Todos os direitos reservados.
 * */

package com.eduardoprogramador.RPA;

public interface RPAListenner {
    public void onResultAvailable(ISS iss, INSS inss, IRRF irrf, Statistics statistics);

    public void onWaitStart();

    public void onWaitEnd();
}
