package com.example.sampleone

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDDDDDD)) // Frame background color from Figma
    ) {
        // Status Bar - Height: 47dp
        ProfileStatusBar()
        
        // Navigation Bar - Height: 40dp  
        ProfileNavigationBar(onBackClick = onBackClick)
        
        // User Profile Data - Height: 90dp
        ProfileUserData()
        
        // Username and Info - Height: 234dp
        ProfileUsernameAndInfo()
        
        // Saved IG Stories - Height: 86dp
        ProfileSavedStories()
        
        // Tab Navigation Bar - Height: 50dp
        ProfileTabNavigation()
        
        // Grid Photo View - Remaining space
        ProfileGridPhotoView()
        
        // Bottom Navigation - Height: 56dp
        ProfileBottomNavigation()
        
        // Home Indicator - Height: 34dp
        ProfileHomeIndicator()
    }
}

@Composable
fun ProfileStatusBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)
            .background(Color.Black) // Profile status bar is black
    ) {
        // Time on left
        Text(
            text = "9:41",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 27.dp)
        )
        
        // Battery and wifi on right
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 27.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Wifi icon placeholder
            Box(
                modifier = Modifier
                    .size(17.dp, 12.dp)
                    .background(Color.White)
            )
            // Battery icon placeholder  
            Box(
                modifier = Modifier
                    .size(27.dp, 13.dp)
                    .background(Color.White)
            )
        }
    }
}

@Composable
fun ProfileNavigationBar(onBackClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.Black)
    ) {
        // Back button on left
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 14.dp)
                .size(24.dp)
                .background(Color.White)
                .clickable { onBackClick() }
        )
        
        // Username in center with verified badge
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "username",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            
            // Verified badge
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(Color(0xFF1FA1FF), CircleShape)
            )
        }
        
        // Right icons
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            repeat(2) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.White)
                )
            }
        }
    }
}

@Composable
fun ProfileUserData() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Avatar - Size: 90dp
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .background(Color(0xFFF0F0F0), CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color(0xFFE91E63), // Story ring gradient simplified
                        shape = CircleShape
                    )
            )
            
            Spacer(modifier = Modifier.width(40.dp))
            
            // Stats
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ProfileStatItem("1,234", "Posts")
                ProfileStatItem("5,678", "Followers")
                ProfileStatItem("9,101", "Following")
            }
        }
    }
}

@Composable
fun ProfileStatItem(number: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(36.dp)
    ) {
        Text(
            text = number,
            fontSize = 14.sp,
            color = Color.White
        )
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ProfileUsernameAndInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(234.dp)
            .background(Color.Black)
            .padding(horizontal = 12.dp)
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        
        // Username
        Text(
            text = "Username",
            fontSize = 13.sp,
            color = Color.White
        )
        
        Spacer(modifier = Modifier.height(3.dp))
        
        // Category/Genre
        Text(
            text = "Category/Genre text",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White.copy(alpha = 0.5f)
        )
        
        Spacer(modifier = Modifier.height(3.dp))
        
        // Bio
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt #hashtag",
            fontSize = 13.sp,
            color = Color.White,
            lineHeight = 16.sp
        )
        
        Spacer(modifier = Modifier.height(3.dp))
        
        // Link
        Text(
            text = "Link goes here",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF004C8B)
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // Followers section
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Avatars with overlapping effect
            Box {
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .offset(x = (index * 14).dp)
                            .background(Color(0xFFF0F0F0), CircleShape)
                            .border(1.dp, Color.Black, CircleShape)
                    )
                }
            }
            
            Spacer(modifier = Modifier.width(28.dp)) // Account for overlapping avatars
            
            Text(
                text = "Followed by username, username\nand 100 others",
                fontSize = 13.sp,
                color = Color.White,
                lineHeight = 16.sp
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        // Buttons section
        Column(
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            // Follow button
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1FA1FF)),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(3.dp)
            ) {
                Text(
                    text = "Follow",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            
            // Other buttons row
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                ProfileButton("Message", modifier = Modifier.weight(1f))
                ProfileButton("Subscribe", modifier = Modifier.weight(1f))
                ProfileButton("Contact", modifier = Modifier.weight(1f))
                
                // Special icon button
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.2f)
                    ),
                    modifier = Modifier.width(32.dp).height(30.dp),
                    shape = RoundedCornerShape(3.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .background(Color.White)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White.copy(alpha = 0.2f)
        ),
        modifier = modifier.height(30.dp),
        shape = RoundedCornerShape(3.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ProfileSavedStories() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(86.dp)
            .background(Color(0xFFF5F5F5))
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 9.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(5) { index ->
                ProfileStoryItem("Text here")
            }
        }
    }
}

@Composable
fun ProfileStoryItem(label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(60.dp)
    ) {
        // Story circle
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.White, CircleShape)
                .border(1.dp, Color(0xFFC4C4C4), CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(Color(0xFFF0F0F0), CircleShape)
                    .align(Alignment.Center)
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.White
        )
    }
}

@Composable
fun ProfileTabNavigation() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            // Posts tab (selected)
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.White)
                        .align(Alignment.Center)
                )
                
                // Selected indicator
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.White)
                        .align(Alignment.BottomCenter)
                )
            }
            
            // Reels tab
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color(0xFFC4C4C4))
                        .align(Alignment.Center)
                )
            }
            
            // Tagged tab
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color(0xFFC4C4C4))
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun ProfileGridPhotoView() {
    val gridPhotos: List<String> = listOf(
        ImageResources.gridPhoto1,
        ImageResources.gridPhoto2,
        ImageResources.gridPhoto3,
        ImageResources.gridPhoto4,
        ImageResources.gridPhoto5,
        ImageResources.gridPhoto6,
        ImageResources.gridPhoto7,
        ImageResources.gridPhoto8,
        ImageResources.gridPhoto9,
        ImageResources.gridPhoto10,
        ImageResources.gridPhoto11,
        ImageResources.gridPhoto12
    )
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight() // Take remaining space
            .background(Color.White)
            .border(width = 1.dp, color = Color(0xFFB4B4B4))
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(gridPhotos) { photoResource ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(0xFFDFDFE8))
                ) {
                    // Photo placeholder (using colored box for now)
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFF0F0F0))
                    )
                    
                    // Random icons on some posts
                    if (listOf(1, 2, 6, 8, 12).contains(gridPhotos.indexOf(photoResource) + 1)) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(4.dp)
                                .size(12.dp)
                                .background(Color.White, RoundedCornerShape(2.dp))
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileBottomNavigation() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Black)
    ) {
        // Divider line at top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White.copy(alpha = 0.1f))
        )
        
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color.White)
                )
            }
            
            // Profile avatar with notification dot
            Box {
                // Profile icon placeholder
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color(0xFFF0F0F0), CircleShape)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDDDD),
                            shape = CircleShape
                        )
                )
                
                // Notification dot
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .background(Color(0xFFFE0135), CircleShape)
                        .offset(x = 18.dp, y = 18.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileHomeIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(Color.Black)
    ) {
        Box(
            modifier = Modifier
                .width(134.dp)
                .height(5.dp)
                .background(Color.White, RoundedCornerShape(100.dp))
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}