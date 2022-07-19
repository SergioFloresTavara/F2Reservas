package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import pe.edu.ulima.f2reservas.controller.GestorUsuario
import pe.edu.ulima.f2reservas.controller.Usuario
import pe.edu.ulima.f2reservas.databinding.ActivityLoginBinding
import pe.edu.ulima.f2reservas.singleton.Datausuario

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    var Gestor=GestorUsuario()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(Datausuario.guar=="0" && Datausuario.contra!=null){
            val nom: String? =Datausuario.nombre
            val con: String? =Datausuario.contra
            binding.checkBox.isChecked=true
            binding.eteUsuario.setText(nom)
            binding.eteContraseA.setText(con)
        }

        binding.loginBtn.setOnClickListener{
            var usuarios:List<Usuario>
            usuarios=Gestor.obtenerUsuarios()
            val nombre: String = binding.eteUsuario!!.text.toString()
            val contra: String = binding.eteContraseA!!.text.toString()
            if(contra==Gestor.obtenerPassword(nombre,usuarios)){
                if(binding.checkBox.isChecked){
                    Datausuario.nombre=nombre
                    Datausuario.contra=contra
                    Datausuario.guar="0"
                    Datausuario.NomApe=Gestor.obtenerNombre(nombre,usuarios)
                    startActivity(Intent(this, MainActivity ::class.java))

                }else{
                    val nombre: String = binding.eteUsuario!!.text.toString()
                    val contra: String = binding.eteContraseA!!.text.toString()
                    Datausuario.nombre=nombre
                    Datausuario.contra=null
                    Datausuario.guar="1"
                    startActivity(Intent(this, MainActivity ::class.java))
                }
            }else{
                Toast.makeText(
                    this,
                    "Ingrese las credenciales correctas",
                    Toast.LENGTH_SHORT).show()
            }

        }

    }
}