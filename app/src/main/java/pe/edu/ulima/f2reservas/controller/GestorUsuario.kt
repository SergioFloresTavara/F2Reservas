package pe.edu.ulima.f2reservas.controller

class GestorUsuario {
    fun obtenerUsuarios(): List<Usuario>{
        val usuarios=ArrayList<Usuario>()
        usuarios.add(Usuario("20190750","123","Sergio Flores"))
        usuarios.add(Usuario("20181063","eee","Favio Flores"))
        usuarios.add(Usuario("20151050","aaa","Javier Flores"))
        usuarios.add(Usuario("admin","1234","Administrador"))
        return usuarios
    }

    fun obtenerPassword(usuario: String,usuarios:List<Usuario>):String{
        for(i in 0..usuarios.size-1){
            if(usuarios[i].usuario==usuario){
                return usuarios[i].contra
            }
        }
        return ""
    }
    fun obtenerNombre(usuario: String,usuarios:List<Usuario>):String{
        for(i in 0..usuarios.size-1){
            if(usuarios[i].usuario==usuario){
                return usuarios[i].nombre
            }
        }
        return ""
    }
}