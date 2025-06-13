package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.model.CryptoModel
import com.example.jetpackcompose.service.CryptoAPI
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val cryptoModels = remember { mutableStateListOf<CryptoModel>() }
    val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoAPI::class.java)

    val call = retrofit.getData()
    call.enqueue(object : Callback<List<CryptoModel>> {

        override fun onResponse(
            p0: Call<List<CryptoModel>>,
            response: Response<List<CryptoModel>>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    //list
                    cryptoModels.addAll(it)
                }
            }
        }

        override fun onFailure(p0: Call<List<CryptoModel>>, p1: Throwable) {
            p1.printStackTrace()
        }

    })

    Scaffold(
        topBar = { AppBar() }
    ) {
        Box(modifier = Modifier
            .padding(it))

        CryptoList(cryptos = cryptoModels)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = {
            Text(
                text = "Retrofit Compose",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        },Modifier.padding(6.dp),
        colors = TopAppBarDefaults
            .topAppBarColors(containerColor = Color.DarkGray)

    )
}

@Composable
fun CryptoList(cryptos: List<CryptoModel>) {
    LazyColumn(contentPadding = PaddingValues(5.dp)) {
        items(cryptos) {crypto ->
            CryptoRow(crypto = crypto)
        }
    }
}

@Composable
fun CryptoRow(crypto: CryptoModel) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.surface)
    ) {
        CryptoTexts(crypto.currency)
        CryptoTexts(crypto.price)
    }
}

@Composable
fun CryptoTexts(string: String) {
    Text(modifier = Modifier
        .padding(4.dp),
        text = string,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    JetpackComposeTheme {
        MainScreen()
    }
}