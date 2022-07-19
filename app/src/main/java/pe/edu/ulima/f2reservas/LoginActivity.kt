package pe.edu.ulima.f2reservas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import pe.edu.ulima.f2reservas.databinding.ActivityLoginBinding
import pe.edu.ulima.f2reservas.singleton.Datausuario

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(
            this,
            Datausuario.nombre.toString(),
            Toast.LENGTH_SHORT).show()

        Toast.makeText(
            this,
            Datausuario.contra.toString(),
            Toast.LENGTH_SHORT).show()

        if(Datausuario.guar=="0" && Datausuario.contra!=null){
            val nom: String? =Datausuario.nombre
            val con: String? =Datausuario.contra

            binding.eteUsuario.setText(nom)
            binding.eteContraseA.setText(con)
        }

        binding.loginBtn.setOnClickListener{
            //////el if
            if(binding.checkBox.isChecked){
                val nombre: String = binding.eteUsuario!!.text.toString()
                val contra: String = binding.eteContraseA!!.text.toString()
                Datausuario.nombre=nombre
                Datausuario.contra=contra
                Datausuario.guar="0"
                startActivity(Intent(this, MainActivity ::class.java))

            }else{
                val nombre: String = binding.eteUsuario!!.text.toString()
                val contra: String = binding.eteContraseA!!.text.toString()
                Datausuario.nombre=nombre
                Datausuario.contra=null
                Datausuario.guar="1"
                startActivity(Intent(this, MainActivity ::class.java))
            }


        }

    }
}