package com.modulbahri.crudapi.ModulRead

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import com.modulbahri.crudapi.Data
import com.modulbahri.crudapi.MainActivity
import com.modulbahri.crudapi.R
import kotlinx.android.synthetic.main.activity_create.alamat
import kotlinx.android.synthetic.main.activity_create.email
import kotlinx.android.synthetic.main.activity_create.gambar
import kotlinx.android.synthetic.main.activity_create.nama
import kotlinx.android.synthetic.main.activity_create.nohp
import kotlinx.android.synthetic.main.activity_create.save
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {



    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    lateinit var sNama:String
    lateinit var sNoHp:String
    lateinit var sAlamat:String
    lateinit var sEmail:String
    lateinit var sGambar:String
    lateinit var key:String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()

        // Penamaan table database yang ingin digunakan
        mFirebaseDatabase = mFirebaseInstance.getReference("Data")


        // Menampilkan data ke edittext
        val data = intent.getParcelableExtra<Data>("data")
        key = data.randomid.toString()

        nama?.setText(data.nama)
        nohp?.setText(data.nohp)
        alamat?.setText(data.alamat)
        email?.setText(data.email)
        gambar?.setText(data.gambar)


        Glide.with(this)
            .load(data.gambar)
            .into(gambar2)

        save.setOnClickListener {
            savedata()
        }

        hapus.setOnClickListener {
            //Hapus berdasarkan ID
            mFirebaseDatabase.child(key).removeValue();
            Toast.makeText(this@DetailActivity, "Berhasil Dihapus", Toast.LENGTH_SHORT).show()


            // Pindah ke halaman home
            val intent = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun savedata() {

        val data2 = intent.getParcelableExtra<Data>("data")
       /* val token = data2*/


        // Untuk mengambil inputan dari layout
        sNama = nama.text.toString()
        sNoHp = nohp.text.toString()
        sAlamat = alamat.text.toString()
        sEmail = email.text.toString()
        sGambar = gambar.text.toString()
/*
        val key = data.randomid
*/


        // Script input
        // randomuuid itu untuk id pada table nanti

        val currentUserDb = mFirebaseDatabase!!.child(key.toString())

        currentUserDb.child("nama").setValue(sNama)
        currentUserDb.child("nohp").setValue(sNoHp)
        currentUserDb.child("alamat").setValue(sAlamat)
        currentUserDb.child("email").setValue(sEmail)
        currentUserDb.child("gambar").setValue(sGambar)
        currentUserDb.child("randomid").setValue(key)
        Toast.makeText(this@DetailActivity, "Berhasil Input", Toast.LENGTH_SHORT).show()



        finishAffinity()

        // Pindah ke home
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        startActivity(intent)
    }


}
