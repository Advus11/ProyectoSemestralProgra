public class Cliente {
    private String nombre;
    private String apellido;
    private String numeroContacto;
    private String vehiculoAsociado;

    public Cliente(String nombre, String apellido, String numeroContacto, String vehiculoAsociado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroContacto = numeroContacto;
        this.vehiculoAsociado = vehiculoAsociado;
    }

    // Getters y setters para los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getVehiculoAsociado() {
        return vehiculoAsociado;
    }

    public void setVehiculoAsociado(String vehiculoAsociado) {
        this.vehiculoAsociado = vehiculoAsociado;
    }
}

