package com.example.landmarkbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.landmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        //Data
        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("Pisa Tower" , "Italy" , R.drawable.pisa_tower)
        val eiffel = Landmark("Eiffel Tower" , "France" , R.drawable.eiffel_tower)
        val londonBridge = Landmark("London Bridge" , "UK" , R.drawable.london_bridge)
        val colosseum = Landmark("Colosseum" , "Italy" , R.drawable.colosseum)

        landmarkList.add(pisa)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)
        landmarkList.add(colosseum)


                //: RecyclerView ---->>
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter


        /*      //: ListView ---->>

        //Adapter : Layout & Data
        //Mapping

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkList.map { landmark -> landmark.name })
        binding.listView.adapter = adapter


        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val selectedLandmark = landmarkList[position]
            val intent = Intent(this, DetailsActivity::class.java).apply { putExtra("landmark",
                selectedLandmark) }

            startActivity(intent)
        }   */
    }
}