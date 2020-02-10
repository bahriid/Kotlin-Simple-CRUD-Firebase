    package com.modulbahri.crudapi.ModulCreate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.modulbahri.crudapi.MainActivity
import com.modulbahri.crudapi.R
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_create.alamat
import kotlinx.android.synthetic.main.activity_create.email
import kotlinx.android.synthetic.main.activity_create.nama
import kotlinx.android.synthetic.main.activity_create.nohp
import kotlinx.android.synthetic.main.activity_create.save
import java.util.*

    class CreateActivity : AppCompatActivity() {


    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    lateinit var sNama:String
    lateinit var sNoHp:String
    lateinit var sAlamat:String
    lateinit var sEmail:String
    lateinit var sGambar:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()

        // Penamaan table database yang ingin digunakan
        mFirebaseDatabase = mFirebaseInstance.getReference("Data")

        save.setOnClickListener {
            savedata()
        }
    }

        private fun savedata() {

            // Untuk mengambil inputan dari layout
            sNama = nama.text.toString()
            sNoHp = nohp.text.toString()
            sAlamat = alamat.text.toString()
            sEmail = email.text.toString()
            sGambar = gambar.text.toString()


            // Script input
            // randomuuid itu untuk id pada table nanti
            val key = mFirebaseDatabase.push().getKey()
            val currentUserDb = mFirebaseDatabase!!.child(key!!)
            currentUserDb.child("nama").setValue(sNama)
            currentUserDb.child("nohp").setValue(sNoHp)
            currentUserDb.child("alamat").setValue(sAlamat)
            currentUserDb.child("email").setValue(sEmail)
            currentUserDb.child("gambar").setValue(sGambar)
            currentUserDb.child("randomid").setValue(key)



            finishAffinity()

            // Pindah ke home
            val intent = Intent(this@CreateActivity, MainActivity::class.java)
            startActivity(intent)
        }
}
