package com.prototypebuilder.app.compose.values

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color




val GreyCustom = Color(0xFF5E5E5E)
val BlueCustom = Color(0xFF007AFF)
val DashYellow = Color(0xFFC7AF34)
val DashMode = Color(0xFFf2994a)
val Tangerine = Color(0xFFff9500)
val RideMode = Color(0xFF2f80ed)
val EcoMode = Color(0xFF219653)
val BrightLightBlue = Color(0xFF39c1ff)
val GreenishTeal = Color(0xFF34c780)
val CoolGreen = Color(0xFF34c759)
val AquaGreen = Color(0xFF29CAC0)
val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val DashThemeGreen = Color(0xFF17b384)
val BluePrimary = Color(0xFF007aff)
val IndicatorInActive = Color(0xFFc9c9c9)
val InActiveTab = Color(0xFFeeeeef)
val EditTextBackgroundUnFocused = Color(0xFFf2f3f7)
val EditTextOutline = Color(0xFF9a9a9a)
val Black_111 = Color(0XFF111111)
val NoInternetHeaderTwo = Color(0XFF3f414e)
val MainTextColor = Color(0XFF3f414e)
val ErrorTextColor = Color(0XFFff7d7d)
val ButtonInActive = Color(0XFFEEEEEF)
val TextInActive = Color(0XFFc9c9c9)
val TextInActiveLightColor =Color(0XFFeeeeef)
val ActiveOutline = Color(0XFF9a9a9a)
val TextSecondaryColor = Color(0XFF5e5e5e)
val SuccessColor = Color(0XFFA4FFB8)
val ErrorColor = Color(0XFFFFD8D8)
val SonicMode = Color(0XFFEB5757)
val DashboardWidgetsDarkColor = Color(0XFF2e2e2e)
val BottomBarBackgroundColor = Color(0xFF5E5E5E)
val BottomBarItemInactiveColor = Color(0xFF9A9A9A)
val PurpleBlur = Color(0XFFe0ddff)
val CheckBoxGreen = Color(0XFF1ea35f)
val PrimaryBlue = Color(0xff007AFF)
val ShimmerBackground = Color(0xFFF3F3F3)
val BatteryScreenCardBackground = Color(0xFF2E2E2E)
val ButtonSubTextColor = Color(0xCCFFFFFF)
val Tealish = Color(0XFF29cac0)
val TopSpeedColor = Color(0XFFEC385A)
val AverageSpeedPinkColor = Color(0XFFff2cb7)
val PeriWinkle = Color(0XFF7573ff)
val BlackNotificationBG = Color(0XFFF2F3F7)
val RedNotificationBG = Color(0XFFFFD8D8)
val WhiteNotificationBG = Color(0XFFF8F9F1)
val BlueNotificationBG = Color(0XFFC6FAFD)
val CriticalNotificationBorder = Color(0XFFFF2060)

@Immutable
data class CustomColorPack(
    /*
    applicationLevel
     */
    val primaryColor: Color,
    val colorPrimaryVariant: Color,
    val secondaryColor: Color,
    val purpleBlur: Color = PurpleBlur,
    val bluePrimary: Color = BluePrimary,
    val mainTextColor: Color = MainTextColor,
    val errorText: Color = ErrorTextColor,
    val buttonDisabledColor: Color = ButtonInActive,
    val textInActiveColor: Color = TextInActive,
    val textInActiveLightColor:Color = TextInActiveLightColor,
    val secondaryTextColor: Color = TextSecondaryColor,
    val shimmerBackground: Color = ShimmerBackground,

    /*
    Splash Screen
     */

    val splashBackground: Color = Black_111,

    /*
    walkthrough
     */
    val walkThroughBackground: Color = Color.White,
    val indicatorActive: Color = BluePrimary,
    val indicatorInActive: Color = IndicatorInActive,
    val inActiveTab: Color = InActiveTab,
    val editTextBackgroundUnFocused: Color = EditTextBackgroundUnFocused,
    val editTextOutline: Color = EditTextOutline,

    /*
    Phonenumber
     */
    val phoneNumberBackground: Color = Color.White,

    /*
     Email
    */
    val emailBackground: Color = Color.White,

    /*
    Otp Screen
     */
    val otpScreenBackground: Color = Color.White,

    /*
    Dashboard colors
    */
    val dashboardBackground: Color = Color.White,

    /*
    noInternet
     */
    val noInternetBackground: Color = Color.White,
    val noInternetHeaderTwo: Color = NoInternetHeaderTwo,

    /*
    Success screen
     */
    val successScreenBackground: Color = Color.White,

    /*
    emergency contacts

   */
    val emcBackground: Color = Color.White,
    val emcTheme2Green: Color = DashThemeGreen,
    /*
    transitions
     */
    val whiteToBlack: Color = Color.White,
    val blackToWhite: Color = Color.Black,

    /**
     * OTP Screen Colors
     * */
    val successOtpColor: Color = SuccessColor,
    val errorOtpColor: Color = ErrorColor,

    /*
     Dashboard Colors
     */
    val ecoModeColor: Color = EcoMode,
    val rideModeColor: Color = RideMode,
    val dashModeColor: Color = DashMode,
    val sonicModeColor: Color = SonicMode,


    val dashboardBackgroundColor: Color = Color.White,
    val brightLightBlue: Color = BrightLightBlue,
    val cardBorder: Color = ActiveOutline,
    val widgetsDarkColor: Color = DashboardWidgetsDarkColor,
    val coolGreen: Color = CoolGreen,
    val greenishTeal: Color = GreenishTeal,

    val tangerine: Color = Tangerine,
    val aquaGreen: Color = AquaGreen,
    val bottomBarInactiveColor: Color = BottomBarItemInactiveColor,
    val bottomBarBackgroundColor: Color = BottomBarBackgroundColor,

    /**
     * Battery and Range Colors
     * */
    val barBackgroundColor: Color = Color.White,
    val dashYellow: Color = DashYellow,
    val checkBoxGreen: Color = CheckBoxGreen,
    val primaryBlue: Color = PrimaryBlue,
    val batteryScreenCardBackground: Color = BatteryScreenCardBackground,

    /*
    Community Colors
     */
    val communityBackgroundColor: Color = Color.White,

    /*
    Map colors
     */
    val mapBackgroundColor: Color = Color.White,

    /*
    Address colors
     */
    val addressBackgroundColor: Color = Color.White,

    /*
    Profile Colors
     */
    val profileBackgroundColor: Color = Color.White,

    /*
    EditProfile Colors
     */
    val editProfileBackgroundColor: Color = Color.White,

    /*
    ManageVehicles Colors
     */
    val manageVehicleScreenBackground: Color = Color.White,

    /*
     VehicleCardAction
    */
    val vehicleCardActionBackground: Color = Color.White,

    /*
    vehicle settings colors
     */
    val headerThemeColor: Color = Color.White,
    val buttonSubTextColor: Color = ButtonSubTextColor,
    val editButtonColor: Color = DashboardWidgetsDarkColor,


    /*
    Ride Statistics colors
     */
    val downloadButtonBg: Color = CheckBoxGreen,
    val widgetsBackgroundDarkColor: Color = DashboardWidgetsDarkColor,
    val tealish: Color = Tealish,
    val topSpeedColor: Color = TopSpeedColor,
    val averageSpeedColor: Color = AverageSpeedPinkColor,
    val distanceCoveredColor: Color = PeriWinkle,
    val movingTimeColor: Color = Tangerine,
    val powerUsedWidgetTextColor: Color = BrightLightBlue,
    val chargingUnitsColor: Color = greenishTeal,


    /*
    Notifications
     */
    val notificationsBackground: Color = Color.White,
    val criticalNotificationBorder: Color = CriticalNotificationBorder
)

