package com.example.moviesapp.presentation.menu.play

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.compose.rememberAsyncImagePainter
import com.example.moviesapp.data.model.dto.MovieDTO
import com.example.moviesapp.databinding.FragmentPlayBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlayFragment : Fragment() {

    private val args: PlayFragmentArgs by navArgs()
    private lateinit var binding: FragmentPlayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        binding.VVTrailer.isVisible = false
        args.videoId?.let {
            playTrailer(it)
        }
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun playTrailer(videoId:String){
        val webViewSettings: WebSettings = binding.VVTrailer.settings
        webViewSettings.javaScriptCanOpenWindowsAutomatically = true
        webViewSettings.javaScriptEnabled = true
        binding.VVTrailer.webViewClient = WebViewClient()
        binding.VVTrailer.loadData("<iframe width='100%' height='100%' " +
                "src='https://www.youtube.com/embed/$videoId' title='YouTube video player' frameborder='0' allow='accelerometer; " +
                "autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share' allowfullscreen></iframe>" ,
            "text/html", "utf-8")
        binding.VVTrailer.isVisible = true
    }

}



