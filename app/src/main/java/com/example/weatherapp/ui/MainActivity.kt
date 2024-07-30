package com.example.weatherapp.ui

import android.os.Bundle
import android.provider.Settings.Global
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.whenCreated
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.utils.toDate
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {

    private val mainActivityViewModel = MainActivityViewModel()
    private lateinit var binding: ActivityMainBinding

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.wind.collectLatest {
                binding.windTextView.text = it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.pressure.collectLatest {
                 binding.pressureTextView.text = it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString()
            }
        }
        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.wind.collectLatest {
                binding.windTextView.text = it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.temp.collectLatest {
                binding.tempTextView.text =  it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.sunrise.collectLatest {
                binding.sunriseTextView.text = it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString().toDate()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.sunset.collectLatest {
                binding.sunsetTextView.text = it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString().toDate()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            mainActivityViewModel.uv.collectLatest {
                binding.uvTextView.text = it?.data?.first()?.coordinates?.first()?.dates?.first()?.value.toString()
            }
        }

        mainActivityViewModel.getWind()
        mainActivityViewModel.getPressure()
        mainActivityViewModel.getTemp()
        mainActivityViewModel.getSunrise()
        mainActivityViewModel.getSunset()
        mainActivityViewModel.getUV()

    }
}