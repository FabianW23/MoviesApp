package com.example.moviesapp.presentation.menu.play

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.databinding.FragmentPlayBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.util.MimeTypes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PlayFragment : Fragment(), Player.Listener {

    private val args: PlayFragmentArgs by navArgs()
    private lateinit var binding: FragmentPlayBinding
    private val videoLink = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        player()
        addMedia()
        return binding.root
    }
    private fun player(){
        val player = context?.let {
            ExoPlayer.Builder(it)
                .build()
        }
        val mediaItem = MediaItem.Builder()
            .setUri(videoLink)
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()

        val mediaSource = context?.let {
            ProgressiveMediaSource.Factory(
                DefaultDataSource.Factory(it))
                    .createMediaSource(mediaItem)
        }

        player!!.apply {
            setMediaSource(mediaSource!!)
            playWhenReady = true // start playing when the exoplayer has setup
            seekTo(0, 0L) // Start from the beginning
            prepare() // Change the state from idle.
        }.also {
            // Do not forget to attach the player to the view
            binding.trailerPlayer.player = it
        }
    }

    private fun addMedia(){
        val mediaItem = MediaItem.fromUri((videoLink))
        binding.trailerPlayer.player?.addMediaItem(mediaItem)
    }
}



