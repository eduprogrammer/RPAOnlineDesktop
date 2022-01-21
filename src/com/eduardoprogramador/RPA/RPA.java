/*
 *   Copyright 2021. Eduardo Programador
 *   www.eduardoprogramador.com
 *   consultoria@eduardoprogramador.com
 *
 *   Todos os direitos reservados.
 * */

package com.eduardoprogramador.RPA;

import org.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class RPA {

    private static RPA rpa;
    private ISS iss_;
    private INSS inss;
    private IRRF irrf;
    private Statistics statistics;
    private RPAListenner rpaListenner;
    private String path;

    private RPA(){}

    public static RPA getInstance() {
        rpa = new RPA();
        return rpa;
    }

    public void initializes(String iss, String prefeitura, String dependentes,
                               String valor, String valorJaRecebido) {

        if(rpaListenner != null)
            rpaListenner.onWaitStart();

        path = "https://eduardoprogramador.com/php/rpa_api.php?";
        path += "iss=" + iss + "&prefeitura=" + prefeitura + "&dependentes=" + dependentes +
                "&valor=" + valor + "&recebido=" + valorJaRecebido;

        new Thread(new Runnable() {
            @Override
            public void run() {

                StringBuilder stringBuilder = new StringBuilder();

                try {
                    URL url = new URL(path);
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line = null;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    bufferedReader.close();
                    connection.disconnect();

                    JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                    iss_ = new ISS(jsonObject.getString("iss_valor"), jsonObject.getString("iss_perc"),
                            jsonObject.getString("iss_legal"));
                    inss = new INSS(jsonObject.getString("inss_valor"),jsonObject.getString("inss_perc"),
                            jsonObject.getString("inss_legal"));

                    irrf = new IRRF();

                    irrf.setValor(jsonObject.getString("irrf_valor"));
                    irrf.setPorcentagem(jsonObject.getString("irrf_perc"));
                    irrf.setBaseLegal(jsonObject.getString("irrf_legal"));
                    irrf.setBaseCalculo(jsonObject.getString("base_irrf"));
                    irrf.setAliquotaRir(jsonObject.getString("aliquota_rir"));
                    irrf.setAliquotaRirValor(jsonObject.getString("aliquota_rir_valor"));
                    irrf.setDeducaoDependentes(jsonObject.getString("deducao_dependentes"));
                    irrf.setDeducaoRir(jsonObject.getString("deducao_rir"));

                    statistics = new Statistics();

                    statistics.setValorPagar(jsonObject.getString("valor_a_pagar"));
                    statistics.setCppInss(jsonObject.getString("cpp_inss"));
                    statistics.setCustoPj(jsonObject.getString("custo_pj"));
                    statistics.setTotalImposto(jsonObject.getString("impostos_perc"));

                    if(rpaListenner != null) {
                        rpaListenner.onResultAvailable(iss_, inss, irrf, statistics);
                        rpaListenner.onWaitEnd();
                    }

                    path = null;

                } catch (Exception ex) {
                    iss_ = null;
                    inss = null;
                    irrf = null;
                    statistics = null;
                    path = null;

                    if(rpaListenner != null)
                        rpaListenner.onWaitEnd();
                }


            }
        }).start();

    }

    public void setOnRPAListenner(RPAListenner rpaListenner) {
        this.rpaListenner = rpaListenner;
    }

}
