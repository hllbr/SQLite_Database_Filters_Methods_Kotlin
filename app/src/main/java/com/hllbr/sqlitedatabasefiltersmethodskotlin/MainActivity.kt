package com.hllbr.sqlitedatabasefiltersmethodskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try{
            var myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR,age INT)")
           // myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('james',50)")
          //  myDatabase.execSQL("INSERT INTO musicians(name,age) VALUES('Kirk',65)")
            //myDatabase.execSQL("INSERT INTO mucisians(name,age)VALUES('Bart',2)")
          // myDatabase.execSQL("ınsert ınto musicians(name,age) VALUES('hllbr',25)")

            var cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name = 'hllbr'",null)//name değeri hllbrye eşitse al gibi bir sorulama şekline dönüşmüş oldu where(nerede) name değerinin hllbrye eşit olduğu yerlerde şeklinde ifade edebilirim
            //var cursor2 = myDatabase.rawQuery("SELECT * FROM musicians WHERE id = 3",null)//id sorgu
            //var cursor3 = myDatabase.rawQuery("SELECT * FROM musicians WHERE age >25",null)

            var nameIx = cursor.getColumnIndex("name")
            var ageIx = cursor.getColumnIndex("age")
            var ıdIx = cursor.getColumnIndex("id")
            while (cursor.moveToNext()){
                println("name : "+ cursor.getString(nameIx))
                println("age : "+cursor.getInt(ageIx))
                println("id : "+cursor.getInt(ıdIx))

            }
            cursor.close()
        }catch (e : Exception){
            e.printStackTrace()
        }
    }
}