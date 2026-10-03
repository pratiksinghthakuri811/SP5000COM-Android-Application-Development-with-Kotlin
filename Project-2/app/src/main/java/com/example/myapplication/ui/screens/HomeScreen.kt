package com.example.myapplication.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.AppTheme
import com.example.myapplication.ui.theme.MintGreen

data class CategoryItem(
    val id: String,
    val title: String,
    val countText: String,
    val iconType: IconType
)

enum class IconType {
    TEXT, ADDRESS, CHARACTER, BANK_CARD, PASSWORD, LOGISTICS
}

@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit = {},
    onSwitchScreen: () -> Unit = {}
) {
    val categories = listOf(
        CategoryItem("text", "Text", "11 items content", IconType.TEXT),
        CategoryItem("address", "Address", "3 items content", IconType.ADDRESS),
        CategoryItem("character", "Character", "15 items content", IconType.CHARACTER),
        CategoryItem("bank_card", "Bank card", "5 items content", IconType.BANK_CARD),
        CategoryItem("password", "Password", "21 items content", IconType.PASSWORD),
        CategoryItem("logistics", "Logistics", "13 items content", IconType.LOGISTICS)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MintGreen)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // Header Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Card",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Simple and easy to use app",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Screen Switcher Button
                    IconButton(
                        onClick = onSwitchScreen,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White.copy(alpha = 0.2f), CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Switch View",
                            tint = Color.White
                        )
                    }

                    // User Profile Avatar
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.size(36.dp)) {
                            // Avatar head & body illustration
                            drawCircle(color = Color(0xFFE0E0E0), radius = size.minDimension / 2)
                            drawCircle(color = Color(0xFF3F51B5), radius = size.minDimension / 4, center = Offset(size.width / 2, size.height / 2.5f))
                            drawArc(
                                color = Color(0xFF1E88E5),
                                startAngle = 0f,
                                sweepAngle = 180f,
                                useCenter = true,
                                topLeft = Offset(size.width * 0.15f, size.height * 0.55f),
                                size = Size(size.width * 0.7f, size.height * 0.7f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Category Grid + Settings
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 24.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        onClick = { onCategoryClick(category.id) }
                    )
                }

                // Full-width Settings card at bottom
                item(span = { GridItemSpan(2) }) {
                    SettingsCard(onClick = { onCategoryClick("settings") })
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: CategoryItem,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp), ambientColor = Color.Black.copy(alpha = 0.08f))
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.size(54.dp),
                contentAlignment = Alignment.Center
            ) {
                CategoryIcon(category.iconType)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = category.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = category.countText,
                fontSize = 12.sp,
                color = Color(0xFFB0B0B0)
            )
        }
    }
}

@Composable
fun SettingsCard(onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .shadow(4.dp, RoundedCornerShape(20.dp), ambientColor = Color.Black.copy(alpha = 0.08f))
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .background(Color(0xFFEBF3FE), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color(0xFF5C82E6),
                    modifier = Modifier.size(26.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "Settings",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF333333)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Fingerprint code and so on",
                    fontSize = 12.sp,
                    color = Color(0xFFB0B0B0)
                )
            }
        }
    }
}

@Composable
fun CategoryIcon(type: IconType) {
    Canvas(modifier = Modifier.size(48.dp)) {
        val w = size.width
        val h = size.height

        when (type) {
            IconType.TEXT -> {
                // Bible/Book with Cross
                drawRoundRect(
                    color = Color(0xFF3949AB),
                    topLeft = Offset(w * 0.2f, h * 0.15f),
                    size = Size(w * 0.6f, h * 0.7f),
                    cornerRadius = CornerRadius(8f, 8f)
                )
                // Cross symbol
                drawRect(
                    color = Color(0xFFFFD54F),
                    topLeft = Offset(w * 0.45f, h * 0.3f),
                    size = Size(w * 0.1f, h * 0.35f)
                )
                drawRect(
                    color = Color(0xFFFFD54F),
                    topLeft = Offset(w * 0.35f, h * 0.4f),
                    size = Size(w * 0.3f, h * 0.1f)
                )
                // Bookmark red line
                drawRect(
                    color = Color(0xFFE53935),
                    topLeft = Offset(w * 0.45f, h * 0.15f),
                    size = Size(w * 0.1f, h * 0.15f)
                )
            }
            IconType.ADDRESS -> {
                // Church/House with Heart
                val roofPath = Path().apply {
                    moveTo(w * 0.5f, h * 0.15f)
                    lineTo(w * 0.85f, h * 0.45f)
                    lineTo(w * 0.15f, h * 0.45f)
                    close()
                }
                drawPath(roofPath, color = Color(0xFFE53935))
                drawRect(
                    color = Color(0xFFECEFF1),
                    topLeft = Offset(w * 0.25f, h * 0.45f),
                    size = Size(w * 0.5f, h * 0.45f)
                )
                // Red Heart
                drawCircle(
                    color = Color(0xFFE53935),
                    radius = w * 0.1f,
                    center = Offset(w * 0.5f, h * 0.62f)
                )
            }
            IconType.CHARACTER -> {
                // Character Portrait Avatar
                drawCircle(color = Color(0xFFFFE082), radius = w * 0.35f, center = Offset(w * 0.5f, h * 0.5f))
                // Hair / Hat
                drawArc(
                    color = Color(0xFF3E2723),
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset(w * 0.2f, h * 0.15f),
                    size = Size(w * 0.6f, h * 0.4f)
                )
                // Glasses/Face
                drawCircle(color = Color(0xFF37474F), radius = w * 0.08f, center = Offset(w * 0.38f, h * 0.48f))
                drawCircle(color = Color(0xFF37474F), radius = w * 0.08f, center = Offset(w * 0.62f, h * 0.48f))
                // Shirt
                drawArc(
                    color = Color(0xFFFFB300),
                    startAngle = 0f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset(w * 0.2f, h * 0.62f),
                    size = Size(w * 0.6f, h * 0.35f)
                )
            }
            IconType.BANK_CARD -> {
                // Credit Card
                drawRoundRect(
                    color = Color(0xFF1A237E),
                    topLeft = Offset(w * 0.1f, h * 0.25f),
                    size = Size(w * 0.8f, h * 0.5f),
                    cornerRadius = CornerRadius(6f, 6f)
                )
                // Yellow chip
                drawRoundRect(
                    color = Color(0xFFFFD54F),
                    topLeft = Offset(w * 0.22f, h * 0.4f),
                    size = Size(w * 0.18f, h * 0.18f),
                    cornerRadius = CornerRadius(2f, 2f)
                )
                // Circles (MasterCard style)
                drawCircle(color = Color(0xFFE53935), radius = w * 0.09f, center = Offset(w * 0.68f, h * 0.55f))
                drawCircle(color = Color(0xFFFFB300), radius = w * 0.09f, center = Offset(w * 0.78f, h * 0.55f))
            }
            IconType.PASSWORD -> {
                // Key Illustration
                val keyHeadCenter = Offset(w * 0.68f, h * 0.32f)
                drawCircle(color = Color(0xFFFFCA28), radius = w * 0.22f, center = keyHeadCenter)
                drawCircle(color = Color.White, radius = w * 0.09f, center = keyHeadCenter)

                // Key shaft
                val shaftPath = Path().apply {
                    moveTo(w * 0.52f, h * 0.44f)
                    lineTo(w * 0.18f, h * 0.78f)
                    lineTo(w * 0.26f, h * 0.86f)
                    lineTo(w * 0.6f, h * 0.52f)
                    close()
                }
                drawPath(shaftPath, color = Color(0xFFFFCA28))
                // Key notches
                drawRect(color = Color(0xFFFFCA28), topLeft = Offset(w * 0.2f, h * 0.72f), size = Size(w * 0.08f, h * 0.1f))
            }
            IconType.LOGISTICS -> {
                // Logistics Box in Hand
                drawRoundRect(
                    color = Color(0xFF00BFA5),
                    topLeft = Offset(w * 0.15f, h * 0.45f),
                    size = Size(w * 0.7f, h * 0.4f),
                    cornerRadius = CornerRadius(12f, 12f)
                )
                // Package Box
                drawRoundRect(
                    color = Color(0xFF4CAF50),
                    topLeft = Offset(w * 0.3f, h * 0.2f),
                    size = Size(w * 0.4f, h * 0.45f),
                    cornerRadius = CornerRadius(4f, 4f)
                )
                // Box tape/label
                drawRect(
                    color = Color(0xFF81C784),
                    topLeft = Offset(w * 0.45f, h * 0.2f),
                    size = Size(w * 0.1f, h * 0.45f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}

