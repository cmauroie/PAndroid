package com.example.pruebas_android.pruebastest;

import java.util.List;

/**
 * Created by Pruebas-Android on 15/02/2018.
 */

public class ModelDataResponse {

    private List<Location> lstCordenadasServicio;
    private String error;
    private String msjError;
    private List<String> recorrido;

    public List<Location> getLstCordenadasServicio() {
        return lstCordenadasServicio;
    }

    public void setLstCordenadasServicio(List<Location> lstCordenadasServicio) {
        this.lstCordenadasServicio = lstCordenadasServicio;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsjError() {
        return msjError;
    }

    public void setMsjError(String msjError) {
        this.msjError = msjError;
    }

    public List<String> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(List<String> recorrido) {
        this.recorrido = recorrido;
    }

}
