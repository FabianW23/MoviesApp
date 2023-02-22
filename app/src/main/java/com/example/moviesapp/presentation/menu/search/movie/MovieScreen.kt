package com.example.moviesapp.presentation.menu.search.movie

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.moviesapp.R
import com.example.moviesapp.presentation.theme.YellowDark

@Composable
fun MovieScreen() {
    Scaffold(topBar = { TopBar() }) {
        MovieContent()
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                text = "title",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        },
        backgroundColor = Color.White,

    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MovieContent() {
    ConstraintLayout {
        val (
            title, originalTitle, releaseDate, bulletPoint, trailer, poster,
            genre, synopsisTitle, synopsis, starIcon, points
        ) = createRefs()

        Box(
            modifier = Modifier
                .size(width = 10.dp, height = 40.dp)
                .background(color = YellowDark, shape = CircleShape)
                .constrainAs(bulletPoint) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        ) {}
        Text(text = "movie title", modifier = Modifier.constrainAs(title) {
            start.linkTo(bulletPoint.end, margin = 16.dp)
            top.linkTo(bulletPoint.top)
        })
        Text(text = "Original title", modifier = Modifier.constrainAs(originalTitle) {
            top.linkTo(title.bottom, margin = 16.dp)
            start.linkTo(title.start)
        })
        Text(text = "Date", modifier = Modifier.constrainAs(releaseDate) {
            top.linkTo(originalTitle.bottom, margin = 16.dp)
            start.linkTo(originalTitle.start)
        })
        Image(
            painter = painterResource(id = R.drawable.stranger_things),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(trailer) {
                    top.linkTo(releaseDate.bottom, margin = 16.dp)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.poster_placeholder),
            contentDescription = "poster",
            modifier = Modifier
                .size(width = 80.dp, height = 120.dp)
                .constrainAs(poster) {
                    top.linkTo(trailer.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )
        Surface(
            modifier = Modifier
                .constrainAs(genre) {
                    start.linkTo(poster.end, margin = 16.dp)
                    top.linkTo(poster.top, margin = 0.dp)
                },
            elevation = 8.dp,
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(
                width = 2.dp,
                color = Color.Gray
            )
        ) {
            Text(text = "Drama", modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        }
        Image(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "points icon",
            modifier = Modifier
                .size(16.dp)
                .constrainAs(starIcon) {
                    start.linkTo(genre.end, margin = 32.dp)
                    top.linkTo(genre.top)
                    bottom.linkTo(genre.bottom)
                }
        )
        Text(text = "4.5",
            modifier = Modifier
                .constrainAs(points) {
                    start.linkTo(starIcon.end, margin = 8.dp)
                    top.linkTo(starIcon.top)
                    bottom.linkTo(starIcon.bottom)
                })
        Text(text = "Synopsis",
            modifier = Modifier
                .constrainAs(synopsisTitle) {
                    start.linkTo(genre.start)
                    top.linkTo(genre.bottom, margin = 8.dp)
                })
        Text(text = "Synopsis asd asdasd  asd a sd      asd  as da sd a sd a sd  ",
            modifier = Modifier
                .constrainAs(synopsis) {
                    start.linkTo(synopsisTitle.start, margin = 0.dp)
                    top.linkTo(synopsisTitle.bottom, margin = 8.dp)
                    bottom.linkTo(poster.bottom, margin = 0.dp)
        })
    }
}