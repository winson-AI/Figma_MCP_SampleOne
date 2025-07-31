# Figma MCP Sample One - Instagram UI Implementation

This project demonstrates the implementation of Instagram-like UI designs from Figma into a Kotlin Multiplatform (KMP) Compose project using MCP (Model Context Protocol) tools.

## 🎨 Design Overview

The project implements two main screens from the Figma design:

### 1. Feed Post Screen
- **Status Bar**: Time display and system icons
- **Navigation Bar**: Instagram logo with action buttons
- **Story Tray**: Horizontal scrollable story items with user avatars
- **User Header**: Post author information with avatar
- **Post Content**: Main image with carousel indicators and tags
- **Post Info**: Like/comment/share buttons, post text, and comment input
- **Bottom Navigation**: Instagram-style tab bar
- **Home Indicator**: iOS-style home indicator

### 2. Profile Screen
- **Status Bar**: Dark theme with system information
- **Navigation Bar**: Back button, username with verified badge, action buttons
- **User Profile Data**: Avatar with story ring, stats (posts/followers/following)
- **Saved IG Stories**: Horizontal story tray
- **Promo Banner**: Shop now promotion banner
- **Tab Navigation**: Posts/Reels/Saved tabs
- **Grid Photo View**: 3-column photo grid with post type indicators
- **Bottom Navigation**: Instagram-style tab bar

## 🛠️ Technical Implementation

### Project Structure
```
composeApp/src/commonMain/kotlin/com/example/sampleone/
├── App.kt                 # Main application with navigation state
├── FeedPostScreen.kt      # Instagram feed post with clickable avatar
├── ProfileScreen.kt       # Instagram profile with back navigation
├── Platform.kt           # Platform-specific implementations
└── Greeting.kt           # Original sample component
```

### Key Features
- **Responsive Design**: Adapts to different screen sizes
- **Material Design 3**: Uses Material 3 theming and components
- **Compose UI**: Modern declarative UI framework
- **Kotlin Multiplatform**: Cross-platform compatibility
- **Figma Integration**: Direct design-to-code implementation with real assets
- **Asset Integration**: Real images, icons, and avatars from Figma designs
- **Navigation**: Interactive navigation between Feed Post and Profile screens
- **State Management**: Proper state handling for screen transitions

### Design System
- **Colors**: Instagram-inspired color palette
- **Typography**: Consistent text styles and sizes
- **Spacing**: 8dp grid system
- **Components**: Reusable UI components
- **Assets**: Real images, icons, and avatars from Figma designs
- **Asset Management**: Organized resource structure with proper naming

## 🚀 Getting Started

### Prerequisites
- Kotlin Multiplatform project setup
- Compose Multiplatform dependencies
- Android Studio or IntelliJ IDEA

### Running the Project
1. Clone the repository
2. Open the project in your IDE
3. Run the `composeApp` configuration
4. **Navigation**: Click on the avatar in the Feed Post screen to navigate to the Profile screen
5. **Back Navigation**: Click the back button in the Profile screen to return to Feed Post

### Build Configuration
The project uses Gradle with Kotlin DSL:
- **Target Platforms**: Android, iOS, Desktop
- **UI Framework**: Compose Multiplatform
- **Design Source**: Figma MCP integration

## 📱 Screenshots

### Feed Post Screen
- Instagram-style feed post with story tray
- User interaction elements (like, comment, share)
- Comment input with emoji reactions
- Bottom navigation bar

### Profile Screen
- User profile with avatar and stats
- Story highlights section
- Photo grid with post type indicators
- Action buttons (Follow, Message, Subscribe)

## 🔧 MCP Tools Used

### Figma Integration
- **TalkToFigma**: Design analysis and asset extraction
- **FigmaDevMode**: Code generation and asset mapping with real assets
- **Asset Management**: Downloaded and integrated real icons, images, and avatars
- **Asset Mapping**: Proper resource organization and naming conventions

### Development Tools
- **JetBrains IDE**: Project management and code editing
- **Kotlin Multiplatform**: Cross-platform development
- **Compose UI**: Modern UI framework

## 🎯 Design-to-Code Process

1. **Design Analysis**: Extract design specifications from Figma
2. **Asset Download**: Download real images, icons, and avatars from Figma
3. **Asset Integration**: Map downloaded assets to Compose UI components
4. **Component Creation**: Build reusable Compose components with real assets
5. **Layout Implementation**: Implement responsive layouts with proper asset scaling
6. **Interaction Design**: Add user interactions and state management
7. **Testing & Refinement**: Ensure design consistency and asset quality

## 📋 Future Enhancements

- [x] Add real images and icons from Figma assets
- [ ] Implement animations and transitions
- [ ] Add dark/light theme support
- [x] Implement actual navigation between screens
- [x] Add user interaction functionality
- [ ] Optimize for different screen sizes
- [ ] Add accessibility features
- [ ] Add more asset variations and states

## 🤝 Contributing

This project serves as a demonstration of Figma-to-Code workflow using MCP tools. Feel free to explore the implementation and adapt it for your own projects.

## 📄 License

This project is for educational and demonstration purposes.

---

**Note**: This implementation uses placeholder content and simplified interactions. In a production environment, you would integrate with real data sources and implement full user interactions.