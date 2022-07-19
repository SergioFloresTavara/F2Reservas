package pe.edu.ulima.f2reservas.controller

class GestorUsuario {
    fun obtenerUsuarios(): List<Usuario>{
        val usuarios=ArrayList<Usuario>()
        usuarios.add(Usuario("20190750","123"))
        usuarios.add(Usuario("20191063","eee"))
        usuarios.add(Usuario("20190888","aaa"))
        usuarios.add(Usuario("admin","1234"))
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
}