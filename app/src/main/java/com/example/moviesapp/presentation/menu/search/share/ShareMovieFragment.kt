package com.example.moviesapp.presentation.menu.search.share

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.moviesapp.domain.model.ContactModel
import com.example.moviesapp.databinding.FragmentShareMovieBinding
import com.example.moviesapp.domain.model.MovieModel
import com.example.moviesapp.presentation.theme.YellowDark
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShareMovieFragment : Fragment() {

    private val viewModel : ShareMovieViewModel by viewModels()
    private lateinit var binding: FragmentShareMovieBinding
    private val args: ShareMovieFragmentArgs by navArgs()
    private lateinit var movie: MovieModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        movie = args.movie
        viewModel.getContactList(this.requireContext())
        binding = FragmentShareMovieBinding.inflate(inflater, container, false)
        binding.contactList.setContent {
            this.activity?.let { MoviesList(viewModel, it, movie) }
        }
        return binding.root
    }
    /*
    @SuppressLint("Range")
    private fun getContactsList(): List<ContactModel> {
        val contactList = ArrayList<ContactModel>()


        Toast.makeText(this.context, "Permission already granted", Toast.LENGTH_SHORT).show()
        val phones = context?.contentResolver?.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        while (phones!!.moveToNext()) {

            val name =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            val phoneNumber =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)).replace(" ", "")
            val phonePhoto =phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI))

            val contact = ContactModel(phonePhoto, name, phoneNumber)
            if(contact.number.contains("+")) contactList.add(contact)
        }
        return contactList.distinct()
    }*/
}

@Composable
private fun MoviesList(viewModel:ShareMovieViewModel, activity: Activity, movie: MovieModel) {
    val listState = rememberLazyListState()
    val contacts by viewModel.contactList.observeAsState(listOf())
    LazyColumn(
        state = listState,
        modifier = Modifier
            .background(color = Color(0xFFF5F5F5))
            .fillMaxSize(1F)
    ) {
        items(contacts) { contact: ContactModel ->
            ContactItem(contact, activity, movie)
        }
    }
}


@Composable
private fun ContactItem(contact: ContactModel, activity: Activity, movie: MovieModel) {

    Card(modifier = Modifier
        .padding(8.dp)
        .clickable {
            activity.startActivity(
                Intent.createChooser(
                    Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Mira esta pelicula ${movie.title}")
                        type = "text/plain"
                    },
                    null
                )
            )
        }

    ) {
        Row(modifier = Modifier.background(color = Color(0xFFF5F5F5))) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(shape = CircleShape, color = YellowDark)
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                Text(text = contact.name.first().toString(), modifier = Modifier.align(alignment = Center))
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            ) {
                Text(text = contact.name)
                Text(
                    text = contact.number,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

