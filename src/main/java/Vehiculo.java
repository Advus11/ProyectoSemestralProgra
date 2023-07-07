public class Vehiculo {
    private String patente;
    private String color;
    private String marca;
    private String posicionEstacionamiento;
    private String horaLlegada;
    private int minutoLlegada;

    public Vehiculo(String patente, String color, String marca, String posicionEstacionamiento, String horaLlegada, int minutoLlegada) {
        this.patente = patente;
        this.color = color;
        this.marca = marca;
        this.posicionEstacionamiento = posicionEstacionamiento;
        this.horaLlegada = horaLlegada;
        this.minutoLlegada = minutoLlegada;
    }

    // Getters y setters para los atributos

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPosicionEstacionamiento() {
        return posicionEstacionamiento;
    }

    public void setPosicionEstacionamiento(String posicionEstacionamiento) {
        this.posicionEstacionamiento = posicionEstacionamiento;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getMinutoLlegada() {
        return minutoLlegada;
    }

    public void setMinutoLlegada(int minutoLlegada) {
        this.minutoLlegada = minutoLlegada;
    }
}

