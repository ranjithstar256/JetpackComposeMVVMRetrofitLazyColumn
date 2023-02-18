package com.example.jetpackcomposemvvmretrofitandrecyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.example.Articles
import com.example.jetpackcomposemvvmretrofitandrecyclerview.ui.theme.JetpackComposeMVVMRetrofitAndRecyclerviewTheme

class MainActivity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeMVVMRetrofitAndRecyclerviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MovieList(movieList = mainViewModel.movieListResponse)
                    mainViewModel.getMovieList()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItem() {
    var articles     : ArrayList<Articles> = arrayListOf()
    val movie = News(
        "Coco",
        66,
        articles
    )

    MovieItem(movie = movie, 0, 0) { i ->

    }
}
@Composable
fun MovieList(movieList: List<News>) {
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {

        itemsIndexed(items = movieList) { index, item ->
            MovieItem(movie = item, index, selectedIndex) { i ->
                selectedIndex = i
            }
        }
    }

}


@Composable
fun MovieItem(movie: News, index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {

    val backgroundColor =
        if (index == selectedIndex) MaterialTheme.colors.primary else MaterialTheme.colors.background
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .clickable { onClick(index) }
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface(color = backgroundColor) {

            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Image(
                    painter = rememberImagePainter(
                        data = movie.articles.get(index).urlToImage,

                        builder = {
                            scale(Scale.FILL)
                            placeholder(R.drawable.placeholder)
                            transformations(CircleCropTransformation())

                        }
                    ),
                    contentDescription = movie.articles.get(index).url,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)
                )


                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = movie.articles.get(index).title.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = movie.articles.get(index).publishedAt.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .background(
                                Color.LightGray
                            )
                            .padding(4.dp)
                    )
                    Text(
                        text = movie.articles.get(index).description + "",
                        style = MaterialTheme.typography.body1,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }
    }
}
