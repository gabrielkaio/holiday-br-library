package com.gkaio.util.feriados.enums;

public enum Local {
    RJ("RJ"), SP("SP"), BRASIL("Brasil");

    private String sigla;

    Local(String sigla) {
        this.sigla = sigla;
    }

    public static Local getTipo(String sigla) {
        for (Local e : Local.values()) {
            if (e.toString().equalsIgnoreCase(sigla)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return sigla;
    }


}
