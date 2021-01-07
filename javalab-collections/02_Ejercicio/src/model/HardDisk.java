package model;

import java.io.Serializable;
import java.text.*;
import java.util.*;

public class HardDisk implements Serializable {

    private String fabricante;
    private float megabytes;
    private String modelo;
    private String numeroDeSerie;
    private int tasaDeTransmision;
    private String tecnologia;
    private String tipoDeInterface;
    private int velocidadDeRotacion;

    public static final String[] FABRICANTES = {
        "Seagate", "Western Digital", "Intel", "Samsung", "Toshiba", "Crucial"
    };

    public static final String[] MODELOS = {
        "7200.14", "7200.12", "7200.15", "Momentus"
    };

    public static final String[] TECNOLOGIAS = {
        "HD", "SSD", "SSHD", "DVD", "BLUE RAY"
    };

    public static final float[] CAPACIDADES = {
        640.0f, 1024.0f, 2048.0f
    };

    public static final int[] VELOCIDADESDEROTACION = {
        5400, 7200, 15000
    };

    public static final int[] TASASTRANSMISION = {
        110, 180, 220, 380, 600
    };

    public static final String[] TIPOSDEINTERFACE = {
        "SATA3", "SATA6", "PATA", "SCSI"
    };

    public static final String[] NUMEROSDESERIE = {
        "a123", "b2432342343", "c2342342", "x2342344444"
    };

    public static final Locale SPANISH = new Locale("es", "ES");
    public static final NumberFormat NF = NumberFormat.getInstance(SPANISH);

    public HardDisk(String fabricante, float megabytes, String modelo, String numeroDeSerie, int tasaDeTransmision,
            String tecnologia, String tipoDeInterface, int velocidadDeRotacion) {
        this.fabricante = fabricante;
        this.megabytes = megabytes;
        this.modelo = modelo;
        this.numeroDeSerie = numeroDeSerie;
        this.tasaDeTransmision = tasaDeTransmision;
        this.tecnologia = tecnologia;
        this.tipoDeInterface = tipoDeInterface;
        this.velocidadDeRotacion = velocidadDeRotacion;
    }

    public static HardDisk instanceWithRandomAttributes() {
        Random r = new Random();
        HardDisk h = new HardDisk(
                FABRICANTES[r.nextInt(FABRICANTES.length)],
                CAPACIDADES[r.nextInt(CAPACIDADES.length)],
                MODELOS[r.nextInt(MODELOS.length)],
                NUMEROSDESERIE[r.nextInt(NUMEROSDESERIE.length)],
                TASASTRANSMISION[r.nextInt(TASASTRANSMISION.length)],
                TECNOLOGIAS[r.nextInt(TECNOLOGIAS.length)],
                TIPOSDEINTERFACE[r.nextInt(TIPOSDEINTERFACE.length)],
                VELOCIDADESDEROTACION[r.nextInt(VELOCIDADESDEROTACION.length)]);

        return h;
    }

    public String exportStateWithDelimiters(String del) {
        String resultado;
        var actualLocale = Locale.getDefault();
        resultado = String.format(actualLocale,
                "%s"
                + "%s"
                + "%6.1f"
                + "%s"
                + "%s"
                + "%s"
                + "%s"
                + "%s"
                + "%d"
                + "%s"
                + "%s"
                + "%s"
                + "%s"
                + "%s"
                + "%d", this.fabricante, del, this.megabytes, del, this.modelo, del, this.numeroDeSerie, del,
                this.tasaDeTransmision, del, this.tecnologia, del, this.tipoDeInterface, del, this.velocidadDeRotacion);
        return resultado;
    }

    public static HardDisk factory(String line, String delimiter) {
        String[] f = line.split(delimiter);
        return factory(f);
    }

    public static HardDisk factory(String[] f) {
        if (f.length != 8) {
            return null;
        }

        HardDisk hd;
        float frag1;
        int frag4, frag7;
        var locale = Locale.getDefault();
        NumberFormat nf = NumberFormat.getInstance(locale);

        try {
            frag1 = nf.parse(f[1].trim()).floatValue();
            frag4 = nf.parse(f[4].trim()).intValue();
            frag7 = nf.parse(f[7].trim()).intValue();
        } catch (ParseException ex) {
            System.err.printf("%nERROR: %s%n", ex.toString());
            return null;
        }

        hd = new HardDisk(f[0], frag1, f[2], f[3], frag4, f[5], f[6], frag7);

        return hd;
    }

    public static String stateAsPrintedStringTable(HardDisk[] lista) {
        StringBuilder sb = new StringBuilder();
        String separador = "+------------------"
                + "+--------"
                + "+-----------------"
                + "+-----------------"
                + "+--------"
                + "+-----------------"
                + "+-----------------"
                + "+-------+%n";

        for (HardDisk d : lista) {
            sb.append(separador);
            sb.append(d.stateAsColumns());
        }

        sb.append(separador);
        return sb.toString();
    }

    String stateAsColumns() {
        return String.format("| %-15s | %6.1f | %15s | %15s | %6d | %15s | %15s | %5d |",
                this.fabricante, this.megabytes, this.modelo, this.numeroDeSerie, this.tasaDeTransmision,
                this.tecnologia, this.tipoDeInterface, this.velocidadDeRotacion);
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getMegabytes() {
        return megabytes;
    }

    public void setMegabytes(float megabytes) {
        this.megabytes = megabytes;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public int getTasaDeTransmision() {
        return tasaDeTransmision;
    }

    public void setTasaDeTransmision(int tasaDeTransmision) {
        this.tasaDeTransmision = tasaDeTransmision;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getTipoDeInterface() {
        return tipoDeInterface;
    }

    public void setTipoDeInterface(String tipoDeInterface) {
        this.tipoDeInterface = tipoDeInterface;
    }

    public int getVelocidadDeRotacion() {
        return velocidadDeRotacion;
    }

    public void setVelocidadDeRotacion(int velocidadDeRotacion) {
        this.velocidadDeRotacion = velocidadDeRotacion;
    }
} /* End of HardDisk */
