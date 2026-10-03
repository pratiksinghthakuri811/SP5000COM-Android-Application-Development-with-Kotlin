package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                CardScreen()
            }
        }
    }
}

@Composable
fun CardScreen(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF00C875))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp)
        ) {

            // Header Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.app_title),
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.app_subtitle),
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 14.sp
                    )
                }

                Image(
                    painter = painterResource(R.drawable.ic_avatar),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Tab Selector
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (selectedTab == 0) Color.White else Color.White.copy(alpha = 0.2f),
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 0 }
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.nav_grid),
                            color = if (selectedTab == 0) Color(0xFF00C875) else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (selectedTab == 1) Color.White else Color.White.copy(alpha = 0.2f),
                    modifier = Modifier
                        .weight(1f)
                        .clickable { selectedTab = 1 }
                ) {
                    Box(
                        modifier = Modifier.padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(R.string.nav_cards),
                            color = if (selectedTab == 1) Color(0xFF00C875) else Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Content Area
            if (selectedTab == 0) {
                CategoriesGridView()
            } else {
                CardsListView()
            }
        }

        // Floating Action Button for Cards ListView
        if (selectedTab == 1) {
            FloatingActionButton(
                onClick = {},
                containerColor = Color(0xFF00C875),
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_plus),
                    contentDescription = "Add Card",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun CategoriesGridView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Grid Rows
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                iconRes = R.drawable.ic_text_book,
                title = stringResource(R.string.cat_text),
                subtitle = stringResource(R.string.cat_text_subtitle),
                modifier = Modifier.weight(1f)
            )

            CategoryCard(
                iconRes = R.drawable.ic_address_house,
                title = stringResource(R.string.cat_address),
                subtitle = stringResource(R.string.cat_address_subtitle),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                iconRes = R.drawable.ic_character,
                title = stringResource(R.string.cat_character),
                subtitle = stringResource(R.string.cat_character_subtitle),
                modifier = Modifier.weight(1f)
            )

            CategoryCard(
                iconRes = R.drawable.ic_bank_card,
                title = stringResource(R.string.cat_bank_card),
                subtitle = stringResource(R.string.cat_bank_card_subtitle),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            CategoryCard(
                iconRes = R.drawable.ic_key_password,
                title = stringResource(R.string.cat_password),
                subtitle = stringResource(R.string.cat_password_subtitle),
                modifier = Modifier.weight(1f)
            )

            CategoryCard(
                iconRes = R.drawable.ic_logistics,
                title = stringResource(R.string.cat_logistics),
                subtitle = stringResource(R.string.cat_logistics_subtitle),
                modifier = Modifier.weight(1f)
            )
        }

        // Settings Full Width Card
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_settings_gear),
                    contentDescription = stringResource(R.string.cat_settings),
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = stringResource(R.string.cat_settings),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2C3E50)
                    )
                    Text(
                        text = stringResource(R.string.cat_settings_subtitle),
                        fontSize = 12.sp,
                        color = Color(0xFF95A5A6)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun CategoryCard(
    iconRes: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier.height(130.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(iconRes),
                contentDescription = title,
                tint = Color.Unspecified,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2C3E50)
            )

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = Color(0xFF95A5A6)
            )
        }
    }
}

@Composable
fun CardsListView(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        // Dribbble Card (Orange Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFFFFA000), Color(0xFFFF6F00))),
            title = stringResource(R.string.card_dribbble),
            subtitle = stringResource(R.string.card_paldax),
            codeText = stringResource(R.string.card_dribbble_dots),
            overlayIconRes = R.drawable.ic_lock
        )

        // HJM Card (Blue Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF2980B9), Color(0xFF6DD5FA))),
            title = stringResource(R.string.card_hjm),
            subtitle = stringResource(R.string.card_hjm_sub),
            codeText = null,
            overlayIconRes = R.drawable.ic_mail_docs
        )

        // Tom Card (Green Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF11998E), Color(0xFF38EF7D))),
            title = stringResource(R.string.card_tom),
            subtitle = stringResource(R.string.card_tom_address),
            codeText = stringResource(R.string.card_tom_phone)
        )

        // ICBC Card (Purple Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFF5C258D), Color(0xFF4389A2))),
            title = stringResource(R.string.card_icbc_number),
            subtitle = stringResource(R.string.card_icbc),
            codeText = stringResource(R.string.card_debit) + "                    " + stringResource(R.string.card_expiry)
        )

        // Young Card (Peach/Brown Gradient)
        GradientCard(
            gradient = Brush.horizontalGradient(listOf(Color(0xFFD4145A), Color(0xFFFBB03B))),
            title = stringResource(R.string.card_young),
            subtitle = stringResource(R.string.card_young_desc),
            codeText = null
        )

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun GradientCard(
    gradient: Brush,
    title: String,
    subtitle: String,
    codeText: String?,
    modifier: Modifier = Modifier,
    overlayIconRes: Int? = null
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
                .padding(16.dp)
        ) {
            overlayIconRes?.let { icon ->
                Image(
                    painter = painterResource(icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .align(Alignment.TopEnd)
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = subtitle,
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 12.sp
                    )
                }

                if (codeText != null) {
                    Text(
                        text = codeText,
                        color = Color.White.copy(alpha = 0.9f),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardScreenPreview() {
    MyApplicationTheme {
        CardScreen()
    }
}