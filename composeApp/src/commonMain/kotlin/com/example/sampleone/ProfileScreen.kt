package com.example.sampleone

import androidx.compose.foundation.background
import androidx.compose.foundation.border

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
import androidx.compose.foundation.Image
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.zIndex
import org.jetbrains.compose.resources.painterResource
import sampleone.composeapp.generated.resources.Res
import sampleone.composeapp.generated.resources.ic_heart
import sampleone.composeapp.generated.resources.ic_back
import sampleone.composeapp.generated.resources.ic_notification
import sampleone.composeapp.generated.resources.ic_more
import sampleone.composeapp.generated.resources.ic_wifi
import sampleone.composeapp.generated.resources.ic_battery
import sampleone.composeapp.generated.resources.ic_grid
import sampleone.composeapp.generated.resources.ic_reels
import sampleone.composeapp.generated.resources.ic_tagged
import sampleone.composeapp.generated.resources.ic_carousel
import sampleone.composeapp.generated.resources.ic_reels_small
import sampleone.composeapp.generated.resources.ic_more_options
import org.jetbrains.compose.resources.DrawableResource
import sampleone.composeapp.generated.resources._260acb7f837eef41ed89178bb8849abaae20e34a
import sampleone.composeapp.generated.resources.a250d585517bb607f6262acc3ccbf7be91a53aa0
import sampleone.composeapp.generated.resources.d1498caab2525cc395b7459d400d8da29570c3fb
import sampleone.composeapp.generated.resources._5c0c8419f15b9472f1ee26bd0910024a435f0017
import sampleone.composeapp.generated.resources.ic_verified
import sampleone.composeapp.generated.resources.ic_home
import sampleone.composeapp.generated.resources.ic_search
import sampleone.composeapp.generated.resources.profile_small
import sampleone.composeapp.generated.resources.ic_add
import sampleone.composeapp.generated.resources.story_1
import sampleone.composeapp.generated.resources.story_2
import sampleone.composeapp.generated.resources.story_3
import sampleone.composeapp.generated.resources.story_4
import sampleone.composeapp.generated.resources.story_5
import sampleone.composeapp.generated.resources.post_1
import sampleone.composeapp.generated.resources.post_2
import sampleone.composeapp.generated.resources.post_3
import sampleone.composeapp.generated.resources.post_4
import sampleone.composeapp.generated.resources.post_5
import sampleone.composeapp.generated.resources.post_6
import sampleone.composeapp.generated.resources.post_7
import sampleone.composeapp.generated.resources.post_8
import sampleone.composeapp.generated.resources.post_9
import sampleone.composeapp.generated.resources.post_10
import sampleone.composeapp.generated.resources.post_11
import sampleone.composeapp.generated.resources.post_12
import sampleone.composeapp.generated.resources.post_13
import sampleone.composeapp.generated.resources.post_14
import sampleone.composeapp.generated.resources.post_15


@Preview
@Composable
fun ProfileScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) // Frame background color from Figma
    ) {
        // Status Bar - Height: 47dp
        ProfileStatusBar()
        
        // Navigation Bar - Height: 40dp  
        ProfileNavigationBar(
            username = "username",
            isVerified = true,
            onBackClick = onBackClick
        )
        
        // User Profile Data - Height: 90dp
        ProfileUserData(
            posts = "1,234",
            followers = "5,678",
            following = "9,101"
        )
        
        // Username and Info - Height: 234dp
        ProfileUsernameAndInfo(
            username = "Username",
            categoryText = "Category/Genre text",
            bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt #hashtag",
            link = "Link goes here",
            followedByText = "Followed by username, username\nand 100 others"
        )
        
        // Saved IG Stories - Height: 86dp
        ProfileSavedStories()
        
        // Tab Navigation Bar - Height: 50dp
        ProfileTabNavigation()
        
        // Grid Photo View - Remaining space
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
        ) {
            ProfileGridPhotoView()
        }
        
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
            // Wifi icon
            Image(
                painter = painterResource(Res.drawable.ic_wifi),
                contentDescription = "Wifi",
                modifier = Modifier.size(17.dp, 12.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            // Battery icon
            Image(
                painter = painterResource(Res.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier.size(27.dp, 13.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}

@Composable
fun ProfileNavigationBar(
    username: String,
    isVerified: Boolean,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.Black)
    ) {
        // Back button on left
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 14.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        
        // Username in center with verified badge
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = username,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            
            if (isVerified) {
                Image(
                    painter = painterResource(Res.drawable.ic_verified),
                    contentDescription = "Verified",
                    modifier = Modifier.size(16.dp)
                )
            }
        }
        
        // Right icons
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_notification),
                contentDescription = "Notifications",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(Res.drawable.ic_more),
                contentDescription = "More options",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}

@Composable
fun ProfileUserData(
    posts: String,
    followers: String,
    following: String
) {
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
            // Profile Avatar with Story Ring
            Box(
                modifier = Modifier.size(90.dp)
            ) {
                // Story ring gradient
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFFC913B9),
                                    Color(0xFFF93730),
                                    Color(0xFFFECC00)
                                )
                            ),
                            shape = CircleShape
                        )
                )
                
                // Profile image
                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .align(Alignment.Center)
                        .background(Color.White, CircleShape)
                        .border(0.5.dp, Color(0xFFDDDDDD), CircleShape)
                ) {
                    // TODO: Replace with actual profile image
                    Image(
                        painter = painterResource(resource = Res.drawable._260acb7f837eef41ed89178bb8849abaae20e34a),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(76.dp)
                            .clip(CircleShape),          // 圆形
                    )
                }
            }

            Spacer(modifier = Modifier.width(40.dp))
            
            // Stats
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ProfileStatItem(posts, "Posts")
                ProfileStatItem(followers, "Followers")
                ProfileStatItem(following, "Following")
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
fun ProfileUsernameAndInfo(
    username: String,
    categoryText: String,
    bio: String,
    link: String,
    followedByText: String
) {
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
            text = username,
            fontSize = 13.sp,
            color = Color.White,
            fontFamily = FontFamily.Default
        )
        
        Spacer(modifier = Modifier.height(3.dp))
        
        // Category/Genre
        Text(
            text = categoryText,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White.copy(alpha = 0.5f)
        )
        
        Spacer(modifier = Modifier.height(3.dp))
        
        // Bio
        Text(
            text = bio,
            fontSize = 13.sp,
            color = Color.White,
            lineHeight = 16.sp
        )
        
        Spacer(modifier = Modifier.height(3.dp))
        
        // Link
        Text(
            text = link,
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
            Box(
                modifier = Modifier.width(54.dp)
            ) {
                val followPhotos = listOf(
                    Res.drawable.a250d585517bb607f6262acc3ccbf7be91a53aa0,
                    Res.drawable.d1498caab2525cc395b7459d400d8da29570c3fb,
                    Res.drawable._5c0c8419f15b9472f1ee26bd0910024a435f0017,
                )
                repeat(3) { index ->
                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .offset(x = (index * 14).dp)
                            .zIndex(3f - index)
                    ) {
                        // Avatar border
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.Black, CircleShape)
                                .padding(1.5.dp)
                        ) {
                            // Avatar placeholder
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(0xFFDDDDDD), CircleShape)
                            ) {
                                Image(
                                    painter = painterResource(resource = followPhotos.get(2-index)),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }
                }
            }
            
            Text(
                text = followedByText,
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
                shape = RoundedCornerShape(3.dp),
                contentPadding = PaddingValues(vertical = 7.dp)
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
                
                // More options button
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White.copy(alpha = 0.2f)
                    ),
                    modifier = Modifier
                        .width(32.dp)
                        .height(30.dp),
                    shape = RoundedCornerShape(3.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ic_more_options),
                        contentDescription = "More options",
                        modifier = Modifier.size(14.dp),
                        colorFilter = ColorFilter.tint(Color.White)
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
            .padding(top = 5.dp)
            .height(76.dp)
            .background(Color.Black)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 9.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(5) { index ->
                ProfileSavedStoryItem(
                    label = "Text here",
                    imageResource = when (index) {
                        0 -> Res.drawable.story_1
                        1 -> Res.drawable.story_2
                        2 -> Res.drawable.story_3
                        3 -> Res.drawable.story_4
                        else -> Res.drawable.story_5
                    }
                )
            }
        }
    }
}

@Composable
fun ProfileSavedStoryItem(
    label: String,
    imageResource: DrawableResource
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(60.dp)
    ) {
        Box(
            modifier = Modifier.size(60.dp)
        ) {
            // Story circle border
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(1.dp, Color(0xFFC4C4C4), CircleShape)
            )
            
            // Story image container
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .align(Alignment.Center)
                    .background(Color.White, CircleShape)
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            letterSpacing = (-0.408).sp
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
                Image(
                    painter = painterResource(Res.drawable.ic_grid),
                    contentDescription = "Posts",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    colorFilter = ColorFilter.tint(Color.White)
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
                Image(
                    painter = painterResource(Res.drawable.ic_reels),
                    contentDescription = "Reels",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    colorFilter = ColorFilter.tint(Color(0xFFC4C4C4))
                )
            }
            
            // Tagged tab
            Box(
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(Res.drawable.ic_tagged),
                    contentDescription = "Tagged",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    colorFilter = ColorFilter.tint(Color(0xFFC4C4C4))
                )
            }
        }
    }
}

@Composable
fun ProfileGridPhotoView() {
    val gridPhotos = listOf(
        Triple(Res.drawable.post_1, PostType.NORMAL, null),
        Triple(Res.drawable.post_2, PostType.REELS, null),
        Triple(Res.drawable.post_3, PostType.CAROUSEL, null),
        Triple(Res.drawable.post_4, PostType.CAROUSEL, null),
        Triple(Res.drawable.post_5, PostType.NORMAL, null),
        Triple(Res.drawable.post_6, PostType.NORMAL, null),
        Triple(Res.drawable.post_7, PostType.REELS, null),
        Triple(Res.drawable.post_8, PostType.CAROUSEL, null),
        Triple(Res.drawable.post_9, PostType.NORMAL, null),
        Triple(Res.drawable.post_10, PostType.NORMAL, null),
        Triple(Res.drawable.post_11, PostType.REELS, null),
        Triple(Res.drawable.post_12, PostType.NORMAL, null),
        Triple(Res.drawable.post_13, PostType.CAROUSEL, null),
        Triple(Res.drawable.post_14, PostType.NORMAL, null),
        Triple(Res.drawable.post_15, PostType.NORMAL, null)
    )
    
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .border(width = 1.dp, color = Color(0xFFB4B4B4))
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            items(gridPhotos) { (imageResource, type, _) ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color(0xFFDFDFE8))
                ) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    
                    // Post type indicator
                    when (type) {
                        PostType.CAROUSEL -> {
                            Image(
                                painter = painterResource(Res.drawable.ic_carousel),
                                contentDescription = "Carousel",
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(4.dp)
                                    .size(12.dp),
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                        }
                        PostType.REELS -> {
                            Image(
                                painter = painterResource(Res.drawable.ic_reels_small),
                                contentDescription = "Reels",
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(4.dp)
                                    .size(12.dp),
                                colorFilter = ColorFilter.tint(Color.White)
                            )
                        }
                        else -> { /* No indicator for normal posts */ }
                    }
                }
            }
        }
    }
}

enum class PostType {
    NORMAL,
    REELS,
    CAROUSEL
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
            Image(
                painter = painterResource(Res.drawable.ic_home),
                contentDescription = "Home",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(Res.drawable.ic_add),
                contentDescription = "Create",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(Res.drawable.ic_heart),
                contentDescription = "Activity",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            
            // Profile avatar with notification dot
            Box {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                ) {
                    Image(
                        painter = painterResource(Res.drawable.profile_small),
                        contentDescription = "Profile",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                
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