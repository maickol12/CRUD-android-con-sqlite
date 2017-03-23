package BSHELPER;


public class Usuarios {
    private int idusuario,edad;
    private String nombre,apellidos;
    public Usuarios(int idusuario,String nombre,String apellidos,int edad){
        setIdusuario(idusuario);
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
