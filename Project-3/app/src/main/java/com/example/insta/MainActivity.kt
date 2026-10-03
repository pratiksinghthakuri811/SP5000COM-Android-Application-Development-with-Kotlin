package com.example.insta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.insta.ui.theme.InstaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            InstaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileBody(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ProfileBody(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {

        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Icon(
                painter = painterResource(R.drawable.outline_arrow_back_ios_24),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )

            Text(
                "Pratik_Thakuri7",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                ),
            )

            Icon(
                painter = painterResource(R.drawable.baseline_more_horiz_24),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )
        }

        // Profile image + stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(R.drawable.pratik),
                contentDescription = null,
                modifier = Modifier
                    .size(110.dp)
                    .border(
                        width = 4.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Magenta,
                                Color.Yellow,
                            ),
                        ),
                        shape = CircleShape,
                    )
                    .padding(4.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "0",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Text(
                    "Posts",
                    fontSize = 16.sp,
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "200",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Text(
                    "Followers",
                    fontSize = 16.sp,
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "100",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Text(
                    "Following",
                    fontSize = 16.sp,
                )
            }
        }

        // Username + Bio
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
        ) {

            Text(
                "football passionate",
                modifier = Modifier.padding(top = 12.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                ),
            )

            Text(
                text = buildAnnotatedString {

                    append(
                        "Software Engineer\n",
                    )

                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                        ),
                    ) {
                        append("#hastag\n")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                        ),
                    ) {
                        append("Link goes here")
                    }
                },
                fontSize = 16.sp,
            )
        }

        // Followed by
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
        ) {

            Text("Followed by ")

            Text(
                "username",
                fontWeight = FontWeight.Bold,
            )

            Text(" and ")

            Text(
                "username",
                fontWeight = FontWeight.Bold,
            )
        }
        Row {
            ElevatedButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Text("Button")
            }
        }

        // Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ElevatedButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Text("Follow")
            }

            ElevatedButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Text("Message")
            }
            ElevatedButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Text("Email")
            }

            Icon(
                painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )
        }

        // Story Highlights
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {

            // Story 1
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(R.drawable.firstimage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Text(".")
            }

            // Story 2
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(R.drawable.llyoid),
                    contentDescription = null,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Text(".")
            }

            // Story 3
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(R.drawable.album),
                    contentDescription = null,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Text(".")
            }

            // Story 4
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(R.drawable.shawnmendes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Text(".")
            }

            // Story 5
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Image(
                    painter = painterResource(R.drawable.family),
                    contentDescription = null,
                    modifier = Modifier
                        .size(65.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )

                Text(".")
            }
        }
    }
}

@Preview
@Composable
fun ProfileBodyPreview() {
    InstaTheme {
        ProfileBody()
    }
}