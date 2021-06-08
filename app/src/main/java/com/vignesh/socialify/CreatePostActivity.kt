package com.vignesh.socialify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.vignesh.socialify.daos.PostDao
import kotlinx.android.synthetic.main.activity_create_post.*
import kotlinx.coroutines.delay

class CreatePostActivity : AppCompatActivity() {

    private lateinit var postDao: PostDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)

        postDao = PostDao()

        postButton.setOnClickListener {
            val input = postInput.text.toString().trim()
            if(input.isNotEmpty()){
                postDao.addPost(input)
                finish()
            }
            else(
                    Toast.makeText(this, "Error!!", Toast.LENGTH_LONG).show()
            )
        }
    }
}