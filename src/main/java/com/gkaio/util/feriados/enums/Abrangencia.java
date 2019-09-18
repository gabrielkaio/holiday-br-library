package com.gkaio.util.feriados.enums;

public enum Abrangencia {
    NACIONAL("Nacional"), MUNICIPAL("Municipal"), ESTADUAL("Estadual");

    private String tipo;

    Abrangencia(String tipo) {
        this.tipo = tipo;
    }

    public static Abrangencia getTipo(String tipo) {
        for (Abrangencia t : Abrangencia.values()) {
            if (t.toString().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
