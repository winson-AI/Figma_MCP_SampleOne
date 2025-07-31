package com.example.sampleone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import sampleone.composeapp.generated.resources.Res
import sampleone.composeapp.generated.resources.ic_battery
import sampleone.composeapp.generated.resources.ic_bookmark
import sampleone.composeapp.generated.resources.ic_comment
import sampleone.composeapp.generated.resources.ic_heart
import sampleone.composeapp.generated.resources.ic_home
import sampleone.composeapp.generated.resources.ic_like
import sampleone.composeapp.generated.resources.ic_message
import sampleone.composeapp.generated.resources.ic_more
import sampleone.composeapp.generated.resources.ic_reels
import sampleone.composeapp.generated.resources.ic_search
import sampleone.composeapp.generated.resources.ic_share
import sampleone.composeapp.generated.resources.ic_signal
import sampleone.composeapp.generated.resources.ic_verified
import sampleone.composeapp.generated.resources.ic_wifi
import sampleone.composeapp.generated.resources.main_post_image
import sampleone.composeapp.generated.resources.profile_small
import sampleone.composeapp.generated.resources.story_1
import sampleone.composeapp.generated.resources.story_2
import sampleone.composeapp.generated.resources.story_3
import sampleone.composeapp.generated.resources.story_4
import sampleone.composeapp.generated.resources.story_5

@Composable
fun FeedPostScreen(onAvatarClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Frame background color from Figma
    ) {
        // Status Bar - Height: 47dp
        FeedStatusBar()
        
        // Navigation Bar - Height: 40dp
        FeedNavigationBar()
        
        // Story Tray - Height: 105.75dp
        FeedStoryTray()
        
        // User Header - Height: 50dp  
        FeedUserHeader(onAvatarClick = onAvatarClick)
        
        // Main Post - Height: 390dp
        FeedMainPost()
        
        // Post Info - Height: 252dp
        FeedPostInfo()
        
        // Bottom Navigation - Height: 56dp
        FeedBottomNavigation()
        
        // Home Indicator - Height: 34dp
        FeedHomeIndicator()
    }
}

@Composable
fun FeedStatusBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)
            .background(Color.White)
    ) {
        // Time on left
        Text(
            text = "9:41",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 27.dp)
        )
        
        // Battery and wifi on right - using placeholders for now
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 27.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
                // SIGNAL icon - TODO: Replace with actual resource when build issues are resolved
                Image(
                    painter = painterResource(Res.drawable.ic_signal),
                    contentDescription = "SIGNAL",
                    modifier = Modifier.size(17.dp, 12.dp)
                )

                // Wifi icon - TODO: Replace with actual resource when build issues are resolved
                Image(
                    painter = painterResource(Res.drawable.ic_wifi),
                    contentDescription = "WiFi",
                    modifier = Modifier.size(17.dp, 12.dp)
                )

                // Battery icon - TODO: Replace with actual resource when build issues are resolved
                Image(
                    painter = painterResource(Res.drawable.ic_battery),
                    contentDescription = "Battery",
                    modifier = Modifier.size(17.dp, 12.dp)
                )
        }
    }
}

@Composable
fun FeedNavigationBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White)
    ) {
        // Logo dropdown on left
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Instagram",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            // Dropdown arrow placeholder - can be replaced with actual arrow icon
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(Color.Black)
            )
        }
        
        // Right icons
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        )
        {
            Image(
                painter = painterResource(Res.drawable.ic_heart),
                contentDescription = "Notifications",
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_message),
                contentDescription = "Messages",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun FeedStoryTray() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(106.dp) // 105.75dp rounded
            .background(Color.White)
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // First story with "Your Story" and add button
            item {
                FeedStoryItem(
                    username = "Ruffles",
                    avatarResource = Res.drawable.profile_small,
                    hasStory = false,
                    isFirstItem = true
                )
            }
            
            // Other stories with real avatar images
            items(
                listOf(
                    "sabanok..." to Res.drawable.story_2,
                    "blue_bouy" to Res.drawable.story_3,
                    "waggles" to Res.drawable.story_4,
                    "steve.loves" to Res.drawable.story_5,
                )
            ) { (username, avatarResource) ->
                FeedStoryItem(
                    username = username,
                    avatarResource = avatarResource,
                    hasStory = true,
                    isFirstItem = false
                )
            }
        }
    }
}

@Composable
fun FeedStoryItem(username: String, avatarResource: DrawableResource, hasStory: Boolean, isFirstItem: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(72.dp)
    ) {
        Box(
            modifier = Modifier.size(72.dp)
        ) {
            // Avatar - temporarily using placeholder until resource loading is fixed
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .background(Color(0xFFF0F0F0), CircleShape)
                    .border(
                        width = if (hasStory) 2.dp else 1.dp,
                        color = if (hasStory) Color(0xFFE91E63) else Color(0xFFDDDDDD),
                        shape = CircleShape
                    )
            ){
                Image(
                    painter = painterResource(avatarResource),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            
            // Add button for first item
            if (isFirstItem) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(Color(0xFF1FA1FF), CircleShape)
                        .align(Alignment.BottomEnd)
                ) {
                    Text(
                        text = "+",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = username,
            fontSize = 11.5.sp,
            color = if (isFirstItem) Color(0xFF6E6E6E) else Color.Black,
            modifier = Modifier.width(60.dp)
        )
    }
}

@Composable
fun FeedUserHeader(onAvatarClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 13.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Avatar placeholder - clickable
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(Color(0xFFF0F0F0), CircleShape)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDDDDD),
                        shape = CircleShape
                    )
                    .clickable { onAvatarClick() }
            )
            {
                Image(
                    painter = painterResource(Res.drawable.profile_small),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            
            Text(
                text = "Ruffles",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        
        // More options icon
        Image(
            painter = painterResource(Res.drawable.ic_more),
            contentDescription = "More options",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .size(24.dp)
        )
    }
}

@Composable
fun FeedMainPost() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(390.dp)
            .background(Color.White)
    ) {
        // Main post image
        Image(
            painter = painterResource(Res.drawable.main_post_image),
            contentDescription = "Post image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        
        // Carousel indicator in top right
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .size(30.dp, 22.dp)
                .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(12.dp))
        ) {
            Text(
                text = "3/5",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        
        // Tag icon in bottom left
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
                .size(24.dp)
                .background(Color.Black.copy(alpha = 0.5f), CircleShape)
        )
    }
}

@Composable
fun FeedPostInfo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(252.dp)
            .background(Color.White)
    ) {
        // Sponsor CTA - Height: 40dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFF1FA1FF))
        ) {
            Text(
                text = "CTA copy here",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 12.dp)
            )
            
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
                    .size(24.dp)
                    .background(Color.White)
            )
        }
        
        // Icons section - Height: 44dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .background(Color.White)
        ) {
            // Left icons
            Row(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            )
            {
                Image(
                    painter = painterResource(Res.drawable.ic_like),
                    contentDescription = "Like",
                    modifier = Modifier.size(24.dp)
                )
                Image(
                    painter = painterResource(Res.drawable.ic_comment),
                    contentDescription = "Comment",
                    modifier = Modifier.size(24.dp)
                )
                Image(
                    painter = painterResource(Res.drawable.ic_share),
                    contentDescription = "Share",
                    modifier = Modifier.size(24.dp)
                )
            }
            
            // Carousel dots in center
            Row(
                modifier = Modifier.align(Alignment.Center),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // Active dot
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(Color(0xFF32B5FF), CircleShape)
                )
                // Inactive dots
                repeat(4) { index ->
                    val size = when (index) {
                        0, 1 -> 8.dp
                        2 -> 5.dp
                        else -> 3.dp
                    }
                    Box(
                        modifier = Modifier
                            .size(size)
                            .background(Color(0xFFC4C4C4), CircleShape)
                    )
                }
            }
            
            // Right icon
            Image(
                painter = painterResource(Res.drawable.ic_bookmark),
                contentDescription = "Save",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 13.dp)
                    .size(24.dp)
            )
        }
        
        // Text section - Height: 144dp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)
                .background(Color.White)
                .padding(horizontal = 12.dp)
        ) {
            // Likes
            Text(
                text = "100 Likes",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // Caption
            Text(
                text = "Username Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt... more",
                fontSize = 14.sp,
                color = Color.Black,
                lineHeight = 17.sp
            )
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // View comments
            Text(
                text = "View all 16 comments",
                fontSize = 14.sp,
                color = Color(0xFF6E6E6E)
            )
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // Comment section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Comment avatar placeholder
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
                
                Spacer(modifier = Modifier.width(8.dp))
                
                Text(
                    text = "Add a comment...",
                    fontSize = 14.sp,
                    color = Color(0xFF6E6E6E),
                    modifier = Modifier.weight(1f)
                )
                
                // Reaction emojis
                Row(
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(text = "❤️", fontSize = 16.sp)
                    Text(text = "🙌", fontSize = 16.sp)
                    
                    // Add reactions button
                    Box(
                        modifier = Modifier
                            .size(12.dp)
                            .background(Color.White, CircleShape)
                            .border(1.dp, Color(0xFF6E6E6E), CircleShape)
                    ) {
                        Text(
                            text = "+",
                            fontSize = 8.sp,
                            color = Color(0xFF6E6E6E),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(6.dp))
            
            // Time stamp
            Text(
                text = "30 minutes ago",
                fontSize = 12.sp,
                color = Color(0xFF6E6E6E)
            )
        }
    }
}

@Composable
fun FeedBottomNavigation() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White)
    ) {
        // Divider line at top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black.copy(alpha = 0.1f))
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
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_reels),
                contentDescription = "Add",
                modifier = Modifier.size(24.dp)
            )
            Image(
                painter = painterResource(Res.drawable.ic_verified),
                contentDescription = "Activity",
                modifier = Modifier.size(24.dp)
            )
            
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
                ){
                    Image(
                        painter = painterResource(Res.drawable.profile_small),
                        contentDescription = "Activity",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun FeedHomeIndicator() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .width(134.dp)
                .height(5.dp)
                .background(Color.Black, RoundedCornerShape(100.dp))
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun FeedPostScreenPreview() {
    FeedPostScreen()
}